package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dto.CommentDTO;
import dto.MoviesDTO;
import service.GoodService;

//import javax.sql.*;
//import javax.xml.ws.Response;

public class MoviesDAO {
	private static MoviesDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	PreparedStatement pstmts;
	ResultSet rss;
	int save = 0;

	public static MoviesDAO getInstance() {// 싱글톤=new 여러번 쓰지않고 한번만 객체선언해서 그 객체만 쓰게끔하고싶을때 쓰는기능
		if (dao == null) {
			dao = new MoviesDAO(); // DAO(Data Access Object)는 메소드(주요기능)들을 전담(갖고있도록)하도록 만든 클래스(오브젝트).
		}
		return dao;

	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int Boards(MoviesDTO dto) {
		String sql = "INSERT INTO MOVIES VALUES((SELECT MAX(MNUM) FROM MOVIES)+1,?,?,?,?)";
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

	public String goodA(String id) {
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

	public List<MoviesDTO> MovieList(String search, int startRow, int endRow) {
		String sql = "SELECT * from (select rownum as numrow,s.* from movies s where s.mname like ? order by numrow desc)where numrow between ? and ?";
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

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

	public List<MoviesDTO> MovieList(String search) {
		String sql = "SELECT * from where mname LIKE ?";
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				MoviesDTO dto = new MoviesDTO();
				dto.setBoardnumber(rs.getInt("mnum"));
				dto.setBoardtitle(rs.getString("mname"));
				dto.setDateofissue(rs.getString("dateofissue"));
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

	public int SelectCount(String select, String filters, int mnum) {
		String sql = null; //
		int count = 0;
		if (filters.equals("베댓순")) {
			sql = "SELECT * FROM SYMPATHYVIEWGOODS WHERE MNUM=?"; // 뷰 조회
		} else if (filters.equals("최신순")) {
			sql = "SELECT * FROM SYMPATHYVIEW WHERE MNUM=?"; // 뷰 조회
		} else if (filters.equals("작성자")) {
			sql = "SELECT * FROM SYMPATHYVIEW WHERE MNUM=? AND  ID LIKE ?"; // 뷰 조회
		} else if (filters.equals("글내용")) {
			sql = "SELECT * FROM SYMPATHYVIEW WHERE MNUM=? AND  TEXT LIKE ?"; // 뷰 조회
		}

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			if (filters.equals("글내용") || filters.equals("작성자")) {
				pstmt.setString(2, "%" + select + "%");
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
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

	public int MovieListCount(String select) {
		String sql = "SELECT * FROM MOVIE WHERE MNAME LIKE ?"; //
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
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

	public int SelectCount(String select) {

		int count = 0;
		String sql = "SELECT * FROM MOVIES WHERE MNAME LIKE ?"; // 뷰 조회

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + select + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
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

	public List<CommentDTO> CountSelectServiceSearch(int startRow, int endRow, String search, String filters, int mnum,
			String id) {
		String sql = null;
		boolean result = true;
		if (filters.equals("베댓순")) {
			sql = "SELECT * FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEWGOODS S WHERE S.MNUM=? ORDER BY RN ASC) WHERE NUMROW BETWEEN ? AND ?"; // 뷰
//			sql = "select * from(SELECT * FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEWGOODS S WHERE S.MNUM=? ORDER BY RN ASC)  WHERE NUMROW BETWEEN ? AND ?)b,(SELECT UPCHANCE,BNUM FROM GOODLIMIT WHERE BNUM IN(SELECT BNUM FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE  S.MNUM=? ORDER BY RN ASC) WHERE NUMROW BETWEEN ? AND ? AND ID=?))c where c.bnum(+)=b.bnum";
			// 조회
		} else if (filters.equals("최신순")) {
			sql = "SELECT * FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.MNUM=? ORDER BY RN ASC) WHERE NUMROW BETWEEN ? AND ?"; // 뷰
//			sql = "select * from (SELECT * FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.ID LIKE ? AND S.MNUM=? ORDER BY RN ASC)  WHERE NUMROW BETWEEN ? AND ?)b,(SELECT UPCHANCE,BNUM FROM GOODLIMIT WHERE BNUM IN(SELECT BNUM FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.ID LIKE ? AND S.MNUM=?) WHERE NUMROW BETWEEN ? AND ? AND ID=?))c,(SELECT DWCHANCE,BNUM FROM MINUSLIMIT WHERE BNUM IN(SELECT BNUM FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.ID LIKE ? AND S.MNUM=?) WHERE NUMROW BETWEEN ? AND ? AND ID=?))e where c.bnum(+)=b.bnum AND c.bnum=e.bnum(+) order by numrow asc";
			// 조회
		} else if (filters.equals("작성자")) {
			sql = "SELECT * FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.ID LIKE ? AND S.MNUM=? ORDER BY RN ASC) WHERE NUMROW BETWEEN ? AND ? "; // 뷰
//			sql = "select * from (SELECT * FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.ID LIKE ? AND S.MNUM=? ORDER BY RN ASC)  WHERE NUMROW BETWEEN ? AND ?)b,(SELECT UPCHANCE,BNUM FROM GOODLIMIT WHERE BNUM IN(SELECT BNUM FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.ID LIKE ? AND S.MNUM=?) WHERE NUMROW BETWEEN ? AND ? AND ID=?))c,(SELECT DWCHANCE,BNUM FROM MINUSLIMIT WHERE BNUM IN(SELECT BNUM FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.ID LIKE ? AND S.MNUM=?) WHERE NUMROW BETWEEN ? AND ? AND ID=?))e where c.bnum(+)=b.bnum AND c.bnum=e.bnum(+) order by numrow asc";
			// 조회
		} else if (filters.equals("글내용")) {
			sql = "SELECT * FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.TEXT LIKE ? AND S.MNUM=? ORDER BY RN ASC) WHERE NUMROW BETWEEN ? AND ? ";
//						sql="select * from(SELECT * FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.TEXT LIKE ? AND S.MNUM=? ORDER BY RN ASC)  WHERE NUMROW BETWEEN ? AND ?)b,(SELECT UPCHANCE,BNUM FROM GOODLIMIT WHERE BNUM IN(SELECT BNUM FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.TEXT LIKE ? AND S.MNUM=? ORDER BY RN ASC) WHERE NUMROW BETWEEN ? AND ? AND ID=?))c where c.bnum(+)=b.bnum" ; 
//			sql = "select * from (SELECT * FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.TEXT LIKE ? AND S.MNUM=? ORDER BY RN ASC)  WHERE NUMROW BETWEEN ? AND ?)b,(SELECT UPCHANCE,BNUM FROM GOODLIMIT WHERE BNUM IN(SELECT BNUM FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.TEXT LIKE ? AND S.MNUM=?) WHERE NUMROW BETWEEN ? AND ? AND ID=?))c,(SELECT DWCHANCE,BNUM FROM MINUSLIMIT WHERE BNUM IN(SELECT BNUM FROM (SELECT ROWNUM AS NUMROW,S.* FROM SYMPATHYVIEW S WHERE S.TEXT LIKE ? AND S.MNUM=?) WHERE NUMROW BETWEEN ? AND ? AND ID=?))e where c.bnum(+)=b.bnum AND c.bnum=e.bnum(+) order by numrow asc";
			// 조회
		}
		List<CommentDTO> list = new ArrayList<CommentDTO>();

		try {
			pstmt = con.prepareStatement(sql);
			if (filters.equals("작성자") || filters.equals("글내용")) {
				pstmt.setString(1, "%" + search + "%");
				pstmt.setInt(2, mnum);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
//				pstmt.setString(5, "%" + search + "%");
//				pstmt.setInt(6, mnum);
//				pstmt.setInt(7, startRow);
//				pstmt.setInt(8, endRow);
//				pstmt.setString(9, id);
			} else {
				pstmt.setInt(1, mnum);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String save = "";
				CommentDTO dto = new CommentDTO();
				GoodService service = new GoodService();
				System.out.println(rs.getInt("bnum"));
				result = service.GoodSelect(rs.getInt("bnum"), id);
				if (result) {
					save = "YES";
					dto.setGchance(save);
				} else {
					save = "NO";
					dto.setGchance(save);
				}
				result = service.MinusSelect(rs.getInt("bnum"), id);
				if (result) {
					save = "YES";
					dto.setMchance(save);
				} else {
					save = "NO";
					dto.setMchance(save);
				}
				dto.setBnum(rs.getInt("bnum"));
				dto.setCdate(rs.getString("cdate"));
				dto.setId(rs.getString("id"));
				dto.setScore(rs.getInt("score"));
				dto.setText(rs.getString("text"));
				dto.setGcnum(rs.getInt("goods"));
				dto.setMcnum(rs.getInt("minuss"));
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

	public String SympathyCheck(String id, int mnum) {
		String sql = "SELECT CHANCE FROM SYMPATHY WHERE ID=? AND MNUM=?"; // 뷰 조회
		String result = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, mnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getString("chance");
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

}