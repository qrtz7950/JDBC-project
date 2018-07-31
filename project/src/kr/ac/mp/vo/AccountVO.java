package kr.ac.mp.vo;

public class AccountVO {
	private String id;
	private String account;
	private int account_money;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAccount_money() {
		return account_money;
	}

	public void setAccount_money(int account_money) {
		this.account_money = account_money;
	}

	@Override
	public String toString() {
		return account + "  " + account_money + "원";
	}
	
	
	
	
	
}
