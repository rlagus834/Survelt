package service;

import java.util.*;


import dao.UsersDAO;
import dto.UsersDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class JoinService {

	public boolean joinService(UsersDTO dto) {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.joinInsert(dto);
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
