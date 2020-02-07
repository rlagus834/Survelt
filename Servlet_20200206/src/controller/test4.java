package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;

import java.util.*;
import service.InputService;

/**
 * Servlet implementation class test4
 */
@WebServlet("/clientSelect")
public class test4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test4() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("resultParam");
	InputService service=new InputService();
	List<MemberDTO> list=new ArrayList<MemberDTO>();
 list=service.clientSelect(id);
 if(list!=null) {
 request.setAttribute("select", list); //jsp에서이용할 매개변수생성및세팅
	RequestDispatcher dispatcher = request.getRequestDispatcher("clientSelect.jsp");//페이지전환기능중 dispatch를 이용하여
	dispatcher.forward(request, response); //값을가지고 clientSelect.jsp로 페이지전환
 }else {
	 response.sendRedirect("selectFail");
 }

	}
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
