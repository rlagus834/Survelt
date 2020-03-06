package service;

import java.util.*;


import dao.MoviesDAO;
import dto.CommentDTO;
import dto.MoviesDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class BoardListPagingService {



	public int SelectCountService(String select,String filters,int mnum) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.SelectCount(select,filters,mnum);
		close(con);
		return count;

	}


	public List<CommentDTO> boardListPagingServiceSearch(int startRow, int endRow, String search,String filters,int mnum,String id) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		list = dao.CountSelectServiceSearch(startRow, endRow, search,filters,mnum,id);
		close(con);
		return list;

	}

	public int MemberboardListPagingService(String id) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.memberCountSelectService(id);
		close(con);
		return count;

	}

//	public int goodAndMinusChanceService(String id,int bnum) {
//		MoviesDAO dao = MoviesDAO.getInstance();
//		Connection con = getConnection();
//		dao.setConnection(con);
//		int count = dao.goodAndMinusChance(id,bnum);
//		close(con);
//		return count;
//
//	}
//
//	
	
	

}