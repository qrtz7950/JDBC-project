package kr.ac.mp.ui;

/**
 * 대출업무 메뉴, 선택
 * @author Ddock2
 *
 */
public class LoanUI extends BaseUI {
 	
	public LoanUI() {
		bankser.loanSet();
	}
	
	public void execute() {
		
		while(true) {
			int type = menu();
			I_BankUI ui = null;
			switch (type) {
			case 1:
				ui = new LoanMoneyUI(); 
				break;
			case 2:
				ui = new LoanReturnUI();
				break;
			case 3:
				ui = new LoanViewUI();
				break;
			case 4:
				ui = new AccountTaskUI();
				loanV.reset();
				break;
			case 5:
				ui = new ExitUI();
				break;
			}
			
			if(ui != null)
				ui.execute();
			else
				System.out.println("그런 숫자는 없잖아요 다시선택하세요");
			}
 	}
	
	public int menu() {
		System.out.println("------------------------------------------");
		System.out.println("\t\t뱅킹 시스템");
		System.out.println("------------------------------------------");
		System.out.println("1.대출");
		System.out.println("2.상환");
		System.out.println("3.대출내역조회");
		System.out.println("4.뒤로");
		System.out.println("5.종료");
		
		int type = scanInt("메뉴를 선택하세요");
		
		return type;
	}
 }