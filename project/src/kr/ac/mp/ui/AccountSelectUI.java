package kr.ac.mp.ui;

import java.util.ArrayList;
import java.util.List;

import kr.ac.mp.vo.AccountVO;

public class AccountSelectUI extends BaseUI {

	private static AccountVO acc = new AccountVO();
	private static String account;
	private List<Object> list = new ArrayList<Object>();

	@Override
	public void execute() {

		accountselect();

		I_BankUI ui = null;

		ui = new AccountTaskUI();
		ui.execute();
	}
	
	public void accountselect() {
		
		System.out.println("현재 소유하고 있는 계좌 현황은");

		list = bankser.selAccount();

		int accSel = scanInt("입니다 업무를 보고싶은 계좌를 입력하세요");
		accSel -= 1;

		System.out.print("선택하신 계좌는  ");
		acc = (AccountVO) (list.get(accSel));
		System.out.println(list.get(accSel));

		account = acc.getAccount();
		
	}

	public String getAcc() {
		return account;
	}
}