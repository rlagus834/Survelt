package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;
import dao.DAO;
//import javax.sql.*;
//import javax.xml.ws.Response;

public class DAO {
private static DAO dao; 
Connection con;
PreparedStatement pstmt;
ResultSet rs;

public static DAO getInstance() {//s싱글톤=new 여러번 쓰지않고 한번만 객체선언해서 그 객체만 쓰게끔하고싶을때 쓰는기능
	if(dao==null) {       
		dao= new DAO(); //DAO(Data Access Object)는 메소드(주요기능)들을 전담(갖고있도록)하도록 만든 클래스(오브젝트).
	}
	return dao;
	
}

public void setConnection(Connection con) {
	this.con=con;
}

public int insert(String va1) {
	String sql="INSERT INTO NAMETEST VALUES(?)";
	int result=0;
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, va1);
		result=pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}

public List<String> select(){
	String sql="SELECT * FROM NAMETEST";
	List<String> list=new ArrayList<String>();
	try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			list.add(rs.getString("id"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	
	
	
	
}
}