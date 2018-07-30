package kr.ac.mp.ui;

public class ExitUI implements I_BankUI {

	@Override
	public void execute() {
		System.out.println("----------------------------------");
		System.out.println("\t프로그램을 종료합니다");
		System.out.println("----------------------------------");
		System.exit(0);
	}

}
