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
import service.writeOpens;



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
        writeOpens service = new writeOpens();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String id = request.getParameter("resultParam");
		int paging=Integer.parseInt(request.getParameter("page"));
		int boardnumber=Integer.parseInt(request.getParameter("boardnumber"));
		list=service.writeOpenService(id,boardnumber);
		request.setAttribute("select", list);
		request.setAttribute("paging", paging);
		RequestDispatcher dispatcher = request.getRequestDispatcher("writeOpen.jsp");
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
