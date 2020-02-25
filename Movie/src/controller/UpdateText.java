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

import dto.MoviesDTO;
import service.UpdateTextService;

/**
 * Servlet implementation class UpdateText
 */
@WebServlet("/UpdateText")
public class UpdateText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateText() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int size = 10 * 1024 * 1024; // 파일업로드할떄 파일크기제한주기위해서 현재작성한건 10메가라는뜻
//		String savePath="C:\\Users\\6\\git\\repository\\Servlet_20200210Board\\WebContent\\fileUpload";
		// ^ /모양으로 바꿔야함C:\Users\6\git\repository\project\WebContent\fileUpload
		String savePath = "C://Users//6//git//repository//project//WebContent//fileUpload";

		// int sum = Integer.parseInt(i); 형변환하는법 파라미터는 다 String 그러므로 int로쓸거면 형변환해줘야함
		MultipartRequest multi = new MultipartRequest(request, // request임
				savePath, // 값저장한 savePath 변수
				size, // 업로드제한값 저장한 size변수
				"UTF-8", // 언어
				new DefaultFileRenamePolicy()// 파일중복방지
		);
		MoviesDTO boardDTO = new MoviesDTO();// 값저장할 클래스 객체선언
		boardDTO.setBoardnumber(Integer.parseInt(multi.getParameter("boardnumber")));
		boardDTO.setBoardtitle(multi.getParameter("boardtitle")); // 글제목
		boardDTO.setText(multi.getParameter("text"));// 글내용
		boardDTO.setbFile(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));// 파일이름
		UpdateTextService service = new UpdateTextService();
		boolean result = service.UpdateText(boardDTO);
		
		if (result) {
			response.sendRedirect("boardListPaging");
		} else {
			response.sendRedirect("boardListPaging");

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
