package service;

import java.util.*;

import dao.MoviesDAO;

import dto.MoviesDTO;
import dto.UsersDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class SympathyService {

	public boolean SympathyPlus(MoviesDTO dto) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
	int result=dao.SympathyPlus(dto);
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
public boolean SympathyMinus(int mnum,String id) {
	MoviesDAO dao = MoviesDAO.getInstance();
	Connection con = getConnection();
	dao.setConnection(con);
int result=dao.SympathyMinus(mnum,id);
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

public int SympathySelect(int mnum) {
	MoviesDAO dao = MoviesDAO.getInstance();
	Connection con = getConnection();
	dao.setConnection(con);
int result=dao.SympathySelect(mnum);
close(con);
return result;

	
	}

public String SympathyCheck(String id) {
	MoviesDAO dao = MoviesDAO.getInstance();
	Connection con = getConnection();
	dao.setConnection(con);
String result=dao.SympathyCheck(id);
close(con);
return result;

	
	}





}
