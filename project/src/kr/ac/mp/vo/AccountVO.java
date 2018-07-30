package kr.ac.mp.vo;

public class AccountVO {
	private String id;
	private String account;
	private String account_money;

	public AccountVO() {
	}

	public AccountVO(String id, String account, String account_money) {
		super();
		this.id = id;
		this.account = account;
		this.account_money = account_money;
	}

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

	public String getAccount_money() {
		return account_money;
	}

	public void setAccount_money(String account_money) {
		this.account_money = account_money;
	}

	@Override
	public String toString() {
		return account + "  " + account_money + "원";
	}
	
	
	
	
	
}
