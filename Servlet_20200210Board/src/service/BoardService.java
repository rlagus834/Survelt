package service;

import java.util.*;

import dao.BoardDAO;
import dto.BoardDTO;

import java.sql.*;



import static db.JdbcUtil.*;

public class BoardService {

public boolean Board(BoardDTO dto) {
BoardDAO dao=BoardDAO.getInstance();	
Connection con=getConnection();
dao.setConnection(con);
int result=dao.Board(dto);
if(result>0) {
	commit(con);
	return true;
}else {
	rollback(con);
	return false;
}
	
	
	
	
}



	
	
	
}