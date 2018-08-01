package kr.ac.mp.ui;

import java.util.ArrayList;
import java.util.List;

import kr.ac.mp.vo.AccountVO;
import kr.ac.mp.vo.AccountVOFactory;

public class AccountSelectUI extends BaseUI {

	private static AccountVO acc = AccountVOFactory.getInstance();
	private static String account;
	private List<Object> list = new ArrayList<Object>();

	public AccountSelectUI() {
		list=bankser.selAccount();
	}

	@Override
	public void execute() {
		
		if(list.size()==0) {
			System.out.println("계좌가 존재하지 않습니다.");
			new AccountUI().execute();
		}else {			
			accountSelect();
	
			I_BankUI ui = null;
	
			ui = new AccountTaskUI();
			ui.execute();
		}
	}
	
	public AccountVO accountSelect() {
		
		System.out.println("현재 소유하고 있는 계좌 현황은");
		bankser.listPrint();
		int accSel = scanInt("입니다 업무를 보고싶은 계좌를 입력하세요");
		accSel -= 1;

		if(accSel >= 0 && accSel <=list.size()) {
			System.out.print("선택하신 계좌는  ");
			acc.setId(((AccountVO) (list.get(accSel))).getId());
			acc.setAccount(((AccountVO) (list.get(accSel))).getAccount());
			acc.setAccount_money(((AccountVO) (list.get(accSel))).getAccount_money());
			System.out.println(acc);
			account = acc.getAccount();
		} else {
			System.out.println("1~" + list.size() + " 사이의 숫자를 입력해주세요");
			accountSelect();
		}

		return acc;
	}

	public String getAcc() {
		return account;
	}
	
	public List<Object> getList(){
		return list;
	}
	
}