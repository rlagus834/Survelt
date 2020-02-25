package controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.util.*;

import dto.MoviesDTO;
import service.BoardService;

/**
 * Servlet implementation class Board
 */
@WebServlet("/BoardFile")
public class BoardFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String savePath = "C://Users//6//git//repository//project//WebContent//fileUpload";

	    int size=10*1024*1024;
		MultipartRequest multiRequest = new MultipartRequest(
				request,savePath,size,"UTF-8",new DefaultFileRenamePolicy()
				);
		String fileName = "";
        File file = null;
        Enumeration efiles = multiRequest.getFileNames();
            while(efiles.hasMoreElements()){
                String name = (String)efiles.nextElement(); 
                file = multiRequest.getFile(name);
                if(file==null) {
                	
                }
                else {
                    String str = file.getName();
                    fileName += "&fileName"+str;  
                } 
        } 
	
		BoardService service=new BoardService();
		MoviesDTO dto=new MoviesDTO();
		dto.setbFile(fileName);
		dto.setPrice(Integer.parseInt(multiRequest.getParameter("price")));
		dto.setBoardtitle((String)multiRequest.getParameter("mname"));
		dto.setText(multiRequest.getParameter("text"));
		boolean result=service.Boards(dto);
		
		if (result) {
			response.sendRedirect("boardListPaging");
		} else {
			response.sendRedirect("fail.jsp");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
