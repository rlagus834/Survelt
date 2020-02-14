package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.UpdateTextSelectService;

import java.util.*;
/**
 * Servlet implementation class UpdateText
 */
@WebServlet("/UpdateTextSelect")
public class UpdateTextLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTextLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//int sum = Integer.parseInt(i); 형변환하는법 파라미터는 다 String 그러므로 int로쓸거면 형변환해줘야함
		int boardnumber=Integer.parseInt(request.getParameter("resultParam2"));
		System.out.println(boardnumber);
		UpdateTextSelectService service=new UpdateTextSelectService();		
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		list=service.UpdateText(boardnumber);
		request.setAttribute("select", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateTextSelect.jsp");
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
