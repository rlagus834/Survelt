package service;

import java.util.*;

import java.sql.*;
import dao.DAO;
import dto.memberDTO;

import static db.JdbcUtil.*;

public class InputService {

	public boolean insert(String na1) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int var = dao.insert(na1);
		if (var > 0) {
			commit(con);
			return true;
		} else {
			rollback(con);
			return false;
		}

	}

	public List<String> select() {
		List<String> list = new ArrayList<String>();
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		return list = dao.select();
	}

	public boolean inserts(memberDTO ss) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int var = dao.inserts(ss);
		if (var > 0) {
			commit(con);
			return true;
		} else {
			rollback(con);
			return false;
		}

	}
	
	
	
}
