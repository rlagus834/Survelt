package service;

import java.util.*;

import dao.CommentDAO;
import dao.UsersDAO;
import dto.CommentDTO;


import java.sql.*;

import static db.JdbcUtil.*;

public class ScoreService {

	public int ScoreService(int mnum) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result=dao.Score(mnum); 
		close(con);
		return result;
	}



}
