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

public static DAO getInstance() {//싱글톤=new 여러번 쓰지않고 한번만 객체선언해서 그 객체만 쓰게끔하고싶을때 쓰는기능s
	if(dao==null) {       
		dao= new DAO(); //DAO(Data Access Object)는 메소드(주요기능)들을 전담(갖고있도록)하도록 만든 클래스(오브젝트).
	}
	return dao;
	
}

public void setConnection(Connection con) {
	this.con=con;
}
	
public int inputDB(String data1,String data2) {
String sql="INSERT INTO TEST VALUES(?,?)";
int result = 0;
try {
	pstmt=con.prepareStatement(sql);
	pstmt.setString(1, data1);
	pstmt.setString(2, data2);
	result=pstmt.executeUpdate();
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return result; 		
}

public List<String> selectDB() {
	String sql="SELECT * FROM TEST";
	List<String> list=new ArrayList<String>(); 
	try {
		
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {           //list.add(select한값들을 list에추가)
		list.add(rs.getString("id"));
		list.add(rs.getString("password"));			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		close(pstmt); //다쓴 기능들을 close하여 꺼버림 @안끄면 에러나는경우가 가끔있어서그럼
		close(rs);
		
	}
	
	return list;//list(select한 값들을 전달)
	
}

}