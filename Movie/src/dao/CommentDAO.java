package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dto.CommentDTO;
import dto.MoviesDTO;

//import javax.sql.*;
//import javax.xml.ws.Response;

public class CommentDAO {
	private static CommentDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static CommentDAO getInstance() {// 싱글톤=new 여러번 쓰지않고 한번만 객체선언해서 그 객체만 쓰게끔하고싶을때 쓰는기능
		if (dao == null) {
			dao = new CommentDAO(); // DAO(Data Access Object)는 메소드(주요기능)들을 전담(갖고있도록)하도록 만든 클래스(오브젝트).
		}
		return dao;

	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public List<CommentDTO> CommentSelect(int mnum) {
		String sql = "SELECT * FROM COMMENTS WHERE MNUM=?"; //
		int count = 0;
		List<CommentDTO> list = new ArrayList<CommentDTO>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setBnum(rs.getInt("bnum"));
				dto.setCdate(rs.getString("cdate"));
				dto.setId(rs.getString("id"));
				dto.setMnum(rs.getInt("mnum"));
				dto.setScore(rs.getInt("score"));
				dto.setText(rs.getString("text"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);

		}
		return list;

	}

	public int CommentWrite(CommentDTO dto) {
		String sql = "INSERT INTO COMMENTS VALUES((SELECT COUNT(*) FROM COMMENTS)+1,?,?,?,SYSDATE,?)"; //
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getText());
			pstmt.setInt(3, dto.getScore());
			pstmt.setInt(4, dto.getMnum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
		}
		return result;

	}

	public int Score(int mnum) {
		String sql = "SELECT (SCORE) FROM COMMENTS WHERE MNUM=?"; //
		int result = 0, count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result += rs.getInt("score");
				count++;

			}
			result = result / count;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);
		}
		return result;

	}

	public int CommentsDelete(int bnum) {
		String sql = "DELETE FROM COMMENTS WHERE BNUM=?"; //
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
		}
		return result;

	}

	public CommentDTO CommentsUpdateSelect(CommentDTO dto) {
		String sql = "SELECT * FROM COMMENTS WHERE BNUM=?"; //
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBnum());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setScore(rs.getInt("score"));
				dto.setText(rs.getString("text"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
		}
		return dto;

	}

	public int CommentsUpdate(CommentDTO dto) {
		String sql = "UPDATE COMMENTS SET SCORE=?,TEXT=? WHERE BNUM=?"; //
		int result=0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getScore());
		pstmt.setString(2, dto.getText());
		pstmt.setInt(3, dto.getBnum());
		result=pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
		}
		return result;

	}

}