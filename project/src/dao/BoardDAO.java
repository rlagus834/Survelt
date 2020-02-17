package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;
import dao.BoardDAO;
import dto.BoardDTO;

//import javax.sql.*;
//import javax.xml.ws.Response;

public class BoardDAO {
	private static BoardDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static BoardDAO getInstance() {// 싱글톤=new 여러번 쓰지않고 한번만 객체선언해서 그 객체만 쓰게끔하고싶을때 쓰는기능
		if (dao == null) {
			dao = new BoardDAO(); // DAO(Data Access Object)는 메소드(주요기능)들을 전담(갖고있도록)하도록 만든 클래스(오브젝트).
		}
		return dao;

	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int Board(BoardDTO dto) {
		String sql = "INSERT INTO BOARDS VALUES(BOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,0)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardtitle());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getText());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼

		}
		return result;

	}

	public int Boards(BoardDTO dto) {
		String sql = "INSERT INTO BOARDS VALUES(BOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,0,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardtitle());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getText());
			pstmt.setString(4, dto.getbFile());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼

		}
		return result;

	}

	public List<BoardDTO> updateSelectService() {
		String sql = "SELECT * FROM BOARDS";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
				dto.setId(rs.getString("id"));
				dto.setCount(rs.getInt("count"));
				dto.setbFile(rs.getString("files"));
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

	public List<BoardDTO> updateSelectServiceAsc(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLISTS WHERE RN BETWEEN ? AND ? ORDER BY COUNT DESC";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
				dto.setId(rs.getString("id"));
				dto.setCount(rs.getInt("count"));
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

	public List<BoardDTO> MemberWritingSelect(String id) {
		String sql = "SELECT * FROM BOARDS WHERE ID=?";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
				dto.setId(rs.getString("id"));
				dto.setCount(rs.getInt("count"));
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

	public List<BoardDTO> writeOpen(int boardnumber) {
		String sql = "SELECT * FROM BOARDS WHERE BOARDNUMBER=?";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardnumber);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
				dto.setId(rs.getString("id"));
				dto.setCount(rs.getInt("count"));
				dto.setText(rs.getString("text"));
				dto.setbFile(rs.getString("files"));
				list.add(dto);
			}
			sql = "UPDATE BOARDS SET COUNT=COUNT+1 WHERE  BOARDNUMBER=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardnumber);
			pstmt.executeUpdate();
			commit(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);

		}
		return list;

	}

	public List<BoardDTO> BorderNumberTextSelect(int bordernum) {
		String sql = "SELECT * FROM BOARDS WHERE BOARDNUMBER=?";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bordernum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
				dto.setId(rs.getString("id"));
				dto.setCount(rs.getInt("count"));
				dto.setText(rs.getString("text"));
				dto.setbFile(rs.getString("files"));
				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public int UpdateText(BoardDTO dto) {
		String sql = "UPDATE BOARDS SET TEXT=?,BOARDTITLE=? WHERE BOARDNUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getText());
			pstmt.setInt(2, dto.getBoardnumber());
			pstmt.setInt(3, dto.getBoardnumber());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public int BoardTextDelete(int boardnumber) {
		String sql = "DELETE FROM BOARDS WHERE BOARDNUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardnumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public int CountSelectService() {
		String sql = "SELECT COUNT(*) FROM BOARDS"; //
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);

		}
		return count;

	}

	public int SelectCount(String id) {
		String sql = "SELECT COUNT(*) FROM BOARDS WHERE ID LIKE ? OR BOARDTITLE LIKE ?"; //
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + id + "%");
			pstmt.setString(2, "%" + id + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);

		}
		return count;

	}

	public int memberCountSelectService(String id) {
		String sql = "SELECT COUNT(*) FROM BOARDS WHERE ID=?"; //
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);

		}
		return count;

	}

	public List<BoardDTO> CountSelectService2(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLISTS WHERE RN BETWEEN ? AND ?"; // 뷰 조회
		List<BoardDTO> list = new ArrayList<BoardDTO>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
				dto.setId(rs.getString("id"));
				dto.setCount(rs.getInt("count"));
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

	public List<BoardDTO> CountSelectServiceSearch(int startRow, int endRow, String search) {
		String sql = "SELECT * FROM BOARDLISTS WHERE ID LIKE ? OR BOARDTITLE LIKE ? AND RN BETWEEN ? AND ?"; // 뷰 조회
		List<BoardDTO> list = new ArrayList<BoardDTO>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setString(2, "%" + search + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
				dto.setId(rs.getString("id"));
				dto.setCount(rs.getInt("count"));
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

	public List<BoardDTO> CountSelectServiceid(int startRow, int endRow, String id) {
		String sql = "SELECT * FROM BOARDLISTS WHERE ID=? AND RN BETWEEN ? AND ?"; // 뷰 조회
		List<BoardDTO> list = new ArrayList<BoardDTO>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
				dto.setId(rs.getString("id"));
				dto.setCount(rs.getInt("count"));
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

}