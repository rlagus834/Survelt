package com.icia.project.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.project.dto.BoardDTO;
import com.icia.project.dto.MemberDTO;
import java.util.*;
@Repository
public class BoardDAO {
	@Autowired // 싱글톤 기능
	private SqlSessionTemplate sql;

	public List<BoardDTO> BoardList() {
		// TODO Auto-generated method stub
		return sql.selectList(statement, parameter);
	}
	
	
}
