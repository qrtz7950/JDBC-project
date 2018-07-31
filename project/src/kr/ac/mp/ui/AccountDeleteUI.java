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
			System.out.println("현재 소유하고 있는 계좌 현황은");
			bankser.listPrint();
			int accSel = scanInt("입니다 해지하고 싶은 번호를 입력하세요");
			accSel -= 1;
			acc = (AccountVO)(list.get(accSel));
			bankser.delAccount(acc);
		}
		
	}

}
