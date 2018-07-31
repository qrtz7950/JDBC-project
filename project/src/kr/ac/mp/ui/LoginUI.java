package kr.ac.mp.ui;

public class LoginUI extends BaseUI {

	private String id;
	private String password;
	I_BankUI ui = null;
	
	@Override
	public void execute() {
		
		boolean bool = false;
		
		System.out.println("로그인을 진행합니다");
		id 		 =  scanString("ID를 입력하세요: ");
		password =  scanString("비밀번호를 입력하세요: ");
		
		bank.setId(id);
		bank.setPassword(password);
				
		bool = bankser.login(bank);
		
		if (!bool) {
			System.out.println("아이디 또는 비밀번호를 확인해주세요");
			System.out.println("다시 로그인 하시겠습니까?");
			System.out.println("1. 다시 로그인 시도");
			System.out.println("2. 이전으로");
			int sel = scanInt("메뉴를 선택해주세요");
				if(sel == 1) {
					execute();
				} else {
					new BankUI().execute();
				}
			} else {
			System.out.println(bank.getName() + "님 환영합니다");
			new AccountUI().execute();
		}
		
	}

}
