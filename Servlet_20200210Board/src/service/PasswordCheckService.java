package service;

import dao.BoardDAO;


import dao.BoardDAO;
import dto.BoardDTO;
import java.util.*;
import java.sql.*;



import static db.JdbcUtil.*;

public class PasswordCheckService {

	
public String PasswordCheck(int boardnumber) {
	BoardDAO dao=BoardDAO.getInstance();
	Connection con=getConnection();
	dao.setConnection(con);
	String password=dao.PasswordCheck(boardnumber);
close(con);
return password;

	
	
}
	
	
	
	
}
