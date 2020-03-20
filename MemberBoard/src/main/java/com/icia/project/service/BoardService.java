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

	public Map<String, Object> BoardList(int page, String search, String select) {
		int listCount = 0;
		List<BoardDTO> list = null;
		int limit = 3;
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		PageDTO dto = new PageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		System.out.println(select);
		System.out.println(search);
		System.out.println(startRow);
		System.out.println(endRow);

		if (select == "") {
			listCount = dao.BoardListCount();
			list = dao.BoardList(dto);
		} else if (search.equals("작성자")) {
			dto.setId(select);
			listCount = dao.BoardListCountId(dto);
			list = dao.BoardListId(dto);
		} else {
			dto.setText(select);
			listCount = dao.BoardListCountText(dto);
			list = dao.BoardListText(dto);
		}
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
		mav = new ModelAndView();
		System.out.println(bnum);
		dao.BoardCount(bnum);
		List<BoardDTO> list = dao.BoardView(bnum);
		List<BoardDTO> fileList = dao.FilesView(bnum);
		mav.addObject("list", list);
		mav.addObject("fileList", fileList);
		mav.addObject("bnum", bnum);
		mav.setViewName("BoardView");
		return mav;
	}

	public ModelAndView BoardUpdateForm(int bnum) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		List<BoardDTO> list = dao.BoardView(bnum);
		List<BoardDTO> fileList = dao.FilesView(bnum);
		mav.addObject("list", list);
		mav.addObject("fileList", fileList);
		mav.addObject("bnum", bnum);
		mav.setViewName("BoardUpdateForm");
		return mav;
	}

	public ModelAndView BoardDelete(int bnum) {
		// TODO Auto-generated method stub
		mav = new ModelAndView();
		List<String> list=dao.FileList(bnum);
		dao.BoardDelete(bnum);
			for (int s = 0; s < list.size(); s++) {// 삭제파일이 담긴 배열의 length만큼 for문 돌림
				System.out.println(list.get(s));
				String savePath = "C:\\Users\\6\\git\\repository\\MemberBoard\\src\\main\\webapp\\resources\\fileUpload\\"
						+list.get(s);// 저장경로
				File f = new File(savePath); // 파일타입으로 만들기위해 파일을 선언하여 삭제할파일 세팅한다
				if (f.exists()) {// 경로에 해당파일 존재시 반응
					f.delete(); // 파일삭제
				}
			}

			
		
		mav.setViewName("BoardList");
		
		return mav;
		
		
	}

	public ModelAndView BoardUpdate(BoardDTO dto, MultipartHttpServletRequest mtfRequest) throws IOException {
		// TODO Auto-generated method stub
		List<MultipartFile> filelist = mtfRequest.getFiles("bfile");
		String[] array = mtfRequest.getParameterValues("deleteFiles");
		System.out.println(array[0]);
		mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		dto.setId(id);
		dao.BoardUpdate(dto);
		// MultipartHttpServletRequest타입변수를 가져와 업로드할 파일의 정보를가져옴
		// 정보가담긴mtfRequest변수에담긴 파일이아닌 파일들의 정보를 가져와야하므로 getFiles("여러파일의 정보가담긴 파일태그
		// name")을 사용
		if (filelist.get(0).getSize() != 0) {// 파일리스트에 저장된값이 있으면 파일사이즈가 있으니 0보다크니까 반응하게함
			for (int i = 0; i < filelist.size(); i++) {// filelist에 담긴 파일들의 갯수(size)만큼for문을 돌림
				dto.setFilesRealName(filelist.get(i).getOriginalFilename());// filelist에담긴파일중.i번째인 파일의정보를get해서 파일의 오리지널
																			// 이름만.getOriginalFilename()으로 가져와서
				// 업로드할 파일이 중복되면 덮어쓰기되므로 중복안되게 파일명을 랜덤하게 하기위한 메소드에 세팅하여 저장할값을 리턴받는다
				String uploadFileName = uploadFile(filelist.get(i).getOriginalFilename(), filelist.get(i).getBytes());
				dto.setFiles(uploadFileName);// 나중에 jsp에서 띄울때 필요한 저장된 파일의 이름 저장
				dao.FileWrite(dto);

			}
			if (mtfRequest.getParameterValues("deleteFiles") != null) {// 삭제할파일이 담겨있을경우 반응
				for (int s = 0; s < array.length; s++) {// 삭제파일이 담긴 배열의 length만큼 for문 돌림
					System.out.println(array[s]);
					dao.FileDelete(array[s]); // db에서삭제
					String savePath = "C:\\Users\\6\\git\\repository\\MemberBoard\\src\\main\\webapp\\resources\\fileUpload\\"
							+ array[s];// 저장경로
					File f = new File(savePath); // 파일타입으로 만들기위해 파일을 선언하여 삭제할파일 세팅한다
					if (f.exists()) {// 경로에 해당파일 존재시 반응
						f.delete(); // 파일삭제

					}
				}

			} else {

			}
		} else {
			if (mtfRequest.getParameterValues("deleteFiles") != null) {// 삭제할파일이 담겨있을경우 반응
				for (int s = 0; s < array.length; s++) {// 삭제파일이 담긴 배열의 length만큼 for문 돌림
					System.out.println(array[s]);

					dao.FileDelete(array[s]); // db에서삭제
					String savePath = "C:\\Users\\6\\git\\repository\\MemberBoard\\src\\main\\webapp\\resources\\fileUpload\\"
							+ array[s];// 저장경로
					File f = new File(savePath); // 파일타입으로 만들기위해 파일을 선언하여 삭제할파일 세팅한다
					if (f.exists()) {// 경로에 해당파일 존재시 반응
						f.delete(); // 파일삭제
					}
				}
			} else {

			}
		}
		mav.setViewName("BoardList");
		return mav;
	}


}
