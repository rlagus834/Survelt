package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UsersDTO;
import service.JoinService;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		JoinService service = new JoinService();
		UsersDTO dto = new UsersDTO();
	
		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setBirth(request.getParameter("birth"));
		dto.setGender(request.getParameter("gender"));
		dto.setEmail(request.getParameter("email1")+"/"+request.getParameter("email2"));
		dto.setAddress(request.getParameter("address")+"/"+request.getParameter("address1"));
		dto.setPhone(request.getParameter("phone"));
		dto.setAcnum(request.getParameter("acnum"));
		boolean result = service.joinService(dto);
		if (result) {
			response.sendRedirect("Login.jsp");
		} else {
			response.sendRedirect("fail.jsp");

		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
