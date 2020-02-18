package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.TestDTO;
import service.JoinService;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		JoinService service = new JoinService();
		TestDTO dto = new TestDTO();
		int size = 10 * 1024 * 1024;
		String savePath = "C://Users//6//git//repository//project//WebContent//fileUpload";
		MultipartRequest multi = new MultipartRequest(request, // request임
				savePath, // 값저장한 savePath 변수
				size, // 업로드제한값 저장한 size변수
				"UTF-8", // 언어
				new DefaultFileRenamePolicy()// 파일중복방지
		);
		dto.setId(multi.getParameter("id"));
		dto.setPassword(multi.getParameter("password"));
		dto.setName(multi.getParameter("name"));
		dto.setBirth(multi.getParameter("birth"));
		dto.setGender(multi.getParameter("gender"));
		dto.setEmail(multi.getParameter("email1")+"/"+multi.getParameter("email2"));
		dto.setAddress(multi.getParameter("address")+"/"+multi.getParameter("address1"));
		dto.setPhone(multi.getParameter("phone"));
		dto.setPhoto(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		boolean result = service.joinService(dto);
		if (result) {
			response.sendRedirect("Login.jsp");
		} else {
			response.sendRedirect("fail.jsp");

		}

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
