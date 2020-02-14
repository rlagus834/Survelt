package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.TestDTO;
import service.LoginService;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	TestDTO dto=new TestDTO();
	dto.setId(id);
	dto.setPassword(password);
	LoginService service=new LoginService();
	boolean result=service.loginService(dto);
	if(result) {
		HttpSession session=request.getSession();
		session.setAttribute("id",dto.getId());
		session.setAttribute("photo",dto.getPhoto());


		RequestDispatcher dispatcher = request.getRequestDispatcher("Main.jsp");//페이지전환기능중 dispatch를 이용하여
		dispatcher.forward(request, response); //값을가지고 clientSelect.jsp로 페이지전환

	}else {
		request.setAttribute("fail","fail");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");//페이지전환기능중 dispatch를 이용하여
		dispatcher.forward(request, response); //값을가지고 clientSelect.jsp로 페이지전환

		
	}
	
	
	
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
