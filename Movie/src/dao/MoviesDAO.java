package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dto.CommentDTO;
import dto.MoviesDTO;

//import javax.sql.*;
//import javax.xml.ws.Response;

public class MoviesDAO {
	private static MoviesDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static MoviesDAO getInstance() {// 싱글톤=new 여러번 쓰지않고 한번만 객체선언해서 그 객체만 쓰게끔하고싶을때 쓰는기능
		if (dao == null) {
			dao = new MoviesDAO(); // DAO(Data Access Object)는 메소드(주요기능)들을 전담(갖고있도록)하도록 만든 클래스(오브젝트).
		}
		return dao;

	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int Board(MoviesDTO dto) {
		String sql = "INSERT INTO BOARDS VALUES(BOARD_SEQ.NEXTVAL,?,?,SYSDATE,0)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardtitle());

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

	public int Boards(MoviesDTO dto) {
		String sql = "INSERT INTO MOVIES VALUES((SELECT COUNT(*) FROM MOVIES),?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardtitle());
			pstmt.setString(2, dto.getText());
			pstmt.setInt(3, dto.getPrice());
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

	public List<MoviesDTO> updateSelectService() {
		String sql = "SELECT * FROM BOARDS";
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MoviesDTO dto = new MoviesDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
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

	public String PasswordCheck(String id) {
		String sql = "SELECT * FROM USERS WHERE ID=?";
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		String result = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getString("pw");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);

		}
		return result;

	}

	public List<MoviesDTO> updateSelectServiceAsc(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLISTS WHERE RN BETWEEN ? AND ? ORDER BY COUNT DESC";
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MoviesDTO dto = new MoviesDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
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

	public List<MoviesDTO> MemberWritingSelect(String id) {
		String sql = "SELECT * FROM BOARDS WHERE ID=?";
		List<MoviesDTO> list = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			list = new ArrayList<MoviesDTO>();
			while (rs.next()) {
				MoviesDTO dto = new MoviesDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));

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

	public String MemberWriting(String id) {
		String sql = "SELECT * FROM USERS WHERE ID=?";
		String result = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = "중복";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);

		}
		return result;

	}

	public List<MoviesDTO> writeOpen(int boardnumber) {
		String sql = "SELECT * FROM BOARDS WHERE BOARDNUMBER=?";
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardnumber);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MoviesDTO dto = new MoviesDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));

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

	public List<MoviesDTO> BorderNumberTextSelect(int bordernum) {
		String sql = "SELECT * FROM MOVIES WHERE MNUM=?";
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bordernum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MoviesDTO dto = new MoviesDTO();
				dto.setBoardnumber(rs.getInt("mnum"));
				dto.setBoardtitle(rs.getString("mname"));
//				dto.setDateofissue(rs.getString("dateofissue"));
				dto.setPrice(rs.getInt("price"));
				dto.setText(rs.getString("text"));
				String save = rs.getString("photo");
				String[] array = save.split("&");
				dto.setPhoto(array[0]);
				dto.setPhoto1(array[1]);
				dto.setPhoto2(array[2]);
				dto.setPhoto3(array[3]);
				dto.setPhoto4(array[4]);
				dto.setPhoto5(array[5]);
				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public int UpdateText(MoviesDTO dto) {
		String sql = "UPDATE MOVIES SET MNAME=?,PRICE=?,TEXT=?,PHOTO=? WHERE MNUM=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
pstmt.setString(1, dto.getBoardtitle());
pstmt.setInt(2, dto.getPrice());
pstmt.setString(3, dto.getText());
pstmt.setString(4, dto.getPhoto());
pstmt.setInt(5, dto.getBoardnumber());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public int BoardTextDelete(int boardnumber) {
		String sql = "DELETE FROM MOVIES WHERE MNUM=?";
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

	public int SelectCount(String select, String filters, int mnum) {
		String sql = null; //
		if (filters.equals("작성자")) {
			sql = "SELECT COUNT(*) FROM SYMPATHYVIEW WHERE MNUM=? AND ID LIKE ? "; // 뷰 조회
		} else if (filters.equals("글내용")) {
			sql = "SELECT COUNT(*) FROM SYMPATHYVIEW WHERE MNUM=? AND TEXT LIKE ? ";
		}
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			pstmt.setString(2, "%" + select + "%");

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

	public List<MoviesDTO> CountSelectService2(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLISTS WHERE RN BETWEEN ? AND ?"; // 뷰 조회
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MoviesDTO dto = new MoviesDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
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

	public List<CommentDTO> CountSelectServiceSearch(int startRow, int endRow, String search, String filters,
			int mnum) {
		String sql = null;
		if (filters.equals("작성자")) {
			sql = "SELECT * FROM SYMPATHYVIEW WHERE MNUM=? AND ID LIKE ? AND RN BETWEEN ? AND ?"; // 뷰 조회
		} else if (filters.equals("글내용")) {
			sql = "SELECT * FROM SYMPATHYVIEW WHERE MNUM=? AND TEXT LIKE ? AND RN BETWEEN ? AND ?"; // 뷰 조회
		}
		List<CommentDTO> list = new ArrayList<CommentDTO>();

		try {
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			System.out.println(mnum);
			pstmt.setInt(1, mnum);
			System.out.println(search);
			pstmt.setString(2, "%" + search + "%");
			pstmt.setInt(3, startRow);
			System.out.println(startRow);
			pstmt.setInt(4, endRow);
			System.out.println(endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setBnum(rs.getInt("bnum"));
				System.out.println(rs.getInt("bnum"));
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

	public List<MoviesDTO> CountSelectServiceid(int startRow, int endRow, String id) {
		String sql = "SELECT * FROM BOARDLISTS WHERE ID=? AND RN BETWEEN ? AND ?"; // 뷰 조회
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				MoviesDTO dto = new MoviesDTO();
				dto.setBoardnumber(rs.getInt("boardnumber"));
				dto.setBoardtitle(rs.getString("boardtitle"));
				dto.setDateofissue(rs.getString("dateofissue"));
//				dto.setId(rs.getString("id"));
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

	public int SympathyPlus(MoviesDTO dto) {
		String sql = "INSERT INTO SYMPATHY VALUES(?,?,?)"; // 뷰 조회
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoardnumber());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, "YES");
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼

		}
		return result;

	}

	public int SympathyMinus(int mnum, String id) {
		String sql = "DELETE FROM SYMPATHY WHERE MNUM=? AND ID=?"; // 뷰 조회
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼

		}
		return result;

	}

	public int SympathySelect(int mnum) {
		String sql = "SELECT COUNT(*) FROM SYMPATHY WHERE MNUM=? "; // 뷰 조회
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼

		}
		return result;

	}

	public String SympathyCheck(String id) {
		String sql = "SELECT CHANCE FROM SYMPATHY WHERE ID=? "; // 뷰 조회
		String result = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getString("chance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼

		}
		return result;

	}
	
	
}