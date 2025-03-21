package kr.kh.spring.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

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
	@Controller
	public class Test1Controller {

		@GetMapping("/test1")
	    public String test1(Model model) {
	        try {
	            // API URL
	            String url = "https://data.metatft.com/lookups/Set8_latest_ko_kr.json";

	            // RestTemplate을 사용하여 HTTP 요청
	            RestTemplate restTemplate = new RestTemplate();
	            HttpHeaders headers = new HttpHeaders();
	            headers.add("Accept-Charset", "UTF-8");

	            HttpEntity<String> entity = new HttpEntity<>(headers);
	            ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

	            if (response.getStatusCode() == HttpStatus.OK) {
	                // 한글 깨짐 방지 (UTF-8로 변환)
	                String jsonData = new String(response.getBody(), StandardCharsets.UTF_8);

	                // JSON 객체 변환
	                JSONObject jsonObject = new JSONObject(jsonData);
	                JSONArray units = jsonObject.getJSONArray("units"); // "units" 배열 가져오기

	                // 유닛 정보 리스트 생성
	                List<Map<String, Object>> unitList = new ArrayList<>();

	                for (int i = 0; i < units.length(); i++) {
	                    JSONObject unit = units.getJSONObject(i);
	                    Map<String, Object> unitMap = new HashMap<>();

	                    unitMap.put("name", unit.getString("name")); // 유닛 이름
	                    unitMap.put("traits", unit.getJSONArray("traits").toList()); // traits 리스트 변환
	                    unitMap.put("cost", unit.getInt("cost")); // 코스트
	                    unitMap.put("icon", "https://data.metatft.com/" + unit.getString("icon"));

	                    unitList.add(unitMap);
	                }

	                // JSP로 전달
	                model.addAttribute("unitList", unitList);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            model.addAttribute("unitList", new ArrayList<>()); // 오류 발생 시 빈 리스트 전달
	        }

	        return "home1"; // home.jsp 페이지로 이동
	    }
	}
}
