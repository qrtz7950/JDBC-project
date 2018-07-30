package kr.ac.mp.ui;

import java.util.ArrayList;
import java.util.List;

public class AccountSelectUI extends BaseUI {

	private List<Object> list = new ArrayList<Object>();
	
	@Override
	public void execute() {
		
		System.out.println("현재 소유하고 있는 계좌 현황은");
		
		list = bankser.selAccount();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
				
		String account = scanString("입니다 업무를 보고싶은 계좌번호를 입력하세요");
		
		acc = bankser.selAccount(account);
	}

}
