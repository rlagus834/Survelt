package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;

import java.util.*;

import service.InputService;

/**
 * Servlet implementation class test3
 */
@WebServlet("/join")
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test1() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		boolean result=true;

InputService survice=new InputService();

String id,password,name,birth,gender,email;
id=request.getParameter("id");
password=request.getParameter("password");
name=request.getParameter("name");
birth=request.getParameter("birth");
gender=request.getParameter("gender");
email=request.getParameter("email");

MemberDTO member=new MemberDTO();

member.setId(id);
member.setPassword(password);
member.setName(name);
member.setBirth(birth);
member.setGender(gender);
member.setEmail(email);

result=survice.inserts(member);

if (result) {
	response.sendRedirect("Login.jsp");
} else {
	response.sendRedirect("Login.jsp");
	
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
