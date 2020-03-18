package com.icia.project.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.project.dto.BoardDTO;
import com.icia.project.dto.MemberDTO;
import com.icia.project.dto.PageDTO;

import java.util.*;
@Repository
public class BoardDAO {
	@Autowired // 싱글톤 기능
	private SqlSessionTemplate sql;

	public List<BoardDTO> BoardList(PageDTO dto) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.BoardList", dto);
	}

	public void FileWrite(BoardDTO dto) {
		// TODO Auto-generated method stub
		sql.insert("Project.FileWrite",dto);
	}

	public void BoardWrite(BoardDTO dto) {
		// TODO Auto-generated method stub
		sql.insert("Project.BoardWrite",dto);
			
	}

	public int BoardListCount() {
		// TODO Auto-generated method stub
		return sql.selectOne("Project.BoardListCount");
		}

	public List<BoardDTO> BoardView(int bnum) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.BoardView",bnum);
	}

	public List<BoardDTO> FilesView(int bnum) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.FilesView", bnum);
	}
	
	
}
