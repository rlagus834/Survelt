package service;

import java.util.*;

import dao.UsersDAO;
import dto.UsersDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class DeleteClientService {

	public boolean DeleteClient(String id) {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.DeleteClient(id);
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
