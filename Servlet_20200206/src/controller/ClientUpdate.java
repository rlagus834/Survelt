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

import java.util.*;

/**
 * Servlet implementation class test5
 */
@WebServlet("/clientUpdate")
public class ClientUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
List<MemberDTO> list=new ArrayList<MemberDTO>();
		MemberDTO dto=new MemberDTO();
InputService service=new InputService();
HttpSession session=request.getSession();
String id=(String)session.getAttribute("select");
dto.setId(id);
list=service.clientSelect(id);
	 if(list!=null) {
		 request.setAttribute("select", list); //jsp에서이용할 매개변수생성및세팅
			RequestDispatcher dispatcher = request.getRequestDispatcher("clientUpdate.jsp");//페이지전환기능중 dispatch를 이용하여
			dispatcher.forward(request, response); //값을가지고 clientSelect.jsp로 페이지전환
		 }else {
			 response.sendRedirect("selectfail.jsp");
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
