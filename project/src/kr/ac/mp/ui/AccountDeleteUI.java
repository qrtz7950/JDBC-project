package kr.ac.mp.ui;

import java.util.List;

import kr.ac.mp.vo.AccountVO;

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
			bankser.delAccount(acc);
		}
		
	}

}
