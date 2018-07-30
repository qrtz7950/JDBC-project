package kr.ac.mp.ui;

public class LoanReturnUI extends BaseUI {

	private int returnM;
	
	public void execute() {
		
		AccountSelectUI asui = new AccountSelectUI();
		
		asui.accountselect();
		
		returnM = scanInt("대출상환하실 금액을 입력하세요: ");
		
		bankser.returnMoney(asui.getAcc(), returnM);
		
	}

}
