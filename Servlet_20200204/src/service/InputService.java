package service;

import java.util.*;

import java.sql.*;
import dao.DAO;
import static db.JdbcUtil.*;

public class InputService {
List<String> list=new ArrayList<String>();
	
	public boolean inputDB(String data1,String data2) {
		
		/*
		 * 1.DAO 클래스에 대한 객체를 getInstance() 메소드를 호출하여 받아옴
		 *2.jdbcutil로 부터 connection 객체를 받아옴.
		 *3.DAO 클래스에 접속완료된 정보를 전달
		 *4.DAO클래스이 insert 수행 메소드 호출하여 DB연동 작업수행
		 */
		

		DAO dao=DAO.getInstance();
				Connection con=getConnection();
dao.setConnection(con);
boolean inputResult=false;
int	result=dao.inputDB(data1, data2);

if(result>0) {
commit(con);
inputResult=true;
}else {
	rollback(con);
	inputResult=false;
}
		
		
		close(con);
		return inputResult;
	}
	public List<String> selectDB() {
		DAO dao=DAO.getInstance();//싱글톤 사용하기위해 씀
		Connection con=getConnection();//db접속 getConnection만써도 되는이유=static이라 객체선언안해도됨
		dao.setConnection(con);//dao에게 db접속할수있는메소드를 호출해서 db접속권한 매개변수를 줌
	 
		
		
		
		
		return list=dao.selectDB(); //dao의selectDB메소드를 호출후 리턴된값을 list에대입
	
	 
		
	}
	
	
}
