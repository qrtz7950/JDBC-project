package kr.ac.mp.ui;

import java.util.Scanner;

import kr.ac.mp.service.BankService;
import kr.ac.mp.service.BankServiceFactory;
import kr.ac.mp.vo.AccountVO;
import kr.ac.mp.vo.BankVO;

public abstract class BaseUI implements I_BankUI {

	private Scanner sc;
	protected BankService bankser;
	protected BankVO bank;
	protected AccountVO acc;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		bankser = BankServiceFactory.getInstance();
		bank = new BankVO();
		acc = new AccountVO();
	}
	
	protected int scanInt(String msg) {
		
		System.out.println(msg);
		int sel = Integer.parseInt(sc.nextLine());
		return sel;
	}
	
	protected String scanString(String msg) {
		
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
	
}
