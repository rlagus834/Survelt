package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.PageDTO;
import dto.TestDTO;
import service.ClientSelectService;
import service.LoginService;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class SelectClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	PageDTO pto=new PageDTO();
int page=1;//현재 페이지 저장할공간 왜1을 줬느냐 초기값이 1이라서
	int limit=3; //내가 페이지당 배치할 작성글수제한
	if(request.getParameter("page")!=null) {
		page=Integer.parseInt(request.getParameter("page"));
	}
	
	ClientSelectService service=new ClientSelectService();
	int listCount=service.CountService(); //전체회원수
	int startRow=(page-1) *limit+1;  //범위계산  startRow는 a~b 범위 일때 a  endRow는b
	int endRow=page*limit;
	
	
	
	
	
	
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
