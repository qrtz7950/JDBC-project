package kr.ac.mp.ui;

import java.util.ArrayList;
import java.util.List;

import kr.ac.mp.vo.AccountVO;

public class AccountSelectUI extends BaseUI {
	
	private static AccountVO acc = new AccountVO();
	private String account;
	private List<Object> list = new ArrayList<Object>();
	
	@Override
	public void execute() {
		
		System.out.println("현재 소유하고 있는 계좌 현황은");
		
		list = bankser.selAccount();
		
		int accSel = scanInt("입니다 업무를 보고싶은 계좌를 입력하세요");
		
		System.out.print("선택하신 계좌는  ");
		acc = (AccountVO) list.get(accSel);
		
		I_BankUI ui = null;
		
		ui = new AccountTaskUI();
		ui.execute();
	}
	
	public String getaCC() {
		return account;
	}
}
