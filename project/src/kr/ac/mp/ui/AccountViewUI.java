package kr.ac.mp.ui;

import java.util.List;

public class AccountViewUI extends BaseUI{
	
	@Override
	public void execute() {
		
		List<Object> list = bankser.selAccount();
		
		if(list.size()==0) {
			System.out.println("해지할 계좌가 존재하지 않습니다.");
			new AccountUI().execute();
		}else {	
			System.out.println("현재 소유하고 있는 계좌 현황은");
			bankser.listPrint();
		}
		
	}

}
