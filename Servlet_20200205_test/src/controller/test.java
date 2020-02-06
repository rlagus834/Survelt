package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.InputService; //service 다른 패키지에 있어서 import

/**
 * Servlet implementation class test1
 */
@WebServlet("/inputs")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;// 노란warring안뜨게

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		boolean result = true;// boolean 변수 하나만듬 (리턴받는것을 대입하기위해
		String var1 = request.getParameter("na1");// na1의 매개변수에 대입하기위해
		InputService service = new InputService();// service의메소드를사용하기위해 대입
		result = service.insert(var1);
		if (result) {
			response.sendRedirect("suuggong.jsp");
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
