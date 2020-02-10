package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import dto.BoardDTO;
import service.MemberWritingSelectService;


/**
 * Servlet implementation class Board
 */
@WebServlet("/writeOpen")
public class writeOpen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public writeOpen() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MemberWritingSelectService service = new MemberWritingSelectService();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String id = request.getParameter("resultParam");
		list=service.MemberWritingSelect(id);
		request.setAttribute("select", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WriteOpen.jsp");
		dispatcher.forward(request, response);

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
