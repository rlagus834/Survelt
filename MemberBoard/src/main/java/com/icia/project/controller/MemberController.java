package com.icia.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.project.dto.MemberDTO;
import com.icia.project.service.MemberService;
import java.util.*;
@Controller
public class MemberController {
@Autowired
MemberService service;

@Autowired
HttpSession session;

	ModelAndView mav;
	
	
	@RequestMapping(value="/joinForm",method=RequestMethod.GET)
	public String joinForm() {
		return "join";		
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck",method=RequestMethod.GET)
	public String idCheck(@RequestParam("id") String id) {
				String result=service.idCheck(id);
				return result;
	}
	
	
	@RequestMapping(value="/MemberJoin",method=RequestMethod.POST)
	public ModelAndView MemberJoin(@ModelAttribute MemberDTO dto) throws IllegalStateException, IOException {
				mav=new ModelAndView();
				mav=service.MemberJoin(dto);
				return mav;
	}
@ResponseBody
	@RequestMapping(value="/LoginCheck",method=RequestMethod.POST)
	public String LoginCheck(@RequestParam("id") String id,@RequestParam("password") String password) {
String result=service.LoginCheck(id,password);
	return result;
	}

@ResponseBody
@RequestMapping(value="/selectMember",method=RequestMethod.GET)
public List<MemberDTO> selectMember(@RequestParam("id") String id) {
	List<MemberDTO> result=service.selectMember(id);
return result;
}

@ResponseBody
@RequestMapping(value="/MemberDelete",method=RequestMethod.GET)
public int MemberDelete(@RequestParam("id") String id) {
	int result=service.MemberDelete(id);
return result;
}


	@RequestMapping(value="/LoginForm",method=RequestMethod.GET)
	public String LoginForm() {
				return "LoginForm";
	}
	@RequestMapping(value="/LogOut",method=RequestMethod.GET)
	public String LogOut() {
		session.invalidate();
				return "Main";
	}
	
	
	
}
