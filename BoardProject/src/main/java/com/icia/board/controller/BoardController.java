package com.icia.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;
import java.util.*;
@Controller
public class BoardController {
ModelAndView mav;

@Autowired
BoardService service;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Main() {
		return "Main";
		
		
	}

	
	@RequestMapping(value="/boardWrite",method=RequestMethod.GET)
	public String 	boardWrite() {
		return "board/boardWrite";
		
		
	}
	
	

	@RequestMapping(value="/boardWriteInsert",method=RequestMethod.GET)
	public ModelAndView	boardWriteInsert(@ModelAttribute BoardDTO dto) {
	mav=new ModelAndView();
		mav=service.boardWriteInsert(dto);
		return mav;
				
	}
	
	@ResponseBody
	@RequestMapping(value="/board",method=RequestMethod.GET)
	public List<BoardDTO> board() {

		List<BoardDTO> list=service.board();
		return list;
				
	}
	

//	@RequestMapping(value="/board",method=RequestMethod.GET)
//	public List<BoardDTO> boardSelect(@RequestParam("bnum") int bnum) {
//		Model=service.boardSelect(bnum);
//		return list;
//				
//	}
		
	
	
}
