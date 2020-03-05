package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import dto.MoviesDTO;
import dto.PageDTO;
import dto.UsersDTO;
import service.ClientSelectService;
import service.LoginService;
import service.MovieSearchService;

/**
 * Servlet implementation class login
 */
@WebServlet("/SelectMovie")
public class SelectMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectMovie() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		MovieSearchService service = new MovieSearchService();
		String search=request.getParameter("search");
				
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		list = service.MovieList(search);
		request.setAttribute("select", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MovieSelect.jsp");
		dispatcher.forward(request, response);

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
