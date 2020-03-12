package com.icia.member.controller;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.api.KakaoJoinApi;
import com.icia.member.api.KakaoLoginApi;
import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import com.icia.member.service.kakaoService;

import java.util.*;

@Controller
public class MemberJoin {

	ModelAndView mav;
	@Autowired
	HttpSession session;

	@Autowired
	MemberService service;

	@Autowired
	kakaoService kakaoService;

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

	@RequestMapping(value = "/memberUpdateSelect", method = RequestMethod.GET) // RequestParam("파라미터이름") 값을담을타입 변수명 //
																				// 가져올수있음
	public ModelAndView memberUpdateSelect(@RequestParam("id") String id) {
		mav = new ModelAndView();
		mav = service.memberUpdateSelect(id);
		return mav;
	}

	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public ModelAndView memberUpdate(@ModelAttribute MemberDTO dto) {
		mav = new ModelAndView();
		mav = service.memberUpdate(dto);
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

	@RequestMapping(value = "/memberDelete", method = RequestMethod.GET)
	public ModelAndView MemberDelete(@RequestParam("id") String id) {// @RequestParam("가져올파라미터") 파라미터 타입 파라미터값넣을변수명
		mav = new ModelAndView();
		return mav = service.memberDelete(id);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		session.invalidate(); // 로그아웃가능 세션자제초기화
		return "home";
	}

	// 아이디 중복체크
	@RequestMapping(value = "/idoverlap", method = RequestMethod.POST)
	public @ResponseBody String idOverlap(@RequestParam("id") String id) { // 리턴값을 주소가아닌 ajax로 인식하게 만드는기능 @ResponseBody
		System.out.println("값:" + id);
		String resultMsg = service.idOverlap(id);
		return resultMsg;
	}

	// 상세조회 스프링
	@RequestMapping(value = "/viewId", method = RequestMethod.POST)
	public @ResponseBody MemberDTO viewId(@RequestParam("id") String id) { // 리턴값을 주소가아닌 ajax로 인식하게 만드는기능 @ResponseBody
		System.out.println("값:" + id);
		MemberDTO list = service.viewId(id);
		return list;
	}

	// 카카오서버로그인
	@RequestMapping(value = "/KakaoJoin", method = RequestMethod.GET)
	public  ModelAndView kakaojoin(HttpSession session) { // 리턴값을 주소가아닌 ajax로 인식하게 만드는기능 @ResponseBody
		String kakaoUrl = KakaoJoinApi.getAuthorizationUrl(session); //프리패스권한 받아옴
		mav = new ModelAndView();
		mav.addObject("kakaoUrl", kakaoUrl); 
		System.out.println(kakaoUrl);
		mav.setViewName("kakaoLogin");
		return mav;

	}

	// 카카오 서버 인증 통과후 처리

	@RequestMapping(value = "/hnkakaoJoinOK", method = RequestMethod.GET)
	public ModelAndView kakaojoin(@RequestParam("code") String code, HttpSession session) { // 리턴값을 주소가아닌
																											// ajax로
																											// 인식하게
																											// 만드는기능
																											// @ResponseBody
		String kakaoUrl = KakaoJoinApi.getAuthorizationUrl(session);
		mav = new ModelAndView();
		JsonNode token = KakaoJoinApi.getAccessToken(code);

		JsonNode profile = KakaoJoinApi.getKakaoUserInfo(token.path("access_token"));
		System.out.println("값:" + profile);
		mav = kakaoService.kakaoJoin(profile);
		return mav;
	}

	
	@RequestMapping(value = "/Kakaologin", method = RequestMethod.GET)
	public @ResponseBody ModelAndView Kakaologin(HttpSession session) { // 리턴값을 주소가아닌 ajax로 인식하게 만드는기능 @ResponseBody
		String kakaoUrl = KakaoLoginApi.getAuthorizationUrl(session);
		mav = new ModelAndView();
		mav.addObject("kakaoUrl", kakaoUrl);
		System.out.println(kakaoUrl);
		mav.setViewName("kakaoLogin");
		return mav;

	}

	
	@RequestMapping(value = "/hnkakaoLoginOK", method = RequestMethod.GET)
	public ModelAndView kakaoLoginOK(@RequestParam("code") String code, HttpSession session) { // 리턴값을 주소가아닌
																											// ajax로
																											// 인식하게
																											// 만드는기능
																											// @ResponseBody
		String kakaoUrl = KakaoLoginApi.getAuthorizationUrl(session);
		mav = new ModelAndView();
		JsonNode token = KakaoLoginApi.getAccessToken(code);

		JsonNode profile = KakaoLoginApi.getKakaoUserInfo(token.path("access_token"));
		System.out.println("값:" + profile);
		mav = kakaoService.kakaoLogin(profile);
		return mav;
	}

	
}
