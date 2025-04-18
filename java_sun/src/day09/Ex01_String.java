package day09;

public class Ex01_String {

	public static void main(String[] args) {
		// 파일명이 주어졌을 때 파일이 이미지인지 아닌지 확인하는 코드를 작성하세여.
		
		String fileName = "test.png";
		String imgs[]=new String[] {"jpg", "bmp","gif","png"};
		
		// txt추출 : lastIndexOf, substring
		
		String str = fileName.substring(3,fileName.length());
		System.out.println(str);
		
		// 확장자를 추출하기 위해서 뒤에서 첫 .의 위치를 찾음
		int index = fileName.lastIndexOf(".");
		// 파일명에 .이 없으면 이미지가 아님
		if(index<0) {
			System.out.println(fileName+"은 이미지 파일이 아닙니다");
			return;
		}
		// 찾은 . 다음부터 문자열을 추출하여 확장자를 가져옴
		String prefix = fileName.substring(index+1);
		// 반복문을 통해 추출한 문자열이 배열에 있는지 확인
		// 향상된 for문을 이용해 equals를 이용하여 비교하고, 같으면 변수에 true저장
		boolean result = false;
		for (String img : imgs) {
			// 이미지 확장자와 추출한 확장자가 같으면(이미지면)
			if(img.equals(prefix)) {
				result = true;
				break;
			}
		}
		if(result) {
			System.out.println(fileName+"은 이미지 파일이 맞습니다");
		}
		else {
			System.out.println(fileName+"은 이미지 파일이 아닙니다");
		}
		
		//변수가 true면 이미지, 아니면 아니라고 출력.
		
		
		


	}

}
