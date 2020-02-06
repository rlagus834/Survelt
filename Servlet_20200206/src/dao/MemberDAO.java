package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;
import dao.MemberDAO;
import dto.MemberDTO;

import service.InputService;
//import javax.sql.*;
//import javax.xml.ws.Response;

public class MemberDAO {
	private static MemberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static MemberDAO getInstance() {// 싱글톤=new 여러번 쓰지않고 한번만 객체선언해서 그 객체만 쓰게끔하고싶을때 쓰는기능
		if (dao == null) {
			dao = new MemberDAO(); // DAO(Data Access Object)는 메소드(주요기능)들을 전담(갖고있도록)하도록 만든 클래스(오브젝트).
		}
		return dao;

	}

	public void setConnection(Connection con) {
		this.con = con;
	}


	public int inserts(MemberDTO md) {
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";
		int num = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, md.getId());
			pstmt.setString(2, md.getPassword());
			pstmt.setString(3, md.getName());
			pstmt.setString(4, md.getBirth());
			pstmt.setString(5, md.getGender());
			pstmt.setString(6, md.getEmail());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt); //다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			
			
		}
	
		return num;

	}
	
	
	public int login(MemberDTO md) {
		String sql="SELECT * FROM MEMBER WHERE ID=? AND PASSWORD=?";
		 int result=0;

		try {			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, md.getId());
			pstmt.setString(2, md.getPassword());
			rs=pstmt.executeQuery();
			while(rs.next()) {								
				md.setId(rs.getString("id"));
				result=1;
			}

	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt); //다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);
			
		}
	
		return result;
	
	
		
		
		
		
		
	}
	public List<MemberDTO> adminSelect() {
		String sql = "SELECT * FROM MEMBER";//조회 쿼리문작성후 sql에 대입
		List<MemberDTO> list = new ArrayList<MemberDTO>(); //list생성
		try {
			pstmt = con.prepareStatement(sql); //시작멘트를 pstmt에대입
			rs = pstmt.executeQuery();//시작멘트 실행명령을 rs에대입
			while (rs.next()) {	//rs가 가지고있는 값이있으면(true) 모든값 뱉음 없으면(false) while 작동안함
				MemberDTO dto=new MemberDTO(); //반복할때마다 새로운 객체 생성하게 하기위해
		 dto.setId(rs.getString("id"));    //테이블정보 다 dto의 필드에 세팅후
			dto.setPassword(rs.getString("password"));
			dto.setName(rs.getString("name"));
			dto.setBirth(rs.getString("birth"));
			dto.setGender(rs.getString("gender"));
			dto.setEmail(rs.getString("email"));
			
			list.add(dto); //클래스타입의 list에추가
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt); //다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
			close(rs);
			
		}


		return list; //list리턴

	}

	

}