

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.InputService;

/**
 * Servlet implementation class test
 */
@WebServlet("/inputs")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L; //warring노란색오류 안뜨게 하는것
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super(); //HttpServlet의 값들을 상속받음 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); //한글깨짐방지
		String var1=request.getParameter("data1"); //input으로 연결된 jsp에있는 data 매개변수를
		String var2=request.getParameter("data2");//요청해서 값을 가져와 val에 대입
		System.out.println(var1);
		System.out.println(var2);
		//redirect방식
//		response.sendRedirect("RedirectResult.jsp"); 		
//dispatch방식
//		RequestDispatcher dispatcher=
//				request.getRequestDispatcher("DispatchResult.jsp");
//		dispatcher.forward(request, response); //떠넘김 forward?
//		
		//페이지전환방식
//		1.redirect
//		-지정된 페이지로 이동하지만 값을가지고 갈수는없음
//		-주소값이 지정된 페이지 또는 파일 명으로 바뀜
//      쓰는법
//		response.sendRedirect("전환할 페이지주소");
//		2.dispatch
//		-지정된 페이지로 이동하면서 값을가지고 갈수있음
//		-주소값이 바뀌지않음
//		쓰는법
//		RequestDispatcher 변수명=request.getRequestDispatcher("전환할 페이지주소")
//		dispatcher.forward(request, response); 위(doProcess메소드 매개변수)에서 받아온것
		
		
		/*
		 * 영역객체(Scope)와 속성(Attribute)
		 * 영역객체 종류 : page, request, session, application
		 * 
		 * 1. page : 해당 페이지가 유지되어 있는 동안에만 유효함.
		 *           페이지가 바뀌면 사라짐.
		 * 
		 * 2. request : 클라이언트의 요청이 처리되는 동안에 유효.
		 *              포워딩을 수행해도 유지가 되기 때문에 request영역에
		 *              데이터를 저장하면 다양하게 활용할수있음
		 *
		 * 3. session : 웹브라우저가 실행되고 있는 동안에 유효. @예:로그인계속유지
		 *              웹 브라우저를 닫기 전까지는 session영역에 담겨있는
		 *              데이터는 사라지지않고 계속 유지할 수 있음.
		 *              웹사이트에서 로그인 했을 떄 로그인 정보를 보통 session 영역에 담음.
		 *            @session만쓰면 계속유지되서 로딩속도가 느려짐 그래서 꼭계속유지해야하는것만 ㄱㄱ
		 * 4. application : 서버가 구동되고 있는 동안에 유효
 		 *                  서버를 올리고 나서 내리기 전까지는 
 		 *                  application 영역에 담은 데이터는 계속 유지됨.
		 */
//		request.setAttribute("reqData1","파라미터에 저장되는값");
//		request.setAttribute("reqData2","미터에 저장되는값");
//		request.setAttribute("reqData3",var1);
//		
//		//session 객체생성
//		//쓰는법
//		//HttpSession 객체명=request.getSession(); 객체생성후
//		//객체명.setAttribut("변수명지정",데이터); 하면 웹브라우저를 닫기 전까지는 session의변수로 유효하게쓸수있음 
//		//@데이터를 못받는redirect에서도 유효하게 쓸수있음
//		HttpSession session=request.getSession();
//		session.setAttribute("seData1", "sdsds");
//		session.setAttribute("seData2", "sds");
//		session.setAttribute("seData3", var2);
//		response.sendRedirect("DispatchResult.jsp");
//		RequestDispatcher dispatcher=
//				request.getRequestDispatcher("DispatchResult.jsp");
//		dispatcher.forward(request, response);

//		DB에 data1, data2저장하기
//		저장하는 과정:InputDB.jsp > InputController>InputService>DAO>DB의테이블
	InputService inputService=new InputService(); //다른패키지에 있으므로 import해야함
                                                  //inputService 객체생성	                   
	
	//inputService 클래스에 inputDB 메소드를 정의해서 data1, data2를 넘긴후
	//리턴 결과를 boolean 타입의 inputResult 변수에 담으세요
	
	//inputService의 inputDB메소드를 var들의 데이터를 매개변수로 주고  호출
	boolean inputResult=inputService.inputDB(var1,var2);
	
	if(inputResult) {
	response.sendRedirect("RedirectResult.jsp");
	}else {
		response.sendRedirect("Dispatch.jsp");
	}
		/*DB 연동하기
 * 1.ojdbc6.jar 파일을 톰캣 설치 폴더의 lib폴더에 복사하세요.
 * 2. DB계정생성 
 * 3.META-INF 폴더에 context.xml파일생성
 * 4.JdbcUtil 클래스 생성 및 내용 작성
 * 5. Service, DAO클래스 생성
 * -Service 클래스:controller에서 넘겨받은 내용에 대한 처리및
 *  DB연동을위한 DAO 클래스호출
 * -DAO 클래스:DB와 CRUD 작업을 수행 c
 */
	
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
