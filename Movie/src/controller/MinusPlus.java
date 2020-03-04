package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CommentDTO;
import dto.MoviesDTO;
import dto.PageDTO;
import service.BoardListPagingService;
import service.GoodService;
import service.MovieSelectService;
import service.SympathyService;

import java.util.*;

/**
 * Servlet implementation class boardListPaging
 */
@WebServlet("/MinusPlus")
public class MinusPlus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MinusPlus() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		CommentDTO dto = new CommentDTO();
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int mnum = Integer.parseInt(request.getParameter("mnum"));
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println(bnum + "댓글번호");
		System.out.println(id + "해당아이디");

		GoodService service = new GoodService();

		boolean result = service.MinusSelect(bnum, id);
		if (result) {
			service.MinusMinus(id, bnum);
		} else {
			service.MinusPlus(id, bnum);
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("boardListPaging?bnum=" + bnum + "&mnum=" + mnum + "&page=" + page);
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
