package service;

import java.util.*;

import dao.CommentDAO;
import dao.UsersDAO;
import dto.CommentDTO;


import java.sql.*;

import static db.JdbcUtil.*;

public class CommentUpdateSelectService {

	public CommentDTO CommentUpdateSelect(CommentDTO dto) {
		CommentDAO dao = CommentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<CommentDTO> list=new ArrayList<CommentDTO>();
		 dao.CommentsUpdateSelect(dto);
		close(con);
		return dto;
	}



}
