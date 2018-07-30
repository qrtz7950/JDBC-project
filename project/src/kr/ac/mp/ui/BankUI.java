package kr.ac.mp.ui;

public class BankUI extends BaseUI {

	@Override
	public void execute() {
		
	I_BankUI ui = null;
	
	while(true) {
		int type = menu();
		switch (type) {
		case 1:
			ui =  new SignUI(); 
			break;
		case 2:
			ui = new LoginUI();
			break;
		case 0:
			ui = new ExitUI();
			break;
		}
		if(ui != null)
			ui.execute();
		else
			System.out.println("그런 숫자는 없잖아요 다시선택하세요");
		}
	}
	
	private int menu() {
		System.out.println("------------------------------------------");
		System.out.println("\t\t뱅킹 시스템");
		System.out.println("------------------------------------------");
		System.out.println("1.가입");
		System.out.println("2.로그인");
		System.out.println("0.종료");
		int type = scanInt("메뉴를 선택하세요");
		
		return type;
	}
}
