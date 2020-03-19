package com.icia.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.project.dto.BoardDTO;
import com.icia.project.dto.CommentDTO;
import com.icia.project.dto.PageDTO;



@Repository
public class CommentDAO {
	@Autowired // 싱글톤 기능
	private SqlSessionTemplate sql;

	public int CommentWrite(CommentDTO dto) {
		// TODO Auto-generated method stub
		return sql.insert("Project.CommentWrite",dto);
	}

	public int CommentListCount(int bnum) {
		// TODO Auto-generated method stub
		return sql.selectOne("Project.CommentListCount",bnum);
	}

	public List<BoardDTO> CommentList(PageDTO dto) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.CommentList",dto);
	}

	public int CommentDelete(int cnum) {
		// TODO Auto-generated method stub
		return sql.delete("Project.CommentDelete", cnum);
	}

	
}
