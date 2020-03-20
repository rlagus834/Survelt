package com.icia.project.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.project.dao.MemberDAO;
import com.icia.project.dto.MemberDTO;
import java.util.*;

import javax.servlet.http.HttpSession;

@Service
public class MemberService {

	@Autowired
	MemberDAO dao;

	@Autowired
	HttpSession session;

	ModelAndView mav;

	public String idCheck(String id) {
		// TODO Auto-generated method stub
		String result = dao.idCheck(id);
		return result;
	}

	public ModelAndView MemberJoin(MemberDTO dto) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		String save = dto.getAddress();
		save += "@" + dto.getAddressSecond();
		dto.setAddress(save);
		save = dto.getEmail();
		save += dto.getEmailSecond();
		MultipartFile bfile = dto.getBfile();// MultipartFile 타입의 변수에 업로드할파일 대입
	
		String bfileName = bfile.getOriginalFilename();// 파일의 이름을 get해서 변수에대입
		String savePath = "C:\\Users\\6\\git\\repository\\MemberBoard\\src\\main\\webapp\\resources\\fileUpload\\"
				+ bfileName;
		if (!bfile.isEmpty()) {
			bfile.transferTo(new File(savePath));
		}

		dto.setFiles(bfileName);
		dao.MemberJoin(dto);

		mav.setViewName("Main");

		return mav;
	}

	public String LoginCheck(String id, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap();
		map.put("id", id);
		map.put("password", password);
		String result = dao.LoginCheck(map);
		if (result != null) {
			session.setAttribute("id", result);
		} else {
			result = "NO";
		}
		System.out.println(result);
		return result;
	}

	public List<MemberDTO> selectMember(String id) {
		// TODO Auto-generated method stub
		List<MemberDTO> list=dao.selectMember(id);
				return list;
	}

	public int MemberDelete(String id) {
		// TODO Auto-generated method stub
 int result=dao.MemberDelete(id);
		return result;
	}

}
