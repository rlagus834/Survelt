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

@WebServlet("/memberList")// memberList주소값 받기 받을떈/
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;//노란warring오류안뜨게

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberList() {
		super(); //HttpServlet의 기능,값들을 상속받기
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글 깨짐방지
		InputService service = new InputService(); //service안 메소드 이용하기위해 객체선언
		List<MemberDTO> list = new ArrayList<MemberDTO>();//select라 리턴으로 List를 받을꺼라 list(List) 생성
		list = service.adminSelect();//service.adminSelect()메소드호출
		request.setAttribute("select", list); //jsp에서이용할 매개변수생성및세팅
		RequestDispatcher dispatcher = request.getRequestDispatcher("select.jsp");//페이지전환기능중 dispatch를 이용하여
		dispatcher.forward(request, response); //값을가지고 select.jsp로 페이지전환

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
