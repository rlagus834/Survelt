package service;

import java.util.*;

import dao.UsersDAO;

import dto.UsersDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class UpdateClientService {

	public boolean updateClientService(UsersDTO dto) {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.UpdateClient(dto);
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

	public UsersDTO updateClientService(String id) {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		UsersDTO dto = dao.UpdateClientSelect(id);
		return dto;

	}

}
