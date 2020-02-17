package service;

import java.util.*;

import dao.TestDAO;
import dto.TestDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class ClientSelectService {

	public int CountService() {
		TestDAO dao = TestDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.CountSelect();
		close(con);
		return result;
	}

	public List<TestDTO> ClientSelectService(int startRow, int endRow) {
		TestDAO dao = TestDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<TestDTO> list = new ArrayList<TestDTO>();
		list = dao.ClientSelect(startRow, endRow);
		close(con);
		return list;

	}

}
