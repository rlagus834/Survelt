package service;

import java.util.*;

import dao.TestDAO;
import dto.TestDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class ClientSelectService {

	
public int CountService() {
	TestDAO dao=TestDAO.getInstance();
	Connection con=getConnection();
	dao.setConnection(con);
	int result=dao.CountSelect();	
	close(con);
	return result;		
	}
	
}
