package service;

import java.util.*;

import dao.CommentDAO;
import dao.UsersDAO;
import dto.CommentDTO;


import java.sql.*;

import static db.JdbcUtil.*;

public class CommentSelectService {

	public List<CommentDTO> CommentSelect(int mnum) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<CommentDTO> list=new ArrayList<CommentDTO>();
		list=dao.CommentSelect(mnum); 
		close(con);
		return list;
	}



}
