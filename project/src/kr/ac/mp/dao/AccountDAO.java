package kr.ac.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.ac.mp.ui.AccountViewUI;
import kr.ac.mp.util.ConnectionFactory;
import kr.ac.mp.util.JDBCClose;
import kr.ac.mp.vo.AccountVO;
import kr.ac.mp.vo.AccountVOFactory;
import kr.ac.mp.vo.BankVO;

public class AccountDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	boolean bool = false;
	BankVO bank = new BankVO();
	AccountVO acc = AccountVOFactory.getInstance();
	Scanner sc = new Scanner(System.in);
	
	public boolean accountCompare(String accountNum) {
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from account ");
			sql.append("where account = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,accountNum);
						
			ResultSet rs = pstmt.executeQuery();
			bool = rs.next();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.close(conn, pstmt);
		}
		
		return bool;
	}
	public void accountAdd(String accountNum) {
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("insert into account(id, account, account_money) ");
			sql.append("values (?, ?, 10000) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,bank.getId());
			pstmt.setString(2,accountNum);
						
			pstmt.executeUpdate();
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	
	public List<Object> selAccount() {
		
		List<Object> list = new ArrayList<Object>();
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from account ");
			sql.append(" where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,bank.getId());
						
			ResultSet rs = pstmt.executeQuery();
						
			while(rs.next()) {
				acc = new AccountVO();
				acc.setId(rs.getString(1));
				acc.setAccount(rs.getString(2));
				acc.setAccount_money(Integer.parseInt(rs.getString(3)));
				list.add(acc);
			}
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.close(conn, pstmt);
		}
		
		return list;
	}
	
	public void delAccount(AccountVO account) {
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("delete from account ");
			sql.append(" where account = ? ");
			sql.append("   and id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,account.getAccount());
			pstmt.setString(2,bank.getId());
						
			pstmt.executeUpdate();

			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.close(conn, pstmt);
			}
	}

	   public AccountVO viewAccountName(AccountVO acc) {
      
	      try {
	         conn = ConnectionFactory.getConnection();
	         
	         StringBuilder sql = new StringBuilder();
	         sql.append("select a.name from account as a");
	         sql.append("where a.account = ? ");
	         
	         pstmt = conn.prepareStatement(sql.toString());
	         pstmt.setString(1,acc.getAccount());
	         
	         System.out.println(acc.getAccount() +" " + bank.getName());
	         
	         ResultSet rs = pstmt.executeQuery();
	               
	         if(rs.next()) {
	            String name = rs.getString(1);
	            acc = new AccountVO();
	            System.out.println("예금주는 "+ name + "님 입니다.");
	         } else {
	            System.out.println("일치하는 정보가 없습니다 ID와 비밀번호를 확인하고 다시 입력해주세요");
	            return null;
	         }
	         } catch(Exception e) {
	            e.printStackTrace();
	         } finally {
	        	 JDBCClose.close(conn, pstmt);
	         }
	         return acc;
	   	}
	
	/**
	 * 입력받은 돈을 입력받은 계좌로 보내는 메소드
	 * @param account
	 * @param sendMoney
	 * @param mode
	 */
	public void sendMoney(String account, int sendMoney) {
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("select a.account, m.name ");
			sql.append("  from account a inner join memberlist m ");
			sql.append("    on a.id = m.id ");
			sql.append("  where a.account = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, account);
						
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				System.out.println("잘못된 계좌번호 입니다.");
				System.out.println(bank.getId());
				new AccountViewUI().execute();
				
				System.out.println("계좌를 다시 입력하세요 : ");
				String acc = sc.nextLine();
				
				sendMoney(acc, sendMoney);
				return;
			}
			
			String name = rs.getString(2);
			
			sql.delete(0, sql.length());
			sql.append("update account ");
			sql.append("   set account_money = account_money + ? ");
			sql.append("   where account = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, sendMoney);
			pstmt.setString(2, account);
			
			pstmt.executeUpdate();
			
			System.out.println(name + "님에게 " + sendMoney + "원을 보냈습니다.");
			System.out.println();
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.close(conn, pstmt);
		}
		
	}
	
	/**
	 * 입력받은 금액을 자신의 계좌에서 돈을 빼는 메소드
	 * @param subM
	 */
	public void subMoney(String account, int subM) {
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("update account ");
			sql.append("  set account_money = account_money - ? ");
			sql.append("  where account = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, subM);
			pstmt.setString(2, account);
						
			pstmt.executeUpdate();
			
			sql.delete(0, sql.length());
			sql.append("select account_money ");
			sql.append("  from account ");
			sql.append("  where account = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, account);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			int currM = rs.getInt(1);
			
			System.out.println("현재 " + account + "계좌에 잔액은 " + currM + "원입니다.");
			
			acc.setAccount_money(currM);
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.close(conn, pstmt);
		}
		
	}

}
