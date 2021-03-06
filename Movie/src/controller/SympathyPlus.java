package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MoviesDTO;
import dto.PageDTO;
import service.BoardListPagingService;
import service.MovieSelectService;
import service.SympathyService;

import java.util.*;

/**
 * Servlet implementation class boardListPaging
 */
@WebServlet("/SympathyPlus")
public class SympathyPlus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SympathyPlus() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MoviesDTO dto = new MoviesDTO();
		dto.setBoardnumber(Integer.parseInt(request.getParameter("mnum")));
		String mname=request.getParameter("mname");		
		HttpSession session = request.getSession();
		dto.setId((String) session.getAttribute("id"));
		SympathyService service = new SympathyService();
		service.SympathyPlus(dto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieSelect?mname"+mname);
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
