package com.icia.member.dao;

import java.util.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberDAO {

	
	@Autowired // 싱글톤 기능
	private SqlSessionTemplate sql;   //db를 이용할때필요한 여러 기능(삭제,추가등등)기능을 가진 SqlSessionTemplate 타입 변수sql

	
	
	public int memberJoin(MemberDTO dto) {
		
		return sql.insert("Member.join", dto);
		
		
	}

	public String login(MemberDTO dto) {
		// TODO Auto-generated method stub
		 return sql.selectOne("Member.login", dto);//특정값 select하는 기능
		
		
		
	}

	public List<MemberDTO> memberList() {
		// TODO Auto-generated method stub
		
		return sql.selectList("Member.memberList");//selectList라 자동으로 타입에맞게 저장?
		
//		 return sql.selectOne("Member.memberList");//특정값 select하는 기능
				
	}

	public List<MemberDTO> memberUpdateSelect(String id) {
		// TODO Auto-generated method stub
		return sql.selectList("Member.memberUpdateSelect",id);
	}

	public int memberUpdate(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sql.update("Member.memberUpdate",dto);
	}

	public int memberDelete(String id) {
		// TODO Auto-generated method stub
		return sql.delete("Member.memberDelete", id);
	}
	
	
	
	
}
