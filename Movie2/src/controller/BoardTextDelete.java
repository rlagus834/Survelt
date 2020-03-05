package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardTextDeleteService;

/**
 * Servlet implementation class BoardTextDelete
 */
@WebServlet("/BoardTextDelete")
public class BoardTextDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardTextDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	int boardnumber=Integer.parseInt(request.getParameter("mnum"));
	BoardTextDeleteService service=new BoardTextDeleteService();
	boolean result=service.BoardTextDelete(boardnumber);
	if(result) {
		response.sendRedirect("MovieSelect.jsp");
		
	}else {
		response.sendRedirect("fail.jsp");
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
