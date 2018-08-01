package kr.ac.mp.ui;

public class AccountUI extends BaseUI {

	@Override
	public void execute() {
	
	while(true) {
		int type = menu();
		I_BankUI ui = null;
		switch (type) {
		case 1:
			ui =  new AccountSelectUI();
			break;
		case 2:
			ui = new AccountViewUI();
			break;
		case 3:
			ui = new AccountCreateUI();
			break;
		case 4:
			ui = new AccountDeleteUI();
			break;
		case 5:
			ui = new BankUI();
			bank.reset();
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
		System.out.println("\t\t은행 업무 메뉴");
		System.out.println("------------------------------------------");
		System.out.println("1.계좌선택");
		System.out.println("2.계좌조회");
		System.out.println("3.계좌생성");
		System.out.println("4.계좌해지");
		System.out.println("5.뒤로가기");
		System.out.println("0.종료");
		int type = scanInt("메뉴를 선택하세요");
		
		return type;
	}
		
}
