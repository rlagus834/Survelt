package service;

import java.util.*;

import dao.TestDAO;
import dto.TestDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class DeleteClientService {

	public boolean DeleteClient(String id) {
		TestDAO dao = TestDAO.getInstance();
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
