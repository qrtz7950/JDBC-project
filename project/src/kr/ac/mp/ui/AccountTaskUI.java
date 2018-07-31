package kr.ac.mp.ui;

public class AccountTaskUI extends BaseUI {
	
	public void execute() {

		int type = menu();
		I_BankUI ui = null;
		
		switch(type) {
		case 1:
			ui =  new ViewUI();
			break;
		case 2:
			ui = new SendMoneyUI();
			break;
		case 3:
			ui = new AccountUI();
			break;
		case 0:
			ui = new ExitUI();
			break;
		}
		if(ui != null) {
			ui.execute();
		}
		else {
			System.out.println("그런 숫자는 없잖아요 다시선택하세요");
		}
	}


	private int menu() {
		
		System.out.println("------------------------------------------");
		System.out.println("\t\t은행 업무 메뉴");
		System.out.println("------------------------------------------");
		System.out.println("1.조회");
		System.out.println("2.이체");
		System.out.println("3.뒤로가기");
		System.out.println("0.종료");
		int type = scanInt("메뉴를 선택하세요");
		
		return type;
	}

}
