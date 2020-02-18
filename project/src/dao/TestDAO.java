package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;
import dao.TestDAO;
import dto.TestDTO;

//import javax.sql.*;
//import javax.xml.ws.Response;

public class TestDAO {
	private static TestDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static TestDAO getInstance() {// 싱글톤=new 여러번 쓰지않고 한번만 객체선언해서 그 객체만 쓰게끔하고싶을때 쓰는기능
		if (dao == null) {
			dao = new TestDAO(); // DAO(Data Access Object)는 메소드(주요기능)들을 전담(갖고있도록)하도록 만든 클래스(오브젝트).
		}
		return dao;

	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int joinInsert(TestDTO dto) {
		String sql = "INSERT INTO TESTS VALUES(?,?,?,?,?,?,?,?,?,(SELECT COUNT(*) FROM TESTS))";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirth());
			pstmt.setString(5, dto.getGender());
			
			pstmt.setString(6, dto.getEmail());
			
			pstmt.setString(7, dto.getAddress());
			
			pstmt.setString(8, dto.getPhone());
			pstmt.setString(9, dto.getPhoto());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼

		}
		return result;

	}

	public boolean LoginSelect(TestDTO dto) {
		String sql = "SELECT * FROM TESTS WHERE ID=? AND PASSWORD=?";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPhoto(rs.getString("photo"));
				result = true;
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

	public int CountSelect() {
		String sql = "SELECT COUNT(*) FROM TESTS";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
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

	public List<TestDTO> ClientSelect(int startRow, int endRow) {
		String sql = "SELECT * FROM TESTSLIST WHERE RN BETWEEN ? AND ?";
		List<TestDTO> list = new ArrayList<TestDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TestDTO dto = new TestDTO();
				dto.setId(rs.getString("id"));
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

	public int DeleteClient(String id) {
		String sql = "DELETE FROM TESTS WHERE ID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);
		}
		return result;

	}

	public int UpdateClient(TestDTO dto) {
		String sql = "UPDATE TESTS SET PASSWORD=?,EMAIL=?,ADDRESS=?,PHONE=?,PHOTO=? WHERE ID=?";
		List<TestDTO> list = new ArrayList<TestDTO>();
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getPhoto());
			pstmt.setString(6, dto.getId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block=
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);
		}
		return result;

	}

	public TestDTO UpdateClientSelect(String id) {
		String sql = "SELECT * FROM TESTS WHERE ID=?";
		TestDTO dto = new TestDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				String save = rs.getString("email");
				String[] array = save.split("/");				
				dto.setEmail(array[0]);
				dto.setEmail1(array[1]);
				save = rs.getString("address");
				array = save.split("/");
				dto.setAddress(array[0]);				
				dto.setAddress1(array[1]);
				
				
				dto.setPhone(rs.getString("phone"));
				dto.setPhoto(rs.getString("photo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block=
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);
		}
		return dto;

	}

}