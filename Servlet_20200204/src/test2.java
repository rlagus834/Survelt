import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.InputService;

/**
 * Servlet implementation class test2
 */
@WebServlet("/selectDB") //해당주소로 오려는걸 받음 받는표시는/주소
public class test2 extends HttpServlet {
	private static final long serialVersionUID = 1L; //노란색으로 warring오류안보이게끔한것

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public test2() {
		super();//HttpServlet에있는 값을 상속받음s
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {//throw란? 여기서 발생한 예외들을 이 메소드를 사용하는곳에 책임전가 하는 예외던지기기능
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
//	response.sendRedirect("SelectResult.jsp");
		/*
		 * 처리과정 서비스 클래스의 selectDB 메소드호출> DB접속>DAO의selectDB메소드호출> DAO의 selectDB 메소드는
		 * DB의TEST테이블의 모든 내용 조회> 조회 내용을 서비스 클래스로 리턴> 서비스 클래스는 컨트롤러로 조회 내용을 리턴> 컨트롤러에서
		 * SelectResult.jsp로 데이터를 가지고 이동
		 */
		InputService service = new InputService();//service안에있는 메소드를 사용하기위해 서비스 객체생성
		List<String> list=new ArrayList<String>(); 
		list=service.selectDB(); //service의selectDB메소드를 불러온후 리턴된값을 list에 대입
request.setAttribute("select", list);   
RequestDispatcher dispatcher=    //값을 가져가지못하는redirect 대신 dispatch을 이용하여 값을 가져가기 위해 사용
request.getRequestDispatcher("select.jsp");
dispatcher.forward(request, response); //select.jsp에 requset,response의 값을 보낸다 

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
