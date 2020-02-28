//package controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//import java.util.*;
//
//import dto.CommentDTO;
//import dto.MoviesDTO;
//import dto.UsersDTO;
//import service.CommentSelectService;
//import service.CommentUpdateSelectService;
//import service.CommentWriteService;
//import service.DeleteClientService;
//import service.MovieSearchService;
//
///**
// * Servlet implementation class JoinController
// */
//@WebServlet("/CommentUpdateSelect")
//public class CommentUpdateSelect extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		request.setCharacterEncoding("UTF-8");
//		CommentUpdateSelectService service=new CommentUpdateSelectService();
//		CommentDTO dto=new CommentDTO();
//		dto.setBnum(Integer.parseInt(request.getParameter("bnum")));
//		dto.setMnum(Integer.parseInt(request.getParameter("save")));
//service.CommentUpdateSelect(dto);
//
//	RequestDispatcher dispatcher = request.getRequestDispatcher("boardListPaging?mnum="+mnum);
//			dispatcher.forward(request, response);
//		
//
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doProcess(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doProcess(request, response);
//	}
//
//}
