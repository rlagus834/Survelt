package com.icia.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.project.dto.BoardDTO;
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

	public List<MemberDTO> selectMember(String id) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.selectMember",id);
	}

	public int MemberDelete(String id) {
		// TODO Auto-generated method stub
		return sql.delete("Project.MemberDelete", id);
	}

	public int WriteCount(String id) {
		// TODO Auto-generated method stub
		return sql.selectOne("Project.WriteCount",id);
	}

	public List<BoardDTO> MyWrite(String id) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.MyWrite", id);
	}

	public MemberDTO MemberUpdateSelect(String id) {
		// TODO Auto-generated method stub
		return sql.selectOne("Project.MemberUpdateSelect", id);
	}

	public void MemberUpdate(MemberDTO dto) {
		// TODO Auto-generated method stub
		sql.update("Project.MemberUpdate", dto);
	}
	
	
	
}
