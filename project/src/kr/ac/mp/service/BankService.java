package kr.ac.mp.service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import kr.ac.mp.dao.AccountDAO;
import kr.ac.mp.dao.LoanDAO;
import kr.ac.mp.dao.MemberDAO;
import kr.ac.mp.vo.AccountVO;
import kr.ac.mp.vo.AccountVOFactory;
import kr.ac.mp.vo.BankVO;

public class BankService {
	
	Scanner sc = new Scanner(System.in);
	
	private MemberDAO dao;
	private LoanDAO loanDao;
	private AccountDAO accDao;
	AccountVO acc;
	
	public BankService() {
		dao = new MemberDAO();
		loanDao = new LoanDAO();
		accDao = new AccountDAO();
		acc = AccountVOFactory.getInstance();
	}
	
	

	public void sign(BankVO bank) {
		dao.insertMember(bank);
	}

	public boolean login(BankVO bank) {
		boolean bool = dao.idPwdCompare(bank);
		return bool;
	}

	public BankVO loginConfirm() {
		return null;
	}
	
	public String createAccount() {
		
		Random r = new Random();
		
		String accountNum = "2018-";
		int temp = r.nextInt(8999)+1000;
		accountNum += temp;
		
		if(accDao.accountCompare(accountNum)) {
			createAccount();
		} else {
			accDao.accountAdd(accountNum);
		}
		
		return accountNum;
	}

	public List<Object> selAccount() {
		
		List<Object> list = accDao.selAccount(); 
		
	    return list;
	}
	
	public void listPrint() {
		
		List<Object> list = selAccount();
		
		for(int i = 0; i<list.size(); i++) {
	         System.out.print(i+1 + ". ");
	         System.out.println(list.get(i));
	    }
	}

	public AccountVO selAccount(String account) {
		
		return accDao.selAccount(account);
	}

	public void delAccount(AccountVO account) {
		accDao.delAccount(account);
	}
	
	public void loanMoney(int loanM, String name) {
		int currLoan = loanDao.loanUpdate(loanM);
		System.out.print("대출받은 금액을 보낼 계좌를 입력하세요 : ");
		String account = sc.nextLine();
		accDao.sendMoney(account, loanM);
		
		System.out.println();
		System.out.println(name + "님의 총 대출 금액은 : " + currLoan + "원 입니다.");
	}
	
	public void returnMoney(String account, int returnM) {
		if(returnM <= acc.getAccount_money()) {
			accDao.subMoney(account, returnM);
			loanDao.loanUpdate(-returnM);
		} else {
			System.out.println("잔액이 부족합니다");
		}
	}
	
	public void sendMoney(String account, int m) {
		
		if(m <= acc.getAccount_money()) {
			accDao.subMoney(acc.getAccount(), m);
			accDao.sendMoney(account, m);
		} else {
			System.out.println("잔액이 부족합니다");
		}
	}
	
	public void loanView() {
		String str =  loanDao.loanview();
		System.out.println(str);
	}

}