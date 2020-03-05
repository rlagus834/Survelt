package service;

import java.util.*;

import dao.MoviesDAO;
import dao.UsersDAO;
import dto.MoviesDTO;
import dto.UsersDTO;

import java.sql.*;

import static db.JdbcUtil.*;

public class MovieSearchService {

	public List<MoviesDTO> MovieSearch() {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<MoviesDTO> list=new ArrayList<MoviesDTO>();
	list=dao.MovieSearch();
	close(con);
	return list;
	
	
	}
	public List<MoviesDTO> MovieBest() {
		UsersDAO dao = UsersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<MoviesDTO> list=new ArrayList<MoviesDTO>();
	list=dao.MovieBest();
	close(con);
	return list;
	
	
	}

	public List<MoviesDTO> MovieList(String search) {
		MoviesDAO dao = MoviesDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<MoviesDTO> list=new ArrayList<MoviesDTO>();
	list=dao.MovieList(search);
	close(con);
	return list;
	
	
	}
	
	
	
}
