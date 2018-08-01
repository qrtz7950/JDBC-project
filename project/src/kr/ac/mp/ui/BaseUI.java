package kr.ac.mp.ui;

import java.util.Scanner;

import kr.ac.mp.service.BankService;
import kr.ac.mp.service.BankServiceFactory;
import kr.ac.mp.vo.AccountVO;
import kr.ac.mp.vo.AccountVOFactory;
import kr.ac.mp.vo.BankVO;
import kr.ac.mp.vo.LoanVO;

public abstract class BaseUI implements I_BankUI {

	private Scanner sc;
	protected BankService bankser;
	protected BankVO bank;
	protected AccountVO acc;
	protected LoanVO loanV; 		
	
	public BaseUI() {
		sc = new Scanner(System.in);
		bankser = BankServiceFactory.getInstance();
		bank = new BankVO();
		acc = AccountVOFactory.getInstance();
		loanV = new LoanVO();
	}
	
	protected int scanInt(String msg) {
		String temp = null;
		System.out.print(msg);
		int sel = 0;
		try {
			do {
				System.out.println("\n숫자만 입력해주세요");
				temp = sc.nextLine();
			} while(!checkInt(temp));
			sel = Integer.parseInt(temp);
		} catch (Exception e) {
			System.out.println("입력란이 비어있습니다");
			sel = scanInt(msg);
		}
		
		
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
