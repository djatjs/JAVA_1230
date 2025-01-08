package day07;

import java.util.Scanner;

public class Ex06_AccountBook {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*	가계부에 필요한 클래스 선언 ㄱㄱ
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 1
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 수입/지출 : 수입
		 * 분류 : 월급
		 * 내용 : 1월 월급
		 * 금액 : 100000
		 * 일시 : 2025-01-08
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 가계부 등록이 완료됨.
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 2
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 1. 수입/월급/1월 월급/100000/2025-01-08
		 * 수정할 내역의 번호 선택하세요 : 1
		 * 금액 : 200000
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 수정이 완료되었습니다.
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 4
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 1. 수입/월급/1월 월급/200000/2025-01-08
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 3
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 1. 수입/월급/1월 월급/200000/2025-01-08
		 * 삭제할 내역의 번호를 선택하세요 : 1
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 삭제 완료
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 5
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 프로그램 종료
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * */
		

		int menu, count=0;
		Item [] list = new Item [10];
		//샘플 데이터
		list[count++]= new Item("수입", "월급", "1월 월급", 1000000, "2025-01-08");
		list[count++]= new Item("지출", "식사", "점심 식사", 6500, "2025-01-08");
		list[count++]= new Item("지출", "월세", "2월 월세", 500000, "2025-01-08");
		list[count++]= new Item("지출", "월세", "3월 월세", 500000, "2025-01-08");
		list[count++]= new Item("지출", "월세", "4월 월세", 500000, "2025-01-08");
		list[count++]= new Item("지출", "월세", "5월 월세", 500000, "2025-01-08");
		list[count++]= new Item("지출", "월세", "6월 월세", 500000, "2025-01-08");
		list[count++]= new Item("지출", "월세", "7월 월세", 500000, "2025-01-08");
		list[count++]= new Item("지출", "월세", "8월 월세", 500000, "2025-01-08");
		list[count++]= new Item("지출", "월세", "9월 월세", 500000, "2025-01-08");
		
		do {
			printMenu();
			menu = scan.nextInt();
			
			drawLine();
			switch(menu) {
			case 1:
				//내역 정보 입력
				System.out.print("수입/지출 : ");
				String income= scan.next();
				System.out.print("분류 : ");
				String type= scan.next();
				System.out.print("내용 : ");
				scan.nextLine();//next()에서 입력한 엔터를 처리. 단어와 단어 사이에 공백이 있으면 끊어서 가져감. 그래서 nextLine을 사용함.
				String content= scan.nextLine();
				System.out.print("금액 : ");
				int money= scan.nextInt();
				System.out.print("일시 : ");
				String date= scan.next();
				
				//내역 리스트에 추가
				list[count++]= new Item(income, type, content, money, date);
				drawLine();
				break;
			case 2:
				//내역들을 출력
				if(count ==0) {
					System.out.println("내역이 없어요");
					drawLine();
					break;
				}
				for(int i=0; i<count; i++) {
					list[i].print(i+1);
				}
				//수정할 내역의 숫자를 입력
				System.out.print("수정할 내역의 번호 선택하세요 : ");
				int index = scan.nextInt()-1;
				//금액 입력
				System.out.print("금액 : ");
				int chageMoney = scan.nextInt();
				//(입력받은 숫자-1)번지에 있는 금액을 수정
				list[index].money=chageMoney;
				System.out.println("수정이 완료되었습니다.");
				drawLine();
				break;
			case 3:
				//내역들을 출력
				if(count ==0) {
					System.out.println("내역이 없어요");
					drawLine();
					break;
				}
				for(int i=0; i<count; i++) {
					list[i].print(i+1);
				}
				//삭제할 내역의 숫자를 입력(번지 파악)
				System.out.print("삭제할 내역의 숫자 : ");
				index = scan.nextInt()-1;
				
				//입력받은 숫자번지부터 앞으로 한칸씩 당김
				for(int i=index; i<count-1;i++) {
					// ex)count는2인 상태(0,1,2). 3번째 항목을 선택함. ->index는 2번지에 있는건데 이걸 없앤다는거임. 일단 당겨. 못당겨.
					list[i]=list[i+1];
				}
				System.out.println("삭제되었습니다.");
				drawLine();
				//개수를 1감소
				count--;
				break;
			case 4:
				// 반복문을 이용하여 저장된 내역들을 숫자와 함께 출력. 숫자는 1부터 시작.
				if(count ==0) {
					System.out.println("내역이 없어요");
					drawLine();
					break;
				}
				for(int i=0; i<count; i++) {
					list[i].print(i+1);
				}
				drawLine();
				break;
			case 5:
				System.out.println("프로그램 종료");
				drawLine();
				break;
			default:
				System.out.println("잘못된 입력");
				drawLine();
			}
			
		}while(menu !=5);
		
		
	}
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 가계부 등록");
		System.out.println("2. 가계부 수정");
		System.out.println("3. 가계부 삭제");
		System.out.println("4. 가계부 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

	public static void drawLine() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	
	
	
}
class Item{
	//true일 때 수입, false일 때 지출
	String income; 
	String type;
	String content;
	int money;
	String date;
	
	public void print() {
		System.out.println(income+"/"+type+"/"+content+"/"+money+"/"+date);
	}
	public void print(int num) {
		System.out.print(num + ". ");
		print();
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public Item(String income, String type, String content, int money, String date) {
		this.income = income;
		this.type = type;
		this.content = content;
		this.money = money;
		this.date = date;
	}
	
}