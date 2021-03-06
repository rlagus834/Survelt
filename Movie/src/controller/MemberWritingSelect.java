package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MoviesDTO;
import dto.PageDTO;

import service.BoardListPagingService;
import service.MemberWritingSelectService;

import java.util.*;

/**
 * Servlet implementation class MemberWritingSelect
 */
@WebServlet("/MemberWritingSelect")
public class MemberWritingSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberWritingSelect() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MemberWritingSelectService service = new MemberWritingSelectService();

		String id = request.getParameter("resultParam");

		BoardListPagingService boardListPagingService = new BoardListPagingService();
		int page = 1; // 처음 시작할때 1페이지로 시작하니까 응용해서 쓰려고
		int limit = 3; // 보여줄 페이지당 글갯수
		// page파라미터값검사 왜 사용하나?어느페이지로 갈지 알기위해
		if (request.getParameter("page") != null) {// 클릭을 안해서 가져온값이 null이면 작동안하고 page는 1그대로 누르면 그 페이지순번값을 가져와서 대입
			page = Integer.parseInt(request.getParameter("page"));
		}

// limit값을 걸어놓은 만큼 범위에 해당하는 글만 가져오는 방법
		int startRow = (page - 1) * limit + 1; // 범위계산 startRow는 a~b 범위 일때 a endRow는b
		int endRow = page * limit;

		// 전체글갯수를 가져오기위한 ListService 클래스 메소드호출 왜가져오나? 전체글갯수가 파악이되야 내가 나누고싶은 페이지당 글갯수대로
		// 나눠서 몇페이지만들어야하는지 연산해야해서
		int listCount = boardListPagingService.MemberboardListPagingService(id);

		int maxPage = (int) ((double) listCount / limit + 0.9);
		// 현재 페이지에 보여줄 시작 페이지 번호(1,11,21,31~~)
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage) { // 글페이지가 7개정도만있어서 10이상 필요없을때
			endPage = maxPage;
		}

		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setListCount(listCount);

		List<MoviesDTO> list = boardListPagingService.MemberWritingSelectId(startRow, endRow, id);// 범위에맞는 데이터 list가져오기
		request.setAttribute("id", id);

		request.setAttribute("select", list);
		request.setAttribute("paging", paging);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Main.jsp");
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
