package com.icia.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberJoin {

	ModelAndView mav;

	@Autowired
	MemberService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}

	@RequestMapping(value = "/joinform", method = RequestMethod.GET)
	public String joinForm() {

		return "join";
	}

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {

		return "LoginForm";
	}

	@RequestMapping(value = "/memberUpdateSelect", method = RequestMethod.GET) // RequestParam("파라미터이름") 값을담을타입 변수명																				// request.getParameter("")같은것 특정 값만																				// 가져올수있음
	public ModelAndView memberUpdateSelect(@RequestParam("id") String id) {
		mav = new ModelAndView();
		mav = service.memberUpdateSelect(id);
		return mav;
	}
	
	
	@RequestMapping(value="/memberUpdate",method=RequestMethod.POST)
	public ModelAndView memberUpdate(@ModelAttribute MemberDTO dto) {
		mav=new ModelAndView();
		mav=service.memberUpdate(dto);
		return mav;
		
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute MemberDTO dto) {

		mav = new ModelAndView();
		return mav = service.login(dto);

	}

	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public ModelAndView MemberJoin(@ModelAttribute MemberDTO dto) {

		mav = new ModelAndView();
		return mav = service.memberJoin(dto);

	}

	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public ModelAndView MemberListSelect() {
		mav = new ModelAndView();
		return mav = service.memberList();

	}

	@RequestMapping(value="/memberDelete",method=RequestMethod.GET)
	public ModelAndView MemberDelete(@RequestParam("id") String id) {//@RequestParam("가져올파라미터") 파라미터 타입 파라미터값넣을변수명
		mav=new ModelAndView();
		return mav=service.memberDelete(id);
		
	}
	
	
}
