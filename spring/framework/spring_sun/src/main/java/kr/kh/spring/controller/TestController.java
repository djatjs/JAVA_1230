package kr.kh.spring.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test")
	public String test() {
		try {
            // API URL
            String url = "https://data.metatft.com/lookups/Set8_latest_ko_kr.json";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // GET 요청 설정
            con.setRequestMethod("GET");

            // 응답 코드 확인
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 성공
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // JSON 데이터 처리
                JSONObject myResponse = new JSONObject(response.toString());
                System.out.println(myResponse.toString(2)); // 예쁘게 출력
            } else {
                System.out.println("GET 요청 실패: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "/home";
	}
}
