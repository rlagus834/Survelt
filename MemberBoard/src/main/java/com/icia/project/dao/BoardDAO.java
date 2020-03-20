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

	public List<BoardDTO> BoardListId(PageDTO dto) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.BoardListId", dto);
	}

	public int BoardListCountId(PageDTO dto) {
		// TODO Auto-generated method stub
		return sql.selectOne("Project.BoardListCountId",dto);
		}

	public List<BoardDTO> BoardListText(PageDTO dto) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.BoardListText", dto);
	}

	public int BoardListCountText(PageDTO dto) {
		// TODO Auto-generated method stub
		return sql.selectOne("Project.BoardListCountText",dto);
		}
	
	public void FileWrite(BoardDTO dto) {
		// TODO Auto-generated method stub
		sql.insert("Project.FileWrite",dto);
	}

	public void BoardWrite(BoardDTO dto) {
		// TODO Auto-generated method stub
		sql.insert("Project.BoardWrite",dto);
			
	}

	public List<BoardDTO> BoardView(int bnum) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.BoardView",bnum);
	}

	public List<BoardDTO> FilesView(int bnum) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.FilesView", bnum);
	}

	public void BoardDelete(int bnum) {
		// TODO Auto-generated method stub
		sql.delete("Project.BoardDelete", bnum);
	}

	public int BoardListCount() {
		// TODO Auto-generated method stub
		return sql.selectOne("Project.BoardListCount");
	}

	public List<BoardDTO> BoardList(PageDTO dto) {
		// TODO Auto-generated method stub
		return sql.selectList("Project.BoardList",dto);
	}

	public void FileDelete(String files) {
		// TODO Auto-generated method stub
		sql.delete("Project.FileDelete", files);
	}

	public void BoardUpdate(BoardDTO dto) {
		// TODO Auto-generated method stub
		sql.update("Project.BoardUpdate", dto);
	}

	public List<String> FileList(int bnum) {
		// TODO Auto-generated method stub
	return	sql.selectList("Project.FileList", bnum);
	}

	public void BoardCount(int bnum) {
		// TODO Auto-generated method stub
		sql.update("Project.BoardCount", bnum);
	}
	
	
}
