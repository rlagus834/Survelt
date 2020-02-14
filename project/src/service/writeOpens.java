package service;

import java.util.*;

import dao.BoardDAO;
import dto.BoardDTO;

import java.sql.*;



import static db.JdbcUtil.*;

public class writeOpens {

public List<BoardDTO> writeOpenService(String id,int boardnumber) {
BoardDAO dao=BoardDAO.getInstance();	
Connection con=getConnection();
dao.setConnection(con);
List<BoardDTO> list=new ArrayList<BoardDTO>();

list=dao.writeOpen(id,boardnumber);
close(con);
return list;


	
	
	
}



	
	
	
}