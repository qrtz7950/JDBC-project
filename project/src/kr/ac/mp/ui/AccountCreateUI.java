package kr.ac.mp.ui;

public class AccountCreateUI extends BaseUI {

	String Account;
	String Account_Money;
	
	@Override
	public void execute() {
		
		System.out.println("계좌를 생성합니다 계좌번호는 랜덤한 8자리 숫자로 부여됩니다");
		
		Account = bankser.createAccount();
		
		System.out.println("계좌가 발급되었습니다");
		System.out.println("발급된 계좌번호는 다음과 같습니다");
		System.out.println(Account);
		
		System.out.println("은행 개설 기념으로 예치금 10000원을 드립니다");
	}

}
