package day14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import lombok.Data;

public class Ex01_Post {
	
	static	Scanner scan = new Scanner(System.in);
	static ArrayList<Post> list = new ArrayList<Post>();
	public static void main(String[] args) {
		/* 게시글 프로그램을 위한 클래스 선언
		 * 게시글 등록
		 * - 제목, 내용, 작성자 입력
		 * 게시글 수정
		 * - 게시글 번호 선택
		 * - 제목, 내용을 수정
		 * 게시글 삭제
		 * - 게시글 번호를 선택해서 삭제
		 * 게시글 조회
		 * - 게시글 번호를 이용하여 조회하고 조회수 1증가
		 * */
		
		String fileName = "src/day14/post.txt";
		
		//불러오기 dk 이거 하다가 하자생김;
		list = (ArrayList<Post>)load(fileName); 
		
		if(list == null || list.size()==0) {
			list = new ArrayList<Post>();
		}
		else {
			int lastIndex = list.size()-1;
			Post lastPost = list.get(lastIndex);
			int lastNum = lastPost.getNum();
			Post.setCount(lastNum+1);
		}
		
		
		int menu=0;
		do {
			try {
				printMenu();
				menu = scan.nextInt();
				scan.nextLine();
				runMenu(menu);
			}catch (Exception e) {
				System.out.println("잘못된 입력");
				scan.nextLine();
			}
			
		}while(menu!=5);
		
		//저장하기
		save(fileName, list);
	}
	private static  Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				
				return ois.readObject();
				
			} catch (Exception e) {
				System.out.println("-----------------");
				System.out.println("불러오기 실패");
				System.out.println("-----------------");
			}
			return null;
		
	}
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				oos.writeObject(obj);
				
			} catch (Exception e) {
				System.out.println("-----------------");
				System.out.println("저장하기 실패");
				System.out.println("-----------------");
			}
		
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			regiseterPost();
			break;
		case 2:
			editPost();
			break;
		case 3:
			deletePost();
			break;
		case 4:
			viewPost();
			break;
		case 5:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}
	private static void regiseterPost() {
		Post tmp = insertInfo();
		//근데 중복글은 허용되는게 게시판이긴한데
		list.add(tmp);
	}
	private static void editPost() {
		//번호 입력받기
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
		
		//번호랑 일치하는 게시글 있는지 확인후 없으면 알림 후 종료
//		for(Post tmp : list) {
//			if(tmp.getNum()==num) {
//				System.out.println("게시글 수정");
//				scan.nextLine();
//				Post newPost = insertInfo2();
//				int index = num-1;
//				Post tmpPost = list.get(index);
//				tmpPost.setTitle(newPost.getTitle());
//				tmpPost.setContent(newPost.getContent());
//				tmpPost.setDate(newPost.getDate());
//				
//				list.set(index, tmpPost);
//				System.out.println("수정 완료");
//				return;
//			}else {
//				System.out.println("해당 번호의 게시글 없음");
//			}
//		}
		
		//다른 방식
		//Objects.equals(o1, o2) => o1과 o2가 다른 클래스이면 무조건 false이므로 indexOf를 할 때 그 안에 new Post(num)으로 한거.
		int index= list.indexOf(new Post(num)); 
		if(index == -1) {
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		scan.nextLine();
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		Post post = list.get(index);
		post.setTitle(title);
		post.setContent(content);
		
	}
	private static void deletePost() {
		//번호 입력받기
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
				
//		for(Post tmp : list) {
//			if(tmp.getNum()==num) {
//				list.remove(tmp);
//				System.out.println("삭제 완료");
//				return;
//			}else {
//				System.out.println("해당 번호의 게시글 없음");
//			}
//		}
//		
//		//다른 방식1
//		int index1= list.indexOf(new Post(num));
//		if(index1 == -1) {
//			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
//			return;
//		}
//		list.remove(index1);
		
		//다른 방식2
		if(list.remove(new Post(num))) {
			System.out.println("삭제 완료");
			return;
		}
		System.out.println("등록되지 않거나 삭제된 게시글입니다.");

	}
	private static void viewPost() {
		
		
		//번호 입력받기
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
				
		//num이 list의 크기보다 크면 잘못입력했다고 말하고 취소
//		if(num==0 || num>list.size()) { 	//1번글 등록 직후 : 크기 1
//			System.out.println("잘못된 입력");
//			return;
//		}
		
//		for(Post tmp : list) {
//			if(tmp.getNum()==num) {
//				tmp.view(); //tmp.setView(tmp.getView+1);
//				tmp.print();
//				return;
//			}
//			else {
//				System.out.println("해당 번호의 게시글 없음");
//			}
//		}
		
		//다른 방식
		int index= list.indexOf(new Post(num));
		if(index == -1) {
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		
		Post post = list.get(index);
		post.view();
		post.print();
		
		
		
	}
	
	public static void printMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 종료");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("입력 : ");
	}
	
	public static Post insertInfo() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.nextLine();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Post tmp = new Post(title, content, writer);
		return tmp;
		
	}
	//수정용 생성자 : 작성자는 그대로
	public static Post insertInfo2() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Post tmp = new Post(title, content);
		return tmp;
	}

}
@Data
class Post implements Serializable{
	
	private static final long serialVersionUID = 5151278757453770454L;
	private static int count; //게시글 번호
	private int num;
	private String title,content,writer;//제목 작성자 내용
	private int view; //조회수
	private Date date; //작성일
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return num == other.num;
	}

	//조회수 업
	public void view() {
		view++;
	}

	public Post(String title, String content, String writer) {
		num= ++count;
		this.title = title;
		this.writer = writer;
		this.content = content;
		date = new Date();
	}
	
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
		date = new Date();
	}
	
	//다른 방식용
	public Post(int num) {
		this.num = num;
	}


	public void print() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("번호 : "+num);
		System.out.println("제목 : "+title);
		System.out.println("내용 : "+content);
		System.out.println("작성자 : "+writer);
		System.out.println("작성일 : "+getDateStr());
		System.out.println("조회수 : "+view);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		
	}
	
	private String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(date);
		return str;
	}

	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Post.count =count;
	}
	
}
