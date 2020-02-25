package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dto.MoviesDTO;
import dto.UsersDTO;

//import javax.sql.*;
//import javax.xml.ws.Response;

public class UsersDAO {
	private static UsersDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static UsersDAO getInstance() {// 싱글톤=new 여러번 쓰지않고 한번만 객체선언해서 그 객체만 쓰게끔하고싶을때 쓰는기능
		if (dao == null) {
			dao = new UsersDAO(); // DAO(Data Access Object)는 메소드(주요기능)들을 전담(갖고있도록)하도록 만든 클래스(오브젝트).
		}
		return dao;

	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int joinInsert(UsersDTO dto) {
		String sql = "INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?,?,(SELECT COUNT(*) FROM USERS)+1)";
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
			pstmt.setString(9, dto.getAcnum());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼

		}
		return result;

	}

	public boolean LoginSelect(UsersDTO dto) {
		String sql = "SELECT * FROM USERS WHERE ID=? AND PW=?";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setId(rs.getString("id"));

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

	public List<UsersDTO> ClientSelect(int startRow, int endRow) {
		String sql = "SELECT * FROM TESTSLIST WHERE RN BETWEEN ? AND ?";
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UsersDTO dto = new UsersDTO();
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

	public int UpdateClient(UsersDTO dto) {
		String sql = "UPDATE USERS SET PW=?,EMAIL=?,ADDRESS=?,PHONE=? WHERE ID=?";
		List<UsersDTO> list = new ArrayList<UsersDTO>();
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getId());

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

	public UsersDTO UpdateClientSelect(String id) {
		String sql = "SELECT * FROM USERS WHERE ID=?";
		UsersDTO dto = new UsersDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("pw"));
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

	
	
	public List<MoviesDTO> MovieSearch() {
		String sql = "SELECT * FROM MOVIES";		
		List<MoviesDTO> list=new ArrayList<MoviesDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MoviesDTO dto=new MoviesDTO();
				dto.setBoardtitle(rs.getString("mname"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block=
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);
		}
		return list;


	}

	public List<MoviesDTO> MovieSelect(String mname) {
		String sql = "SELECT * FROM MOVIES WHERE MNAME=?";		
		List<MoviesDTO> list=new ArrayList<MoviesDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MoviesDTO dto=new MoviesDTO();
				dto.setBoardnumber(rs.getInt("mnum"));
				dto.setBoardtitle(rs.getString("mname"));
			 String save=rs.getString("text");
			
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
			// TODO Auto-generated catch block=
			e.printStackTrace();
		} finally {
			close(pstmt); // 다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);
		}
		return list;


	}
	
	
	
}