package service;

import java.util.*;

import dao.BoardDAO;
import dto.BoardDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class MemberWritingSelectService {

	public List<BoardDTO> MemberWritingSelect(String id) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);

		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list = dao.MemberWritingSelect(id);
		close(con);
		return list;

	}

	
	public String MemberSelect(String id) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);

		String list  = dao.MemberWriting(id);
		close(con);
		return list;

	}
	
}