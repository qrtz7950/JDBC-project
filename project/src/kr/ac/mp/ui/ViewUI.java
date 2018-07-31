package kr.ac.mp.ui;

public class ViewUI extends BaseUI{

	@Override
	public void execute() {
		
		String account = new AccountSelectUI().getAcc();
		acc = bankser.selAccount(account);
		System.out.println("현재 남은 잔액은" + acc.getAccount_money() + "입니다");
		
		new AccountTaskUI().execute();
	}
}
