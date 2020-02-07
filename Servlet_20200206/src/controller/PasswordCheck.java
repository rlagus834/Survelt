package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.InputService;

/**
 * Servlet implementation class PasswordCheck
 */
@WebServlet("/PasswordCheck")
public class PasswordCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MemberDTO dto=new MemberDTO();
		String id,password;
		HttpSession session=request.getSession();
		id=(String)session.getAttribute("select");
		password=request.getParameter("password");
		dto.setId(id);
		dto.setPassword(password);
		InputService service=new InputService();
		boolean result=service.login(dto);
		if (result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("clientUpdate");
			dispatcher.forward(request, response);
		} else {
			
			response.sendRedirect("checkFail.jsp");
			
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
