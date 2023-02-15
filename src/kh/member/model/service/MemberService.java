package kh.member.model.service;

import java.sql.Connection;

import kh.common.jdbc.JDBCTemplate;
//import static kh.common.jdbc.JDBCTemplate.*;  // 안의 static인 메서드들이 클래스 이름 없이 사용할 수 있게 되는
import kh.member.model.dao.MemberDao;
import kh.member.model.vo.MemberVo;

public class MemberService {
	//회원가입 -- insert문이고 int로 받는
		public int enroll(MemberVo vo) {
			int result=-1;
			Connection conn=JDBCTemplate.getConnection();
			result=new MemberDao().enroll(conn, vo);
			JDBCTemplate.close(conn);
			return result;
		}

}
