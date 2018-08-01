package kr.ac.mp.vo;

public class LoanVO {

	private static String id;
	private static int loanMoney;
	
	public LoanVO() {
		
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		LoanVO.id = id;
	}

	public static int getLoanMoney() {
		return loanMoney;
	}

	public static void setLoanMoney(int loanMoney) {
		LoanVO.loanMoney = loanMoney;
	}

	public void reset() {
		LoanVO.id = null;
		LoanVO.loanMoney = 0;
	}
}
