package service;

import java.util.*;

import dao.MoviesDAO;

import dto.MoviesDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class writeOpens {

	public List<MoviesDTO> writeOpenService(int boardnumber) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();

		list = dao.writeOpen(boardnumber);
		close(con);
		return list;

	}

}