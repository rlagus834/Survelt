package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDTO;

import java.util.*;

import service.InputService;

/**
 * Servlet implementation class test3
 */
@WebServlet("/login")
public class test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test3() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		boolean ss=true;

InputService survice=new InputService();

String id,password,name,birth,gender,email;
id=request.getParameter("id");
password=request.getParameter("password");
name=request.getParameter("name");
birth=request.getParameter("birth");
gender=request.getParameter("gender");
email=request.getParameter("email");

memberDTO member=new memberDTO();

member.setId(id);
member.setPassword(password);
member.setName(name);
member.setBirth(birth);
member.setGender(gender);
member.setEmail(email);

survice.inserts(member);

if (ss) {
	response.sendRedirect("select2.jsp");
} else {
	response.sendRedirect("fail.jsp");
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
