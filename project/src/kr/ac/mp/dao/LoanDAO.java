package kr.ac.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.mp.util.ConnectionFactory;
import kr.ac.mp.util.JDBCClose;
import kr.ac.mp.vo.BankVO;

public class LoanDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	BankVO bank = null;
	
		
	public LoanDAO() {
		bank = new BankVO();
	}

	/**
	 * 대출할때 loan 테이블에 총 대출액 update
	 * @param (int) loan money
	 * @return (int) current loan money
	 */
	public int loanUpdate(int loanM) {
		
		int currLoan = loanM;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select loan_money lm from loan ");
			sql.append("  where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, bank.getId());
			
			ResultSet rs = pstmt.executeQuery(); 
			
			if(!rs.next()) {
				sql.delete(0,sql.length());
				sql.append("insert into loan(id, loan_money) ");
				sql.append("   values( ? , ? ) ");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, bank.getId());
				pstmt.setInt(2, 0);
				pstmt.executeUpdate();
				
				sql.delete(0,sql.length());
				sql.append("select loan_money from loan ");
				sql.append("  where id = ? ");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, bank.getId());
				
				rs = pstmt.executeQuery();
				rs.next();
			}
			
			currLoan += rs.getInt(1);
			
			sql.delete(0,sql.length());
			sql.append("update loan ");
			sql.append("   set loan_money = ? ");
			sql.append("   where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, currLoan);
			pstmt.setString(2, bank.getId());
			
			pstmt.executeUpdate();
			
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.close(conn, pstmt);
			}
		
		return currLoan;
		
	}
	
	public String loanview() {
		
		String str = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select m.name, l.loan_money ");
			sql.append("  from loan l inner join memberlist m ");
			sql.append("    on l.id = m.id ");
			sql.append("  where l.id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, bank.getId());
			
			ResultSet rs = pstmt.executeQuery(); 
			
			if(!rs.next()) {
				str = "대출 한적도 없습니다.";
			}else {
				str = rs.getString(1) + "님의 총 대출 금액은 " + String.valueOf(rs.getInt(2)) + "원 입니다.";
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return str;
	}
	
		
}