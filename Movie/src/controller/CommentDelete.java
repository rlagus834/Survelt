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
import service.CommentDeleteService;

import java.util.*;

/**
 * Servlet implementation class boardListPaging
 */
@WebServlet("/CommentDelete")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		CommentDTO dto = new CommentDTO();
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		int mnum = Integer.parseInt(request.getParameter("mnum"));
		int page = Integer.parseInt(request.getParameter("page"));

		CommentDeleteService service = new CommentDeleteService();
		boolean result = service.CommentDelete(bnum);
		if (result) {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("boardListPaging?bnum=" + bnum + "&mnum=" + mnum + "&page=" + page);
		dispatcher.forward(request, response);
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
