package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.PageDTO;

import service.BoardListPagingService;
import service.MemberWritingSelectService;

import java.util.*;

/**
 * Servlet implementation class MemberWritingSelect
 */
@WebServlet("/CheckId")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckId() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		MemberWritingSelectService service = new MemberWritingSelectService();
		String id = request.getParameter("id");
		if(null!=service.MemberWritingSelect(id)) {
request.setAttribute("result", "중복");
			RequestDispatcher dispatcher = request.getRequestDispatcher("CheckId.jsp");
			dispatcher.forward(request, response);       	
        }else {
        	request.setAttribute("result", null);        	
    		RequestDispatcher dispatcher = request.getRequestDispatcher("CheckId.jsp");
    		dispatcher.forward(request, response);
        	
        }
		
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
