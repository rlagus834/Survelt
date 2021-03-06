package com.icia.member.service;

import javax.servlet.http.HttpSession;
import java.util.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {
	ModelAndView mav;

	@Autowired
	MemberDAO dao;

	@Autowired
	private HttpSession session;// 로그인한 아이디 유지할 세션 필드 선언

	public ModelAndView memberJoin(MemberDTO dto) {
		mav = new ModelAndView();

		int result = dao.memberJoin(dto);
		if (result > 0) {
			mav.setViewName("home");
		} else {
			mav.setViewName("fail");
		}
		return mav;

	}

	public ModelAndView login(MemberDTO dto) {
		mav = new ModelAndView();
		String id = dao.login(dto);
		if (id != null) {
			mav.setViewName("MemberMain");
			session.setAttribute("id", id);
		} else {

			mav.setViewName("LoginForm");

		}
		return mav;

	}

	public ModelAndView memberList() {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		List<MemberDTO> list = dao.memberList();
		mav.addObject("memberList", list);
		mav.setViewName("memberList");
		return mav;

	}

	public ModelAndView memberUpdateSelect(String id) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		List<MemberDTO> list = dao.memberUpdateSelect(id);
		if (list != null) {
			mav.setViewName("MemberUpdateSelect");
			mav.addObject("memberList", list);

		} else {
			mav.setViewName("fail");
			mav.addObject("memberList", list);

		}
		return mav;
	}

	public ModelAndView memberUpdate(MemberDTO dto) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		int result = dao.memberUpdate(dto);
		if (result > 0) {
			System.out.println("zxzx");
			mav.setViewName("redirect:/memberList");//컨트롤러로 바로가는법
		} else {
			mav.setViewName("redirect:/memberList");
		}
		return mav;

	}

	public ModelAndView memberDelete(String id) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		int result = dao.memberDelete(id);
		if (result > 0) {
			mav.setViewName("redirect:/memberList");

		} else {
			mav.setViewName("redirect:/memberList");
		}
		return mav;
	}

	public void logout() {
		// TODO Auto-generated method stub
		session.removeAttribute("id");
		
	}

	public String idOverlap(String id) {
		// TODO Auto-g
		
		String checkResult=dao.idOverlap(id);
String resultMsg=null;
if(checkResult==null) {
	resultMsg="OK";
}else {

	resultMsg="NO";
}
	return resultMsg;
	}

	public MemberDTO viewId(String id) {
		// TODO Auto-generated method stub
		MemberDTO cost=dao.viewId(id);
		return cost;

	}

	public ModelAndView naverLogin(String profile) throws ParseException {
		// TODO Auto-generated method stub
		mav=new ModelAndView();
		JSONParser parser = new JSONParser(); //JSON형태의 변수
		Object obj = parser.parse(profile); 
        JSONObject naverUser=(JSONObject) obj;
        JSONObject userInfo=(JSONObject)naverUser.get("response");
        String naverId=(String) userInfo.get("id");
//        String email=(String) userInfo.get("email");
//        String name=(String) userInfo.get("name");
//        String gender=(String) userInfo.get("gender");
//        String birthday=(String) userInfo.get("birthday");
        System.out.println("값:"+naverId);
        MemberDTO naverMember=dao.naverLogin(naverId);
        session.setAttribute("id", naverMember.getId());
       
        mav.addObject("naverId", naverId);
        mav.setViewName("MemberMain");
		return mav;
	}

}
