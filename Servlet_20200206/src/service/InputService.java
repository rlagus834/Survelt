package service;

import java.util.*;

import dao.MemberDAO;

import java.sql.*;

import dto.MemberDTO;

import static db.JdbcUtil.*;

public class InputService {




	public boolean inserts(MemberDTO md) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.inserts(md);
		if (result > 0) {
			commit(con);
			return true;
		} else {
			rollback(con);
			return false;
		}

	}
	
	public boolean login(MemberDTO md) {
		MemberDAO dao=MemberDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
	int result=dao.login(md);		
		if (result > 0) {			
			return true;
		} else {
			return false;
		}
	}
	public List<MemberDTO> adminSelect() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();//select라 List를 리턴받아 또 controller에 리턴할꺼라 list생성
		MemberDAO dao = MemberDAO.getInstance();//싱글톤사용이유=여러객체를 선언하지않고 하나의 객체만을 이용할때 쓰이는데 지금도 하나의 객체만을 쓸거라
		Connection con = getConnection();  //  싱글톤 쓰면 여러객체 안써서 용량 차지를 줄임 getConnection은 static이라 객체선언안해도 쓸수있음
		dao.setConnection(con);   //db접속권한이 담긴 con을 dao.setConnection()에 담아서 호출해서 dao도db접속권한생김  
		list= dao.adminSelect();//dao.adminSelect 메소드 호출후 리턴값 list에저장후
		return list;  //list리턴
	
	}

	public List<MemberDTO> clientSelect(String id) {
		MemberDAO dao=MemberDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		return list=dao.clientSelect(id);		
	
	}
	public boolean check(MemberDTO md) {
		MemberDAO dao=MemberDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
	int result=dao.login(md);		
		if (result > 0) {			
			return true;
		} else {
			return false;
		}
	}
	public boolean update(MemberDTO dto) {		
		MemberDAO dao=MemberDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		int result=dao.update(dto);
		if(result>0) {
			commit(con);
			return true;
		}else {
			rollback(con);
			return false;
		}

	}
	
	public void deleteCilent(String id) {
		MemberDAO dao=MemberDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		dao.deleteClient(id);		
	}	
	
	
	
	
	
	
	
	
}
