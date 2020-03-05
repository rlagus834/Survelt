package service;

import java.util.*;
import dao.UsersDAO;

import dto.UsersDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class ClientSelectService {

	public int CountService() {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.CountSelect();
		close(con);
		return result;
	}

	public List<UsersDTO> ClientSelectService(String filters, String search) {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		list = dao.ClientSelect(filters,search);
		close(con);
		return list;

	}

}
