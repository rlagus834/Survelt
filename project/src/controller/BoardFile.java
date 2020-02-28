package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import service.BoardService;

/**
 * Servlet implementation class Board
 */
@WebServlet("/BoardFile")
public class BoardFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int size = 10 * 1024 * 1024; // 파일업로드할떄 파일크기제한주기위해서 현재작성한건 10메가라는뜻
//		String savePath="C:\\Users\\6\\git\\repository\\Servlet_20200210Board\\WebContent\\fileUpload";
		// ^ /모양으로 바꿔야함
		String savePath = "C://Users//6//git//repository//project//WebContent//fileUpload";
		// 저장할파일경로
		MultipartRequest multi = new MultipartRequest(request, // request임
				savePath, // 값저장한 savePath 변수
				size, // 업로드제한값 저장한 size변수
				"UTF-8", // 언어
				new DefaultFileRenamePolicy()// 파일중복방지
		);
		BoardDTO boardDTO = new BoardDTO();// 값저장할 클래스 객체선언

		boardDTO.setId(multi.getParameter("id")); // 작성자 multi쓴이유:보낼때 form에 enctype="multipart/form-data"추가되서 세팅
		boardDTO.setBoardtitle(multi.getParameter("boardTitle")); // 글제목
		boardDTO.setText(multi.getParameter("text"));// 글내용
//		System.out.println((String)multi.getFileNames().nextElement());
		boardDTO.setbFile(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));// 파일이름
		System.out.println(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		// 저장하기위한 공식같은것 파일이름이담긴 값을 불러들여 세팅할수있게 공식적으로 한것^
		BoardService boardWriteService = new BoardService();
		boolean result = boardWriteService.Boards(boardDTO);

		if (result) {
			response.sendRedirect("boardListPaging");
		} else {
			response.sendRedirect("fail.jsp");
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
