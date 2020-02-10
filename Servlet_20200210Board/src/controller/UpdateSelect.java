package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import dto.BoardDTO;
import service.UpdateSelectService;

/**
 * Servlet implementation class Board
 */
@WebServlet("/UpdateSelect")
public class UpdateSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");		
		UpdateSelectService service=new UpdateSelectService();
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		list=service.UpdateSelectService();
		request.setAttribute("select", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("NoticeBoard.jsp");
		dispatcher.forward(request, response);

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
