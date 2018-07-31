package kr.ac.mp.vo;

public class AccountVOFactory {
	
	private static final AccountVO instance = new AccountVO();
	
	public static AccountVO getInstance() {
		return instance;
	}
	
}
