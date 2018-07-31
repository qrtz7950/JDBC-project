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
		String temp;
		System.out.print(msg);
		
		do {
			System.out.println(" 숫자만 입력해주세요");
			temp = sc.nextLine();
		} while(!checkInt(temp));
		
		int sel = Integer.parseInt(temp);
		
		return sel;
	}
	
	protected String scanString(String msg) {
		
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
	
	private boolean checkInt(String textInput) {

		char chrInput;
						
		for (int i = 0; i < textInput.length(); i++) {
			chrInput = textInput.charAt(i);
			if (chrInput >= 0x30 && chrInput <= 0x39) {
			} else {
				return false;
			}
		}
		return true;
	}
	
}
