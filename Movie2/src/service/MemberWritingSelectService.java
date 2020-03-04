package service;

import java.util.*;

import dao.MoviesDAO;

import dto.MoviesDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class MemberWritingSelectService {

	public List<MoviesDTO> MemberWritingSelect(String id) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);

		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		list = dao.MemberWritingSelect(id);
		close(con);
		return list;

	}

	
	public String MemberSelect(String id) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);

		String list  = dao.MemberWriting(id);
		close(con);
		return list;

	}
	
}