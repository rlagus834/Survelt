package com.icia.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.icia.project.dto.BoardDTO;
import com.icia.project.service.BoardService;

import java.io.IOException;
import java.util.*;

@Controller
public class BoardController {

	ModelAndView mav;
	
	@Autowired
	BoardService service;
	
	Map<String,Object> map;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Main() {
		return "Main";		
	}
	
	@RequestMapping(value="/Main",method=RequestMethod.GET)
	public String goMain() {
		return "Main";		
	}
	
	@RequestMapping(value="/BoardWriteForm",method=RequestMethod.GET)
	public String BoardWriteForm() {
		return "BoardWriteForm";		
	}
	
	
	@RequestMapping(value="/BoardWrite",method=RequestMethod.POST)
	public ModelAndView BoardWrite(@ModelAttribute BoardDTO dto,MultipartHttpServletRequest mtfRequest) throws IOException {
		mav=new ModelAndView();		
		mav=service.BoardWrite(dto,mtfRequest);
		return mav;
		
		
		
	}
	
	@RequestMapping(value="/BoardView",method=RequestMethod.GET)
	public ModelAndView BoardView(@RequestParam("bnum") int bnum) {
		mav=new ModelAndView();
		mav=service.BoardView(bnum);
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/BoardListForm",method=RequestMethod.GET)
	public String BoardListForm() {
		return "BoardList";		
	}
	
	@ResponseBody
	@RequestMapping(value="/BoardList",method=RequestMethod.GET)
	public Map<String,Object> BoardList(@RequestParam("page") int page) {
	
		 map=new HashMap<String,Object>();
		map=service.BoardList(page);
		return map;
	}
		
	
	@RequestMapping(value="/BoardUpdateForm",method=RequestMethod.GET)
	public ModelAndView BoardUpdateForm(@RequestParam("bnum") int bnum) {
		mav=new ModelAndView();
		mav=service.BoardUpdateForm(bnum);
		return mav;
	}
	
	
	
	
}
