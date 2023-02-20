package kh.board.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import kh.board.model.dao.BoardDao;
import kh.board.model.vo.BoardVo;
import kh.common.jdbc.JDBCTemplate;

public class BoardService {
	public int  getCountBoard() {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getCountBoard(conn);
		System.out.println("srv:"+ result);
		JDBCTemplate.close(conn);
		return result;
	}
	// overloading
	public List<BoardVo> getBoardList(int srnum, int ernum){
		List<BoardVo> result = null;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getBoardList(conn, srnum, ernum);
		System.out.println("srv:"+ result);
		JDBCTemplate.close(conn);
		return result;
	}
	public List<BoardVo> getBoardList(){
		List<BoardVo> result = null;
		Connection conn = JDBCTemplate.getConnection();
		result = new BoardDao().getBoardList(conn);
		System.out.println("srv:"+ result);
		JDBCTemplate.close(conn);
		return result;
	}
}