package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class infoUpdate
 */
@WebServlet("/infoUpdate")
public class infoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO dto = new MemberDTO();
		String id,password, name, gender, email;
		id=request.getParameter("id");
		System.out.println(id);
		password = request.getParameter("password");
		System.out.println(password);
		
		name = request.getParameter("name");		
		System.out.println(name);
		
		email = request.getParameter("email");
		System.out.println(email);
		
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setEmail(email);
InputService service=new InputService();
boolean result=service.update(dto);
if (result) {
	RequestDispatcher dispatcher = request.getRequestDispatcher("MemberMain.jsp");
	dispatcher.forward(request, response);
} else {
	response.sendRedirect("updateFail.jsp");
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
