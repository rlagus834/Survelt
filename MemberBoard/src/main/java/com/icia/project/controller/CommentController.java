package com.icia.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.icia.project.dto.CommentDTO;
import com.icia.project.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	CommentService service;
	
	@RequestMapping(value="/CommentWrite",method=RequestMethod.POST)
	public int CommentWrite(@RequestParam("bnum") int bnum,@RequestParam("id") String id,@RequestParam("text") String text) {
		CommentDTO dto=new CommentDTO();
		dto.setBnum(bnum);
		dto.setId(id);
		dto.setText(text);
		int result=service.CommentWrite(dto);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/CommentList",method=RequestMethod.POST)
	public Map<String,Object> CommentList(@RequestParam("page") int page,@RequestParam("bnum") int bnum) {
		CommentDTO dto=new CommentDTO();
	Map<String,Object> map=service.CommentList(page,bnum);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/CommentDelete",method=RequestMethod.POST)
	public int CommentDelete(@RequestParam("cnum") int cnum) {
		CommentDTO dto=new CommentDTO();
	int result=service.CommentDelete(cnum);
		return result;
	}
	
	
}
