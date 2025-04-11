package kr.kh.spring2.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.MemberDAO;
import kr.kh.spring2.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		if(member.getMe_id() ==null || !Pattern.matches("^[a-zA-Z0-9]{3,13}$", member.getMe_id())) {
			return false;
		}
		if(member.getMe_pw() ==null || !Pattern.matches("^[a-zA-Z0-9!@#$]{3,15}$", member.getMe_pw())) {
			return false;
		}
		try {
			//비번 암호화
			String encPw = passwordEncoder.encode(member.getMe_pw());
			member.setMe_pw(encPw);
			return memberDao.insertMember(member);
		}catch (Exception e) {
			e.printStackTrace();
			//중복검사 안했을 경우
			return false;
		}
	}

	@Override
	public MemberVO login(MemberVO member) {
		//null 체크
		if(member == null) {
			return null;
		}
		//아이디 일치하는지 확인
		MemberVO user =  memberDao.selectMember(member);
		if(user == null) {
			return null;
		}
		//비번(암호화) 일치하는지 확인
		if(!passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return null;
		}
		System.out.println(user);
		return user;
	}
}
