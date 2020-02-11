package service;

import java.util.*;

import dao.BoardDAO;
import dto.BoardDTO;

import java.sql.*;



import static db.JdbcUtil.*;

public class UpdateSelectAscService {

public List<BoardDTO> UpdateSelectService() {
BoardDAO dao=BoardDAO.getInstance();	
Connection con=getConnection();
dao.setConnection(con);

List<BoardDTO> list=new ArrayList<BoardDTO>();
  list=dao.updateSelectServiceAsc();
  close(con);
return list;
	

	
	
	
	
}



	
	
	
}