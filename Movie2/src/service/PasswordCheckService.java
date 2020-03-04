package service;


import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MoviesDAO;

public class PasswordCheckService {

	public String PasswordCheck(String id) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		String result=dao.PasswordCheck(id);
		close(con);
		return result;
	
	
	
	
	}

}
