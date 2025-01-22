package day16;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Server {

	private Socket socket;
	private List<Post> list;

	public void run() {
		Thread t= new Thread(()->{
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				//클라이언트가 메뉴를 보내면 서버는 메뉴를 수신
				int menu;
				do {
					menu= ois.readInt();
					oos.flush();
					runMenu(menu, ois, oos);
				}while(menu!=5);
				
				
			} catch (IOException e) {
				System.out.println("[클라이언트 연결이 끊어졌습니다.]");
			}
			//수신한 메뉴에 따라 작업이 달라짐
		});
		t.start();
	}

	private void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 1:
			insert(ois,oos);
			break;
		case 2:
			update(ois,oos);
			break;
		case 3:
			delete(ois,oos);
			break;
		case 4:
			search(ois,oos);
			break;
		default:
			System.out.println("[잘못된 메뉴를 클라이언트가 전송함]");
		}

	}

	private void insert(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//게시글 객체 받고 리스트에 추가
			Post post = new Post ((Post) ois.readObject());
			
			oos.writeBoolean(list.add(post));
			oos.flush();
			System.out.println(list);
		} catch (Exception e) {
			System.out.println("서버 : 예외 발생");
		}
	}

	private void update(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//게시글의 번호를 받고 리스트 안에 있는지 확인
			int num = ois.readInt();
			boolean res= true;
			
			int index = list.indexOf(new Post(num)); 
			if(index == -1) { //없다면 false 전송 후 끝
				res = false;
				//oos.writeBoolean(res);
				//oos.flush();
				//return;
			}else {
			//있다면 수정 할 게시글 객체 받기
			String title = ois.readUTF();
			String content = ois.readUTF();
			
			//가져온 게시글의 제목과 내용을 수정
			Post post = list.get(index);
			post.setTitle(title);
			post.setContent(content);
			}
			//클라이언트에게 결과 전송
			oos.writeBoolean(res);
			oos.flush();
			System.out.println(list);
			oos.reset();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void delete(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//게시글의 번호를 받고 리스트 안에 있는지 확인
			int num = ois.readInt();
//			boolean res= true;
//			
//			int index = list.indexOf(new Post(num)); 
//			if(index == -1) { //없다면 false 전송 후 끝
//				res = false;
//				oos.writeBoolean(res);
//				oos.flush();
//				return;
//			}
//			//있다면 삭제
//			list.remove(new Post(num));
//			oos.writeBoolean(res);
			oos.writeBoolean(list.remove(new Post(num)));
			oos.flush();
			
			System.out.println(list);
			oos.reset();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void search(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
//			//일단 전체 게시글 전송
//			oos.writeObject(list);
//			oos.flush();
//			
//			if(list == null || list.isEmpty()) {
//				return;
//			}
			
			//게시글의 번호를 받고 리스트 안에 있는지 확인
			int num = ois.readInt();
			boolean res= true;
			
			int index = list.indexOf(new Post(num)); 
			if(index == -1) { //없다면 false 전송 후 끝
				//res = false;
				//oos.writeBoolean(res);
				oos.writeObject(null);
				oos.flush();
				return;
			}
			//있다면 조회
			Post post = list.get(index);
			post.view();
			System.out.println(list);
			oos.writeObject(post);
			oos.flush();
			oos.reset();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}





