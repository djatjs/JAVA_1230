package kr.kh.shoppingmall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import kr.kh.shoppingmall.model.vo.UserRole;
import kr.kh.shoppingmall.service.MemberDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Value("${spring.remember.me.key}")
	String rememberMeKey;

	@Autowired
	MemberDetailService memberDetailService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(requests->
			requests
				.requestMatchers("/admin/**")
				.hasAnyAuthority(UserRole.ADMIN.name())
				.anyRequest()
				.permitAll()
		)
		.formLogin(form->
			form
				.loginPage("/login") //html파일
				.permitAll()
				.loginProcessingUrl("/loginPost") //url주소
				.defaultSuccessUrl("/")
		)
		.rememberMe(rm-> rm
			.userDetailsService(memberDetailService)//자동 로그인할 때 사용할 userDetailService를 추가
			.key(rememberMeKey)//키가 변경되면 기존 토큰이 무효처리
			.rememberMeCookieName("LC")//쿠키 이름
			.tokenValiditySeconds(60 * 60 * 24 * 7)//유지 기간 : 7일
		)		

		
		.logout(logout->
			logout
				.logoutUrl("/logoutPost")
				.logoutSuccessUrl("/")
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.permitAll()
		);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
	}
}
