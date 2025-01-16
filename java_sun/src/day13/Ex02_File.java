package day13;

import java.io.File;
import java.io.IOException;

public class Ex02_File {

	public static void main(String[] args) {
		String fileName = "src/day13/test.txt";
		File file = new File(fileName);
		
		/* exists() : 파일(폴더)가 실제 있는지를 알려줌
		 * isDirectory() : 폴더인지를 알려줌
		 * isFile() : 파일인지를 알려줌
		 * delete() : 파일을 삭제하고 삭제 여부를 알려줌
		 * getName() : 파일명을 알려줌
		 * getAbsolutePath() : 절대 경로를 알려줌
		 * getPath() : 상대 경로를 알려줌
		 * */
		if(file.exists()) {
			System.out.println("존재함");
			
			if(file.isDirectory()) {
				System.out.println("폴더입니다.");
			}
			else if (file.isFile()) {
				System.out.println("파일입니다.");
			}
			
			System.out.println("파일명 : "+file.getName());
			System.out.println("절대 경로 : "+file.getAbsolutePath());
			System.out.println("상대 경로 : "+file.getPath());
			if(file.delete()) {
				System.out.println("파일이 삭제됨");
			}
			else {
				System.out.println("파일 삭제 실패");
			}
			return;
		}
		
		System.out.println("존재하지 않음.");
		
		// mkdir() : 폴더를 생성하고 생성 여부를 알려줌
//		if(file.mkdir()) {
//			System.out.println("폴더가 생성되었습니다.");
//		}
//		else {
//			System.out.println("폴더가 이미 있거나 생성에 실패했습니다.");
//		}
		
		//createNewFile() : 파일을 생성하고 생성 여부를 알려줌
		try {
			if(file.createNewFile()) {
				System.out.println("파일이 생성되었습니다.");
			}
			else {
				System.out.println("파일 생성에 실패했습니다.");
			}
		} catch (IOException e) {
			System.out.println("파일 생성과정에서 예외 발생");
			e.printStackTrace();
		}

	}

}
