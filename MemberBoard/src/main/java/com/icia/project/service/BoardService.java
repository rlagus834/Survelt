package com.icia.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.icia.project.dao.BoardDAO;
import com.icia.project.dto.BoardDTO;
import com.icia.project.dto.PageDTO;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpSession;



@Service
public class BoardService {

	@Autowired
	BoardDAO dao;

	@Autowired
	HttpSession session;

	private ModelAndView mav;

	
	public Map<String, Object> BoardList(int page) {
		int limit = 3;

		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		PageDTO dto=new PageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		
		int listCount = dao.BoardListCount();
		List<BoardDTO> list = dao.BoardList(dto);
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

	public ModelAndView BoardWrite(BoardDTO dto, MultipartHttpServletRequest mtfRequest) throws IOException {
		// TODO Auto-generated method stub
		List<MultipartFile> filelist = mtfRequest.getFiles("bfile");
		mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		dto.setId(id);
		dao.BoardWrite(dto);
		// MultipartHttpServletRequest타입변수를 가져와 업로드할 파일의 정보를가져옴
		// 정보가담긴mtfRequest변수에담긴 파일이아닌 파일들의 정보를 가져와야하므로 getFiles("여러파일의 정보가담긴 파일태그
		// name")을 사용
		if (filelist.size() > 0) {// 파일리스트에 저장된값이 있으면 반응하게함
			for (int i = 0; i < filelist.size(); i++) {// filelist에 담긴 파일들의 갯수(size)만큼for문을 돌림
				dto.setFilesRealName(filelist.get(i).getOriginalFilename());// filelist에담긴파일중.i번째인 파일의정보를get해서 파일의 오리지널
																			// 이름만.getOriginalFilename()으로 가져와서
				// 업로드할 파일이 중복되면 덮어쓰기되므로 중복안되게 파일명을 랜덤하게 하기위한 메소드에 세팅하여 저장할값을 리턴받는다
				String uploadFileName = uploadFile(filelist.get(i).getOriginalFilename(), filelist.get(i).getBytes());
				dto.setFiles(uploadFileName);// 나중에 jsp에서 띄울때 필요한 저장된 파일의 이름 저장
				dao.FileWrite(dto);
			}
		} else {

		}
		mav.setViewName("BoardList");
		return mav;
	}

	private String uploadFile(String originalName, byte[] bytes) throws IOException {
//랜덤한 파일명을 만들기위한 랜덤값을 주는 uuid객체생성 
		UUID uuid = UUID.randomUUID();
		// 랜덤생성이름+파일이름 합치기
		String saveFileName = uuid + "_" + originalName;
		String savePath = "C:\\Users\\6\\git\\repository\\MemberBoard\\src\\main\\webapp\\resources\\fileUpload\\";// 저장경로
		File target = new File(savePath, saveFileName);// 파일경로+랜덤이름과합쳐진 파일이름이담긴 파일로 새로 만들어 변수에대입
		FileCopyUtils.copy(bytes, target);// target와 가져온 바이트를 세팅하여 새로운 파일로 만들어(copy) 디렉토리로복사
		return saveFileName; // 파일경로+랜덤이름과합쳐진 파일이름이담긴변수 리턴
	}

	public ModelAndView BoardView(int bnum) {
		// TODO Auto-generated method stub
		 mav=new ModelAndView();
		 List<BoardDTO> list=dao.BoardView(bnum);
		 List<BoardDTO> fileList=dao.FilesView(bnum);
		 mav.addObject("list", list);
		 mav.addObject("fileList", fileList);
		 mav.addObject("bnum", bnum);
		 mav.setViewName("BoardView");
		 return mav;
	}

	public ModelAndView BoardUpdateForm(int bnum) {
		// TODO Auto-generated method stub
		 mav=new ModelAndView();
		 List<BoardDTO> list=dao.BoardView(bnum);
		 List<BoardDTO> fileList=dao.FilesView(bnum);
		 mav.addObject("list", list);
		 mav.addObject("fileList", fileList);
		 mav.addObject("bnum", bnum);
		 mav.setViewName("BoardUpdateForm");
		 return mav;
	}
	
}
