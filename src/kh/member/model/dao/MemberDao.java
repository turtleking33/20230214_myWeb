package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kh.common.jdbc.JDBCTemplate;
import kh.member.model.vo.MemberVo;

public class MemberDao {
	//회원가입 -- insert문이고 int로 받는
	public int enroll(Connection conn, MemberVo vo) {
		int result=-1;
		String query="inset into Test_Member values";
		query +="(?, ?, ?, ?)"; // 테이블에 순서로 저장되어 있으니 순서시켜야
		
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(query);
			// 1. ?채워주기
			// 2. pstmt 실해하고, 결과값을 result에 넣기
			pstmt.setString(1, vo.getId()); //채울때 ''포함해 채울거라 string
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		System.out.println("DAO enroll() return: "+result);
				
		return result;
	}
		

}
