package kr.ac.mp.service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import kr.ac.mp.dao.AccountDAO;
import kr.ac.mp.dao.LoanDAO;
import kr.ac.mp.dao.MemberDAO;
import kr.ac.mp.vo.AccountVO;
import kr.ac.mp.vo.BankVO;

public class BankService {
	
	Scanner sc = new Scanner(System.in);
	
	private MemberDAO dao;
	private LoanDAO loanDao;
	private AccountDAO accDao;
	
	public BankService() {
		dao = new MemberDAO();
		loanDao = new LoanDAO();
		accDao = new AccountDAO();
	}
	
	

	public void sign(BankVO bank) {
		dao.insertMember(bank);
	}

	public BankVO login(BankVO bank) {
		bank = dao.idPwdCompare(bank);
		return bank;
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
		
		return accDao.selAccount();
	}

	public AccountVO selAccount(String account) {
		
		return accDao.selAccount(account);
	}

	public void delAccount(String account) {
		accDao.delAccount(account);
	}
	
	public void loanMoney(int loanM, String name) {
		int currLoan = loanDao.loanUpdate(loanM);
		System.out.print("대출받은 금액을 보낼 계좌를 입력하세요 : ");
		String account = sc.nextLine();
		accDao.sendLoanMoney(account, loanM);
		System.out.println(name + "님의 총 대출 금액은 : " + currLoan + "원 입니다.");
	}
	
	public void returnMoney(int returnM, BankVO bank) {
		
	}

}