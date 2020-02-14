package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import dto.PageDTO;
import dto.TestDTO;
import service.ClientSelectService;
import service.LoginService;

/**
 * Servlet implementation class login
 */
@WebServlet("/SelectClient")
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
	
	int maxPage=(int)((double)listCount/limit+0.9);
	//현재 페이지에 보여줄 시작 페이지 번호(1,11,21,31~~)
	int startPage=(((int)((double)page/10+0.9))-1)*10+1;
	int endPage=startPage+10-1;
	
	if(endPage>maxPage) {  //글페이지가 7개정도만있어서 10이상 필요없을때
		endPage=maxPage;
	}
	List<TestDTO> list=new ArrayList<TestDTO>();
	list=service.ClientSelectService(startRow,endRow);
	
	PageDTO paging=new PageDTO();
	paging.setPage(page);
paging.setStartPage(startPage);
paging.setEndPage(endPage);
paging.setMaxPage(maxPage);
paging.setListCount(listCount);
request.setAttribute("paging", paging);
request.setAttribute("select", list);
RequestDispatcher dispatcher = request.getRequestDispatcher("MemberSelectboard.jsp");
dispatcher.forward(request, response);

	
	
	
	
	
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
