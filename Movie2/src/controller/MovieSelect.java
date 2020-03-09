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
import service.ScoreService;
import service.SympathyService;

import java.util.*;

/**
 * Servlet implementation class boardListPaging
 */
@WebServlet("/MovieSelect")
public class MovieSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieSelect() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MoviesDTO dto = new MoviesDTO();
		dto.setBoardtitle((String) request.getParameter("mname"));
		MovieSelectService service = new MovieSelectService();
		List<MoviesDTO> list = service.MovieSelect(dto);
		int mnum = dto.getBoardnumber();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		request.setAttribute("select", list);
		SympathyService SymService = new SympathyService();
		int Sympathy = SymService.SympathySelect(mnum);
		String chance = SymService.SympathyCheck(id,mnum);
		ScoreService ScoService = new ScoreService();
		int score = ScoService.ScoreService(mnum);
		if (chance == null) {
			chance = "no";
		} else {
			chance = "yes";
		}
		request.setAttribute("Sympathy", Sympathy);
		request.setAttribute("mname", dto.getBoardtitle());
		request.setAttribute("mnum", dto.getBoardnumber());
		request.setAttribute("Chance", chance);
		request.setAttribute("score", score);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Movie.jsp");
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
