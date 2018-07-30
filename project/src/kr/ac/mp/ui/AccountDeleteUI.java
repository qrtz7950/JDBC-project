package kr.ac.mp.ui;

import java.util.ArrayList;
import java.util.List;

public class AccountDeleteUI extends BaseUI {

	private List<Object> list = new ArrayList<Object>();
	
	@Override
	public void execute() {
		
		System.out.println("현재 소유하고 있는 계좌 현황은");
		
		list = bankser.selAccount();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		String account = scanString("입니다 해지하고 싶은 계좌를 입력하세요");
		
		bankser.delAccount(account);
		//뱅크 객체 날려줄 메소드 필요
		
	}

}
