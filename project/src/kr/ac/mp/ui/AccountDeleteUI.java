package kr.ac.mp.ui;

import java.util.List;

public class AccountDeleteUI extends BaseUI {

	private List<Object> list = null;
	
	public AccountDeleteUI() {
		list = new AccountSelectUI().getList();
	}

	@Override
	public void execute() {
		
		if(list.size()==0) {
			System.out.println("해지할 계좌가 존재하지 않습니다.");
			new AccountUI().execute();
		}else {	
			acc= (new AccountSelectUI().accountSelect());
			if(acc.getAccount_money() > 0) {
				System.out.println("계좌에 잔액이 남아 있습니다 정말로 해지하겠습니까?");
				while(true) {	
					
					int sel = scanInt("1. 해지한다 \n2.해지하지 않는다");
					
					if (sel == 1) {
						bankser.delAccount(acc);
						break;
					} else if (sel == 2) {
						new AccountUI().execute();
					} else {
						System.out.println("1 또는 2를 입력하세요");
					}
				}
			}
			bankser.delAccount(acc);
		}
		
	}

}
