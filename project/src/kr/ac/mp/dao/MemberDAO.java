﻿package kr.ac.mp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.mp.util.ConnectionFactory;
import kr.ac.mp.util.JDBCClose;
import kr.ac.mp.vo.BankVO;

public class MemberDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	/**
	 * 회원가입을 위해 서비스에서 받아서 DB로 입력
	 * @param bank
	 */
	public boolean checkOverlapMember(BankVO bank) {
		boolean bool = false;
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select id from memberlist ");
			sql.append("where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, bank.getId());
			
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) {
				bool = true;
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return bool;
	}
	
	public void insertMember(BankVO bank){

		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into memberlist(id, name, password, rest) ");
			sql.append(" values(?, ?, ?, 0) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, bank.getId());
			pstmt.setString(2, bank.getName());
			pstmt.setString(3, bank.getPassword());
			
			pstmt.executeUpdate();
			System.out.println(bank.getName() + "님의 가입을 진심으로 축하합니다");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		
		
	}
	/**
	 * 객체에서 id와 pwd를 뽑아 테이블에서 비교하여 로그인을 시도
	 * @param bank
	 * @return
	 */
	public boolean idPwdCompare(BankVO bank) {
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from memberlist ");
			sql.append("where id = ? ");
			sql.append("  and password = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,bank.getId());
			pstmt.setString(2,bank.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
					
			if(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				bank.setId(id);
				bank.setName(name);
				bank.setPassword(password);
			} else {
				return false;
			}
		} catch(Exception e) {
				e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return true;
	}
	
	public void sendMoney(int sendM) {
		
		BankVO bank = new BankVO();
		
		try {
			conn = ConnectionFactory.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("update loan_money lm from loan ");
			sql.append("  where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, sendM);
			pstmt.setString(2, bank.getId());
			
			pstmt.executeUpdate();
			
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCClose.close(conn, pstmt);
			}
		
	}
	
		
}