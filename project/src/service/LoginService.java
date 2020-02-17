package service;

import java.util.*;

import dao.TestDAO;
import dto.TestDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class LoginService {

	public boolean loginService(TestDTO dto) {
		TestDAO dao = TestDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		boolean result = dao.LoginSelect(dto);
		close(con);
		return result;
	}

}
