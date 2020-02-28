package service;

import java.util.*;

import dao.CommentDAO;
import dao.UsersDAO;
import dto.CommentDTO;


import java.sql.*;

import static db.JdbcUtil.*;

public class CommentWriteService {

	public boolean CommentWrite(CommentDTO dto) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result=dao.CommentWrite(dto);
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
