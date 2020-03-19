package com.icia.project.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.project.dao.CommentDAO;
import com.icia.project.dto.BoardDTO;
import com.icia.project.dto.CommentDTO;
import com.icia.project.dto.MemberDTO;
import com.icia.project.dto.PageDTO;

import java.util.*;

import javax.servlet.http.HttpSession;

@Service
public class CommentService {

	@Autowired
	CommentDAO dao;

	@Autowired
	HttpSession session;

	ModelAndView mav;

	public int CommentWrite(CommentDTO dto) {
		// TODO Auto-generated method stub
	int result=dao.CommentWrite(dto);
	return result;
	}

	public Map<String, Object> CommentList(int page, int bnum) {
		// TODO Auto-generated method stub
		int limit = 3;
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		PageDTO dto=new PageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		dto.setBnum(bnum);
		dto.setPage(page);
		int listCount = dao.CommentListCount(dto.getBnum());
		List<BoardDTO> list = dao.CommentList(dto);
		int maxPage = (int) ((double) listCount / limit + 0.9);
		// 현재 페이지에 보여줄 시작 페이지 번호(1,11,21,31~~)
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage) { // 글페이지가 7개정도만있어서 10이상 필요없을때
			endPage = maxPage;
		}

		dto.setPage(page);
		dto.setMaxPage(maxPage);
		dto.setStartPage(startPage);
		dto.setEndPage(endPage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", dto);
		map.put("list", list);
		return map;
	}

	public int CommentDelete(int cnum) {
		// TODO Auto-generated method stub
		int result=dao.CommentDelete(cnum);
	return result;
	}



}
