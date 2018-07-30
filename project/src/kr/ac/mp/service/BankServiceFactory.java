package kr.ac.mp.service;

public class BankServiceFactory {
	
	private static final BankService instance = new BankService();
	
	public static BankService getInstance() {
		return instance;
	}
	
}