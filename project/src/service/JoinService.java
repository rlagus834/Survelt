package service;

import java.util.*;

import dao.TestDAO;
import dto.TestDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class JoinService {

	public boolean joinService(TestDTO dto) {
		TestDAO dao = TestDAO.getInstance();
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
