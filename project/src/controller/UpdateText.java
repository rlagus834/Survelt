package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.UpdateTextService;

/**
 * Servlet implementation class UpdateText
 */
@WebServlet("/UpdateText")
public class UpdateText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateText() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// int sum = Integer.parseInt(i); 형변환하는법 파라미터는 다 String 그러므로 int로쓸거면 형변환해줘야함
		String boardtitle, text, password;		
		int boardnumber=Integer.parseInt(request.getParameter("boardnumber"));
		System.out.println(boardnumber);
		boardtitle = request.getParameter("boardtitle");
		System.out.println(boardtitle);
		text = request.getParameter("text");
		System.out.println(text);
	
		BoardDTO dto=new BoardDTO();
		dto.setBoardnumber(boardnumber);
		dto.setBoardtitle(boardtitle);
		dto.setText(text);		
		UpdateTextService service = new UpdateTextService();
    boolean result=service.UpdateText(dto);
    if(result) {
    	response.sendRedirect("boardListPaging");
    }else {
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
