package service;

import java.util.*;

import dao.TestDAO;
import dto.TestDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class UpdateClientService {

	
public boolean updateClientService(TestDTO dto) {
	TestDAO dao=TestDAO.getInstance();
	Connection con=getConnection();
	dao.setConnection(con);
	int result=dao.UpdateClient(dto);
	if(result>0) {
		commit(con);
		close(con);
		return true;
	}else {
		rollback(con);
	close(con);	
	return false;
	}
}


public TestDTO updateClientService(String id) {
	TestDAO dao=TestDAO.getInstance();
	Connection con=getConnection();
	dao.setConnection(con);
    TestDTO dto=dao.UpdateClientSelect(id);
	return dto;
    
    
    
		}



}
