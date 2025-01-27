package day19;

public class Ex01_String {

	public static void main(String[] args) {
		// 주어진 문자열에서 검색어가 몇 번 들어가있는지 확인하는 코드
		
		String str = "0000ab111ab222ab333aba4444ab555a";
		String serach = "ab";
		
		/* tmp에 str저장
		 * 반복 : index가 -1이 되면 종료
		 * tmp에서 search가 몇번지에 있는지 확인 : index
		 * index가 0 이상이면 index +1번지부터 부분문자열을 추출해서 tmp에 저장
		 * count 1증가
		 * */
		String tmp = str;
		int count=0;
		while(true) {
			int index = tmp.indexOf(serach);
			if(index == -1) {
				break;
			}
			int pos = index+serach.length();
			if(pos>= tmp.length()) {
				index =-1;
				continue;
			}
			//tmp = tmp.substring(index+1);
			tmp = tmp.substring(pos);
			System.out.println(tmp);
			count ++;
		}
		System.out.println(serach+" : "+count+"번 있음");
	}

}
