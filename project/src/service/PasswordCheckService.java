package service;

import dao.BoardDAO;
import static db.JdbcUtil.*;

import java.sql.Connection;

public class PasswordCheckService {

	public String PasswordCheck(String id) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		String result=dao.PasswordCheck(id);
		close(con);
		return result;
	
	
	
	
	}

}
