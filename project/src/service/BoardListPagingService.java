package service;

import java.util.*;

import dao.BoardDAO;
import dto.BoardDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class BoardListPagingService {

	public int boardListPagingService() {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.CountSelectService();
		close(con);
		return count;

	}

	public int SelectCountService(String select,String filters) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.SelectCount(select,filters);
		close(con);
		return count;

	}

	public List<BoardDTO> boardListPagingService2(int startRow, int endRow) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list = dao.CountSelectService2(startRow, endRow);
		close(con);
		return list;

	}

	public List<BoardDTO> boardListPagingServiceSearch(int startRow, int endRow, String search,String filters) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list = dao.CountSelectServiceSearch(startRow, endRow, search,filters);
		close(con);
		return list;

	}

	public int MemberboardListPagingService(String id) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int count = dao.memberCountSelectService(id);
		close(con);
		return count;

	}

	public List<BoardDTO> MemberWritingSelectId(int startRow, int endRow, String id) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);

		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list = dao.CountSelectServiceid(startRow, endRow, id);
		close(con);
		return list;

	}

	public List<BoardDTO> UpdateSelectAscService(int startRow, int endRow) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list = dao.updateSelectServiceAsc(startRow, endRow);
		close(con);
		return list;
	}

}