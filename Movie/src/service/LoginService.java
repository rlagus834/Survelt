package service;

import java.util.*;

import dao.UsersDAO;
import dto.UsersDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class LoginService {

	public boolean loginService(UsersDTO dto) {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		boolean result = dao.LoginSelect(dto);
		close(con);
		return result;
	}

}
