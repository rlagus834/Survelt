package com.icia.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

@Controller
public class BoardController {

	@Autowired
	BoardService service;
	
	@Autowired
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
		return "BoardWrite";		
	}
	
	@RequestMapping(value="/BoardListForm",method=RequestMethod.GET)
	public String BoardListForm() {
		return "BoardList";		
	}
	
	@ResponseBody
	@RequestMapping(value="/BoardList",method=RequestMethod.GET)
	public Map<String,Object> BoardList(@RequestParam("page") int page) {
	
		 map=new HashMap<String,Object>();
		map=service
		return map;
	}
	
	
	
}
