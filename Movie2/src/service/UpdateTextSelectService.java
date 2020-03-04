package service;



import java.util.*;

import dao.MoviesDAO;
import dto.MoviesDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class UpdateTextSelectService {

	public List<MoviesDTO> UpdateText(int bordernum) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		list = dao.BorderNumberTextSelect(bordernum);
		close(con);
		return list;

	}

}
