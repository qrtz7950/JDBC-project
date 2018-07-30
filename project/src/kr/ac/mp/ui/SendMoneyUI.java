package kr.ac.mp.ui;

public class SendMoneyUI extends BaseUI {

	@Override
	public void execute() {
		
		System.out.println("송금을 진행합니다");
		int m = scanInt("송금할 금액을 입력하세요");
		String acc = scanString("송금할 계좌를 입력하세요");
		
		bankser.sendMoney(acc, m);
		
	}

}
