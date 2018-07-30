package kr.ac.mp;

import kr.ac.mp.ui.BankUI;

public class BankMain {

	public static void main(String[] args) {
		
		try {
			new BankUI().execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
