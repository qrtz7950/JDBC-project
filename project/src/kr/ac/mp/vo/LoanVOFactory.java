package kr.ac.mp.vo;

public class LoanVOFactory {
	
	private static final LoanVO instance = new LoanVO();
	
	public static LoanVO getInstance() {
		return instance;
	}
	

}
