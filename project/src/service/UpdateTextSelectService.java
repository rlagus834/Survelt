package service;

import dao.BoardDAO;

import dao.BoardDAO;
import dto.BoardDTO;
import java.util.*;
import java.sql.*;

import static db.JdbcUtil.*;

public class UpdateTextSelectService {

	public List<BoardDTO> UpdateText(int bordernum) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list = dao.BorderNumberTextSelect(bordernum);
		close(con);
		return list;

	}

}
