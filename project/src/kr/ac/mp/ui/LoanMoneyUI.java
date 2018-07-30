package kr.ac.mp.ui;

public class LoanMoneyUI extends BaseUI {

	private int loanM;
	
	public void execute() {
 		
		loanM = scanInt("대출하실 금액을 입력하세요: ");
		
		bankser.loanMoney(loanM ,bank.getName());
	}
	
 }