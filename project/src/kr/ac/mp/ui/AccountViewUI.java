package kr.ac.mp.ui;

import java.util.ArrayList;
import java.util.List;

public class AccountViewUI extends BaseUI{

	private List<Object> list = new ArrayList<Object>();
	
	@Override
	public void execute() {
		System.out.println("현재 소유하고 있는 계좌 현황입니다");
		
		list = bankser.selAccount();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
