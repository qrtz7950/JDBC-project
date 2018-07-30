package kr.ac.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.mp.util.ConnectionFactory;
import kr.ac.mp.util.JDBCClose;
import kr.ac.mp.vo.AccountVO;
import kr.ac.mp.vo.BankVO;

public class AccountDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	boolean bool = false;
	BankVO bank = new BankVO();
	
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
		AccountVO acc = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from account ");
			sql.append(" where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,bank.getId());
						
			ResultSet rs = pstmt.executeQuery();
						
			while(rs.next()) {
				acc = new AccountVO(rs.getString(1),rs.getString(2),rs.getString(3));
				list.add(acc);
			}
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return list;
	}
	public AccountVO selAccount(String account) {
		
		AccountVO acc = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from account ");
			sql.append(" where id = ? ");
			sql.append("   and account = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,bank.getId());
			pstmt.setString(2,account);
						
			ResultSet rs = pstmt.executeQuery();
						
			while(rs.next()) {
				acc = new AccountVO(rs.getString(1),rs.getString(2),rs.getString(3));
			}
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
			JDBCClose.close(conn, pstmt);
			}
		return acc;
	}
	
	public void delAccount(String account) {
		
		AccountVO acc = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("delete from account ");
			sql.append(" where account = ? ");
			sql.append("   and id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,account);
			pstmt.setString(2,bank.getId());
						
			pstmt.executeQuery();

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
	 * 대출받은 돈을 계좌로 보내는 메소드
	 * @param account
	 * @param sendMoney
	 */
	public void sendLoanMoney(String account, int sendMoney) {
		
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
				System.out.println("다시 입력하세요");
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
			
			System.out.println(name + "님에게 피같은 대출금 " + sendMoney + "원을 보냈습니다.");
			
			System.out.println();
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
			JDBCClose.close(conn, pstmt);
		}
		
	}

}
