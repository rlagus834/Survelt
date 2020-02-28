package service;

import java.util.*;

import dao.UsersDAO;
import dto.MoviesDTO;
import dto.UsersDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class MovieSelectService {

	public List<MoviesDTO> MovieSelect(MoviesDTO dto) {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<MoviesDTO> list=new ArrayList<MoviesDTO>();
	list=dao.MovieSelect(dto);
	close(con);
		return list;
	
	
	}

}
