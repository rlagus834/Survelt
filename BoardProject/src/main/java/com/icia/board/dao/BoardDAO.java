package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired //
	private SqlSessionTemplate sql;

	
	public int boardWriteInsert(BoardDTO dto) {
		// TODO Auto-generated method stub
	return sql.insert("Board.boardWriteInsert", dto);
	
	}


	public List<BoardDTO> board() {
		// TODO Auto-generated method stub
		return sql.selectList("Board.board");
	}


	public List<BoardDTO> listPaging(int startRow, int endRow) {
		// TODO Auto-generated method stub
		return sql.selectList("Board.board");		
	}

}
