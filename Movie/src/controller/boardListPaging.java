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
import java.util.*;

/**
 * Servlet implementation class boardListPaging
 */
@WebServlet("/boardListPaging")
public class boardListPaging extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public boardListPaging() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardListPagingService boardListPagingService = new BoardListPagingService();
		int page = 1; // 처음 시작할때 1페이지로 시작하니까 응용해서 쓰려고
		int limit = 3; // 보여줄 페이지당 글갯수
		// page파라미터값검사 왜 사용하나?어느페이지로 갈지 알기위해
		if (request.getParameter("page") != null) {// 클릭을 안해서 가져온값이 null이면 작동안하고 page는 1그대로 누르면 그 페이지순번값을 가져와서 대입
			page = Integer.parseInt(request.getParameter("page"));
		}

		
		// 전체글갯수를 가져오기위한 ListService 클래스 메소드호출 왜가져오나? 전체글갯수가 파악이되야 내가 나누고싶은 페이지당 글갯수대로
		// 나눠서 몇페이지만들어야하는지 연산해야해서
// limit값을 걸어놓은 만큼 범위에 해당하는 글만 가져오는 방법
		int startRow = (page - 1) * limit + 1; // 범위계산 startRow는 a~b 범위 일때 a endRow는b
		int endRow = page * limit;
		int listCount = 0;
		// 한페이지에 3개씩 보여줄때 1페이지에 보여줘야하는글번호(RN기준)
		// 시작글은 1번글 마지막글은 3번글
		String filters="베댓순";
		String search="";
		if (request.getParameter("filters") != null) {// 클릭을 안해서 가져온값이 null이면 작동안하고 page는 1그대로 누르면 그 페이지순번값을 가져와서 대입
			 filters = request.getParameter("filters");					
		}
		
		if (request.getParameter("search") != null) {// 클릭을 안해서 가져온값이 null이면 작동안하고 page는 1그대로 누르면 그 페이지순번값을 가져와서 대입
			 search = request.getParameter("search");			
		}
	
		 int mnum=Integer.parseInt(request.getParameter("mnum"));
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
			listCount = boardListPagingService.SelectCountService(search, filters,mnum);
			List<CommentDTO> boardList = boardListPagingService.boardListPagingServiceSearch(startRow, endRow, search,
					filters,mnum);// 범위에맞는
			// 데이터
			// list가져오기
			request.setAttribute("select", boardList);
		
//페이지 계산을 위한 부분
		// 최대로 필요한 페이지 갯수 계산
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
		request.setAttribute("paging", paging);
		request.setAttribute("filters", filters);
		request.setAttribute("search", search);
request.setAttribute("mnum", mnum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Comment.jsp");
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
