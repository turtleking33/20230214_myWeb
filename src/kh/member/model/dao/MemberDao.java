package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kh.common.jdbc.JDBCTemplate;
import kh.member.model.vo.MemberVo;

public class MemberDao {
	//내정보보기
	public MemberVo myInfo(Connection conn, String id) {
		MemberVo result=null;
		String sql="select ID,NAME,EMAIL from test_memeber ";
		sql+=" where id=?";//위와 합해지면 띄어쓰기 없으니 sql문 실행하려면 한칸 띄워줘야함
		
		PreparedStatement pstmt=null;// ? 때문에 prepared써야
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=new MemberVo();
				result.setEmail(rs.getString("email"));
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		
		return result;
	}
	
	//로그인. 리턴은 자료형이 하나일 수 밖에 없어서 vo를 사용
	public MemberVo login(Connection conn, MemberVo vo) {
		MemberVo result=null;
		String sql="select ID,NAME,EMAIL from test_memeber";
		sql+="where id=? and passwd=?";
		
		PreparedStatement pstmt=null;// ? 때문에 prepared써야
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=new MemberVo();
				result.setEmail(rs.getString("email"));
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
			
		}
		
		
		
		return result;
	}
	
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
