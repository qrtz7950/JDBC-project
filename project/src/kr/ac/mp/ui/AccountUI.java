package kr.ac.mp.ui;
import java.util.Scanner;

public class AccountUI extends BaseUI {

	@Override
	public void execute() {
		
	I_BankUI ui = null;
	Scanner sc = new Scanner(System.in);
	
	while(true) {
		int type = menu();
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
			ui = new LoanUI();
			break;
		case 6:
			ui = new BankUI();
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
		System.out.println("5.대출");
		System.out.println("6.뒤로가기");
		System.out.println("0.종료");
		int type = scanInt("메뉴를 선택하세요");
		
		return type;
	}
		
}
