package service;

import dao.BoardDAO;

import dao.BoardDAO;
import dto.BoardDTO;
import java.util.*;
import java.sql.*;

import static db.JdbcUtil.*;

public class UpdateTextService {

	public boolean UpdateText(BoardDTO dto) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.UpdateText(dto);
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

}
