package kr.ac.mp.ui;

public class SendMoneyUI extends BaseUI {

   @Override
   public void execute() {
	   if(acc.getAccount_money() == 0) {
		   System.out.println("잔액이 없습니다 메뉴로 돌아갑니다");
		   new AccountTaskUI().execute();
	   }
	   
      System.out.println("송금을 진행합니다");
      int m = scanInt("송금할 금액을 입력하세요");
      String acc = scanString("송금할 계좌를 입력하세요");
      
      
      bankser.sendMoney(acc, m);
   }

}