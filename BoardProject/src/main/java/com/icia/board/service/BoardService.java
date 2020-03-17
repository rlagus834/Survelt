package com.icia.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;

import java.util.*;
@Service
public class BoardService {
@Autowired
BoardDAO dao;

ModelAndView mav;
	
	
	public ModelAndView boardWriteInsert(BoardDTO dto) {
		// TODO Auto-generated method stub
mav=new ModelAndView();
		int result=dao.boardWriteInsert(dto);
	if(result>0) {
		mav.setViewName("Main");
	}else {
		mav.setViewName("Main");
		}
	return mav;
	
	
	
	}


	public List<BoardDTO> board() {
List<BoardDTO> list=dao.board();
System.out.println(list);
return list;
	}




}
