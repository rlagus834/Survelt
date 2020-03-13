package com.icia.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;

import java.util.*;
@Service
public class BoardService {
@Autowired
BoardDAO dao;

ModelAndView mav;
	
	
	public ModelAndView boardWriteInsert(BoardDTO dto) {
		// TODO Auto-generated method stub
mav=new ModelAndView();
		int result=dao.boardWriteInsert(dto);
	if(result>0) {
		mav.setViewName("Main");
	}else {
		mav.setViewName("Main");
		}
	return mav;
	
	
	
	}


	public List<BoardDTO> board() {
List<BoardDTO> list=dao.board();
System.out.println(list);
return list;
	}


	public List<BoardDTO> boardSelect() {
		
		
		int page = 1; // 처음 시작할때 1페이지로 시작하니까 응용해서 쓰려고
		int limit = 3; // 보여줄 페이지당 글갯수
		// page파라미터값검사 왜 사용하나?어느페이지로 갈지 알기위해

		// 전체글갯수를 가져오기위한 ListService 클래스 메소드호출 왜가져오나? 전체글갯수가 파악이되야 내가 나누고싶은 페이지당 글갯수대로
		// 나눠서 몇페이지만들어야하는지 연산해야해서
// limit값을 걸어놓은 만큼 범위에 해당하는 글만 가져오는 방법
		int startRow = (page - 1) * limit + 1; // 범위계산 startRow는 a~b 범위 일때 a endRow는b
		int endRow = page * limit;
		int listCount = 0;
		// 한페이지에 3개씩 보여줄때 1페이지에 보여줘야하는글번호(RN기준)
		// 시작글은 1번글 마지막글은 3번글
	
		List<BoardDTO> boardList = dao.listPaging(startRow, endRow);// 범위에맞는

		// 데이터
		// list가져오기
//페이지 계산을 위한 부분
		// 최대로 필요한 페이지 갯수 계산
		int maxPage = (int) ((double) listCount / limit + 0.9);
		// 현재 페이지에 보여줄 시작 페이지 번호(1,11,21,31~~)
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage) { // 글페이지가 7개정도만있어서 10이상 필요없을때
			endPage = maxPage;
		}

		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setListCount(listCount);


	}

}
