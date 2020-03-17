package com.icia.project.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.project.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired // 싱글톤 기능
	private SqlSessionTemplate sql;

	public String idCheck(String id) {
		// TODO Auto-generated method stub
		return sql.selectOne("Project.idCheck", id);
	}

	public int MemberJoin(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sql.insert("Project.MemberJoin", dto);
	}

	public String LoginCheck(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sql.selectOne("Project.LoginCheck", map);
	}
	
	
	
}
