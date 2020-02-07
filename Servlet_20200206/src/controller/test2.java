package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.InputService;


@WebServlet("/login")
public class test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test2() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
MemberDTO dto=new MemberDTO();
String id,password;
id=request.getParameter("id");
password=request.getParameter("password");

dto.setId(id);
dto.setPassword(password);
InputService service=new InputService();
boolean result=service.login(dto);
if (result) {
	HttpSession session=request.getSession();
	session.setAttribute("select",dto.getId());
	RequestDispatcher dispatcher = request.getRequestDispatcher("MemberMain.jsp");
	dispatcher.forward(request, response);


} else {
	response.sendRedirect("LoginFail.jsp");
	
}

    }




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
