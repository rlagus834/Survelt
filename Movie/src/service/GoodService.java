package service;

import java.util.*;

import dao.CommentDAO;
import dao.MoviesDAO;
import dto.CommentDTO;
import dto.MoviesDTO;
import dto.UsersDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class GoodService {

	public boolean GoodPlus(String id,int bnum) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.GoodPlus(id,bnum);
		if (result > 0) {
			commit(con);
			close(con);
			return true;
		} else {
			rollback(con);
			close(con);
			return false;
		}

	}
	
	public boolean MinusPlus(String id,int bnum) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.MinusPlus(id,bnum);
		if (result > 0) {
			commit(con);
			close(con);
			return true;
		} else {
			rollback(con);
			close(con);
			return false;
		}

	}
	

	public boolean GoodMinus(String id,int bnum) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.GoodMinus(id,bnum);
		if (result > 0) {
			commit(con);
			close(con);
			return true;
		} else {
			rollback(con);
			close(con);
			return false;
		}

	}

	public boolean MinusMinus(String id,int bnum) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.MinusMinus(id,bnum);
		if (result > 0) {
			commit(con);
			close(con);
			return true;
		} else {
			rollback(con);
			close(con);
			return false;
		}

	}

	
	
	public boolean GoodSelect(int bnum,String id) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.GoodSelect(bnum, id);
		System.out.println(result);
if(result>0) {
	close(con);
return true;
}else {
	close(con);
return false;	
}

	}
	
	public boolean MinusSelect(int bnum,String id) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.MinusSelect(bnum, id);
		System.out.println(result);
if(result>0) {
	close(con);
return true;
}else {
	close(con);
return false;	
}

	}



}
