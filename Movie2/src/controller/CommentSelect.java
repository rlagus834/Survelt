package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.util.*;

import dto.CommentDTO;
import dto.MoviesDTO;
import dto.UsersDTO;
import service.CommentSelectService;
import service.DeleteClientService;
import service.MovieSearchService;
import service.SympathyService;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/CommentSelect")
public class CommentSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		int mnum = Integer.parseInt(request.getParameter("mnum"));
		int bnum=Integer.parseInt(request.getParameter("bnum"));
		CommentSelectService service = new CommentSelectService();
		List<CommentDTO> list = new ArrayList<CommentDTO>();
		list = service.CommentSelect(mnum);

		request.setAttribute("select", list);
		request.setAttribute("mnum", mnum);

		SympathyService SymService = new SympathyService();

		RequestDispatcher dispatcher = request.getRequestDispatcher("Comment.jsp");
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
