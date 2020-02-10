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
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		boolean result=true;

InputService survice=new InputService();

String id,password,name,birth,gender,address1,address2,address3,address4,address5,
email1,email2,email3,phone;
id=request.getParameter("id");
password=request.getParameter("password");
name=request.getParameter("name");
birth=request.getParameter("birth");
gender=request.getParameter("gender");
address1=request.getParameter("address1");
address2=request.getParameter("address2");
address3=request.getParameter("address3");
address4=request.getParameter("address4");
address5=address1+address2+address3+address4;
email1=request.getParameter("email1");
email2=request.getParameter("email2");
email3=email1+email2;

phone=request.getParameter("phone");
MemberDTO member=new MemberDTO();

member.setId(id);
member.setPassword(password);
member.setName(name);
member.setBirth(birth);
member.setGender(gender);
member.setAddress(address5);
member.setEmail(email3);
member.setPhone(phone);

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
