package service;

import dao.BoardDAO;
import static db.JdbcUtil.*;

import java.sql.Connection;

public class BoardTextDeleteService {

	public boolean BoardTextDelete(int boardnumber) {
		BoardDAO dao = BoardDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = dao.BoardTextDelete(boardnumber);
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
