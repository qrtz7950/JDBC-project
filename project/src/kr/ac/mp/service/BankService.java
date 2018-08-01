package kr.ac.mp.service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import kr.ac.mp.dao.AccountDAO;
import kr.ac.mp.dao.LoanDAO;
import kr.ac.mp.dao.MemberDAO;
import kr.ac.mp.ui.BankUI;
import kr.ac.mp.vo.AccountVO;
import kr.ac.mp.vo.AccountVOFactory;
import kr.ac.mp.vo.BankVO;
import kr.ac.mp.vo.LoanVO;

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
		if(!dao.checkOverlapMember(bank)) {
			System.out.println("중복된 아이디입니다");
			new BankUI().execute();
		}
		dao.insertMember(bank);
	}

	public boolean login(BankVO bank) {
		boolean bool = false;
		bool = dao.idPwdCompare(bank);
		return bool;
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
		if(returnM > LoanVO.getLoanMoney()) {
			System.out.println("상환하시려는 금액이 대출했던 금액보다 큽니다.");
			System.out.println("그대로 진행하시면 남은 금액은 은행에 기부됩니다.");
			System.out.print("계속하길 원하시면 1 아니면 2를 입력하세요 : ");
			int sel = Integer.parseInt(sc.nextLine());
			
			while(sel!=1 && sel!=2) {
				System.out.println("다시 입력하세요");
				sel = Integer.parseInt(sc.nextLine());
			}

			if(sel==2) {
				System.out.println("아쉽....다음엔 주세요!");
				return;
			}
		}
			
		if(returnM <= acc.getAccount_money()) {
			accDao.subMoney(account, returnM);
			loanDao.loanUpdate(-returnM);
		} else {
			System.out.println("잔액이 부족합니다");
		}
	}
	
	public void sendMoney(String account, int m) {
		if(m <= acc.getAccount_money()) {
			if(!accDao.sendMoney(account, m)) {
				accDao.subMoney(acc.getAccount(),m);
			}
		} else {
			System.out.println("잔액이 부족합니다");
		}
	}
	
	public void loanView() {
		String str =  loanDao.loanview();
		System.out.println(str);
	}
	
	public void loanSet() {
		loanDao.loanSet();
	}

}