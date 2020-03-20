package com.icia.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.icia.project.dto.BoardDTO;
import com.icia.project.service.BoardService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BoardController {

	ModelAndView mav;
	
	@Autowired
	BoardService service;
	
	Map<String,Object> map;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String Main() {
		return "Main";		
	}
	
	@RequestMapping(value="/Main",method=RequestMethod.GET)
	public String goMain() {
		return "Main";		
	}
	
	@RequestMapping(value="/BoardWriteForm",method=RequestMethod.GET)
	public String BoardWriteForm() {
		return "BoardWriteForm";		
	}
	
	
	@RequestMapping(value="/BoardWrite",method=RequestMethod.POST)
	public ModelAndView BoardWrite(@ModelAttribute BoardDTO dto,MultipartHttpServletRequest mtfRequest) throws IOException {
		mav=new ModelAndView();		
		mav=service.BoardWrite(dto,mtfRequest);
		return mav;
		
		
		
	}
	
	@RequestMapping(value="/BoardView",method=RequestMethod.GET)
	public ModelAndView BoardView(@RequestParam("bnum") int bnum) {
		mav=new ModelAndView();
		mav=service.BoardView(bnum);
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/BoardListForm",method=RequestMethod.GET)
	public String BoardListForm() {
		return "BoardList";		
	}
	
	@ResponseBody
	@RequestMapping(value="/BoardList",method=RequestMethod.GET)
	public Map<String,Object> BoardList(@RequestParam("page") int page,@RequestParam("search") String search,@RequestParam("select") String select) {
	
		 map=new HashMap<String,Object>();
		map=service.BoardList(page,search,select);
		return map;
	}
		
	
	
	
	
	@RequestMapping(value="/BoardUpdateForm",method=RequestMethod.GET)
	public ModelAndView BoardUpdateForm(@RequestParam("bnum") int bnum) {
		mav=new ModelAndView();
		mav=service.BoardUpdateForm(bnum);
		return mav;
	}
	
	
	@RequestMapping(value="/BoardUpdate",method=RequestMethod.POST)
	public ModelAndView BoardUpdate(@ModelAttribute BoardDTO dto,MultipartHttpServletRequest mtfRequest) throws IOException {
		mav=new ModelAndView();
		mav=service.BoardUpdate(dto,mtfRequest);
		return mav;
	}
	
	
	
	@RequestMapping(value="/BoardDelete",method=RequestMethod.GET)
	public ModelAndView BoardDelete(@RequestParam("bnum") int bnum) {
		mav=new ModelAndView();
		mav=service.BoardDelete(bnum);
		return mav;
	}

	@RequestMapping(value="/FileDownLoad",method=RequestMethod.GET)
	public void FileDownLoad(@RequestParam("files") String files,@RequestParam("filesRealName") String filesRealName,HttpServletRequest request, HttpServletResponse response) throws IOException {
		String savePath="C:\\Users\\6\\git\\repository\\MemberBoard\\src\\main\\webapp\\resources\\fileUpload\\"+files;
	    File downloadFile = new File(savePath); //그 경로 맞는 파일 객체 생성
	    FileInputStream inStream = new FileInputStream(downloadFile);  // 객체를 읽어들임
	    try {
			setDisposition(filesRealName,request,response);// 파일 다운로드시 한글 처리
		} catch (Exception e) {
			e.printStackTrace();
		}
	    OutputStream outStream = response.getOutputStream(); //객체를 쓰기함
	     
	    byte[] buffer = new byte[4096]; 
	    int bytesRead = -1;
	     
	    while ((bytesRead = inStream.read(buffer)) != -1) {
	        outStream.write(buffer, 0, bytesRead);
	    }
	    inStream.close();
	    outStream.close();
	}
	
	 private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
	        String browser = getBrowser(request); //현재 브라우저 리턴 받기
	        String dispositionPrefix = "attachment; filename="; // 값 초기화
	        String encodedFilename = null; //인코딩된 파일 이름
	        if (browser.equals("MSIE")) {
	               encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
	        } else if (browser.equals("Trident")) {       // IE11 문자열 깨짐 방지
	               encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
	        } else if (browser.equals("Firefox")) {
	               encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
	               encodedFilename = URLDecoder.decode(encodedFilename);
	        } else if (browser.equals("Opera")) {
	               encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
	        } else if (browser.equals("Chrome")) {
	               StringBuffer sb = new StringBuffer();
	               for (int i = 0; i < filename.length(); i++) {
	                      char c = filename.charAt(i);
	                      if (c > '~') {
	                            sb.append(URLEncoder.encode("" + c, "UTF-8"));
	                      } else {
	                            sb.append(c);
	                      }
	               }
	               encodedFilename = sb.toString();
	        } else if (browser.equals("Safari")){
	               encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1")+ "\"";
	               encodedFilename = URLDecoder.decode(encodedFilename);
	        }
	        else {
	               encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1")+ "\"";

	        }
	        response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
	        if ("Opera".equals(browser)){
	               response.setContentType("application/octet-stream;charset=UTF-8");
	        }
	}
	    
		public String getBrowser(HttpServletRequest request) {
	        String header = request.getHeader("User-Agent");
	   if (header.indexOf("MSIE") > -1) {
	       return "MSIE";
	   } else if (header.indexOf("Trident") > -1) {   // IE11 문자열 깨짐 방지
	       return "Trident";
	   } else if (header.indexOf("Chrome") > -1) {
	       return "Chrome";
	   } else if (header.indexOf("Opera") > -1) {
	       return "Opera";
	   } else if (header.indexOf("Safari") > -1) {
	       return "Safari";
	   }
	   return "Firefox";
	  }
	
		
		
		@RequestMapping(value="/Admin",method=RequestMethod.GET)
		public String Admin() {
			return "Admin";
		}	
		
		
		
}
