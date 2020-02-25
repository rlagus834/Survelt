package service;


import dto.MoviesDTO;

import java.util.*;

import dao.MoviesDAO;

import java.sql.*;

import static db.JdbcUtil.*;

public class UpdateTextService {

	public boolean UpdateText(MoviesDTO dto) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.UpdateText(dto);
		if (result > 0) {
			commit(con);
			close(con);
			return true;
		} else {
			rollback(con);
			close(con);
			return false;
		}

	}

}
