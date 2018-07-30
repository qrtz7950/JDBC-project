package kr.ac.mp.ui;

import kr.ac.mp.vo.BankVO;

public class LoginUI extends BaseUI {

	private String id;
	private String password;
	I_BankUI ui = null;
	
	@Override
	public void execute() {
		
		System.out.println("로그인을 진행합니다");
		id 		 =  scanString("ID를 입력하세요: ");
		password =  scanString("비밀번호를 입력하세요: ");
		
		bank.setId(id);
		bank.setPassword(password);
				
		bank = bankser.login(bank);
		
		if (bank == null) {
			System.out.println("로그인 정보가 틀립니다");
			System.out.println("다시 로그인 하시겠습니다?");
			System.out.println("1.다시 로그인 한다");
			System.out.println("2.메인메뉴로 돌아간다");
			int re = scanInt("1 or 2 : ");
			if (re == 1) {
				execute();
			} else {
				System.out.println("메인메뉴로 돌아갑니다");
				ui = new BankUI();
				ui.execute();
			}
		} else {
			ui = new AccountUI();
			ui.execute();
		}
		
	}

}