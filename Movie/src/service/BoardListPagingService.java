package service;

import java.util.*;


import dao.MoviesDAO;
import dto.CommentDTO;
import dto.MoviesDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class BoardListPagingService {

	public int boardListPagingService() {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.CountSelectService();
		close(con);
		return count;

	}

	public int SelectCountService(String select,String filters,int mnum) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.SelectCount(select,filters,mnum);
		close(con);
		return count;

	}

	public List<MoviesDTO> boardListPagingService2(int startRow, int endRow) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		list = dao.CountSelectService2(startRow, endRow);
		close(con);
		return list;

	}

	public List<CommentDTO> boardListPagingServiceSearch(int startRow, int endRow, String search,String filters,int mnum) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		list = dao.CountSelectServiceSearch(startRow, endRow, search,filters,mnum);
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

	public List<MoviesDTO> MemberWritingSelectId(int startRow, int endRow, String id) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);

		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		list = dao.CountSelectServiceid(startRow, endRow, id);
		close(con);
		return list;

	}

	public List<MoviesDTO> UpdateSelectAscService(int startRow, int endRow) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		list = dao.updateSelectServiceAsc(startRow, endRow);
		close(con);
		return list;
	}

}