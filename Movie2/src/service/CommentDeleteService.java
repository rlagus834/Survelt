package service;

import java.util.*;

import dao.CommentDAO;
import dao.UsersDAO;
import dto.CommentDTO;


import java.sql.*;

import static db.JdbcUtil.*;

public class CommentDeleteService{

	public boolean CommentDelete(int bnum) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);		
		int result=dao.CommentsDelete(bnum); 
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



}
