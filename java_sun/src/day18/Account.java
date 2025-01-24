package day18;

import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class Account {
	
	//은행. 이름. 계좌번호. 비밀번호
	private Bank bank;
	private String name;
	private String accountNum, password;
	private int money=0;

	List<Item> list;// 입출금 내역
	
	//로그인
	public Account(Bank bank, String name, String accountNum,String password) {
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
	
	
}
