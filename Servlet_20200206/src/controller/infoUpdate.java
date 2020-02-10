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
		String id,password, address1="",address2="",address3="",address4="",
				address5, email,phone;
		id=request.getParameter("id");
		System.out.println(id);
		password = request.getParameter("password");
		phone=request.getParameter("phone");
		address1=request.getParameter("address1");
		address2=request.getParameter("address2");
		address3=request.getParameter("address3");
		address4=request.getParameter("address4");
		address5=address1+address2+address3+address4;
		email = request.getParameter("email");			
		dto.setAddress(address5);
		dto.setPhone(phone);
		dto.setId(id);
		dto.setPassword(password);
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
