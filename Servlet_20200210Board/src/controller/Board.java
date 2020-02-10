package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;

/**
 * Servlet implementation class Board
 */
@WebServlet("/board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		BoardService service=new BoardService();
		BoardDTO dto=new BoardDTO();
		String boardTitle,id,text,password;
		boardTitle=request.getParameter("boardTitle");
		System.out.println(boardTitle);
		dto.setBoardtitle(boardTitle);
		id=request.getParameter("id");
		dto.setId(id);
		text=request.getParameter("text");
		System.out.println(text);
		dto.setText(text);
		password=request.getParameter("password");
		System.out.println(password);
		dto.setPassword(password);
		boolean result=service.Board(dto);
		if(result) {
			response.sendRedirect("UpdateSelect");			
		}else {
			response.sendRedirect("BoardWriteFail.jsp");
		}
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
