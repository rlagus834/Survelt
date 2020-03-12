package com.icia.member.service;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class kakaoService {
	ModelAndView mav;
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private HttpSession session;
	
	
	public ModelAndView kakaoJoin(JsonNode profile) {
		// TODO Auto-generated method stub
		mav=new ModelAndView();
		String kakaoId=profile.get("id").asText();
		System.out.println(kakaoId);
		
			
		mav.addObject("kakaoId",kakaoId);
		mav.setViewName("join");
		
		return mav;
	}


	public ModelAndView kakaoLogin(JsonNode profile) {
		// TODO Auto-generated method stub
		mav=new ModelAndView();
		String kakaoId=profile.get("id").asText();
		
		
		JsonNode kakaoAccount=profile.get("kakao_account");
		JsonNode kakaoProfile=kakaoAccount.get("profile");
	
		
		String nickName=kakaoProfile.path("nickname").asText();
		String email=kakaoProfile.path("email").asText();
String thumbnail=kakaoProfile.path("thumbnail_image_url").asText();		
		
		MemberDTO member=dao.kakakoLogin(kakaoId);
		session.setAttribute("id", member.getId());
		mav.addObject("id", member);
		mav.addObject("thumbnail", thumbnail); 
//		mav.addObject("nickName", nickName);
//		mav.addObject("email", email);
		
		
		mav.setViewName("MemberMain");
		
		return mav;
		
	}

}
