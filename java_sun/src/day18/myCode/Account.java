package day18.myCode;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Account implements Serializable{
	

	private static final long serialVersionUID = -7073336508551715046L;
	//은행. 이름. 계좌번호. 비밀번호
	private String bank;
	private String name;
	private String accountNum, password;
	private int money=0;

	
	//로그인
	public Account(String bank, String name, String accountNum,String password) {
		this.bank = bank;
		this.name = name;
		this.accountNum = accountNum;
		this.password = password;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNum, bank, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountNum, other.accountNum) && Objects.equals(bank, other.bank)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}

	public Object getPassword() {
		return password;
	}
	
	public void print() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("은행 : "+bank);
		System.out.println("이름 : "+name);
		System.out.println("계좌번호 : "+accountNum);
		System.out.println("금액 : "+money);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	
}
