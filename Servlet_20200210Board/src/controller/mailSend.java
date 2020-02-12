package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.*;

/**
 * Servlet implementation class mailSend
 */
@WebServlet("/mailSend")
public class mailSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailSend() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	String sender = request.getParameter("sender");  //보내는사람
	String receiver = request.getParameter("receiver"); //받는사람
	String subject = request.getParameter("title"); //제목
	String content = request.getParameter("contents"); //내용
	
	try {
		Properties properties = System.getProperties();//Properties타입의 객체선언
		properties.put("mail.smtp.starttls.enable","true");  //서버주소포트내용을 put으로 넣음
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.port","587");
		Authenticator auth = new GoogleAuthentication(); //Authenticator(인증자)타입의 객체선언해서 그안에 인증할정보가 담긴 메소드를 넣음
		Session s = Session.getDefaultInstance(properties, auth); //세션타입 s에 기본객체를
	
		Message message = new MimeMessage(s); //메일보내기관련메소드
		Address sender_address = new InternetAddress(sender); //발신  
		Address receiver_address = new InternetAddress(receiver); //수신
		message.setHeader("content-type", "text/html;charset=UTF-8"); //한글깨짐방지
		message.setFrom(sender_address);//발신자가 담긴 Address타입 객체 셋팅
		message.addRecipient(Message.RecipientType.TO, 
							receiver_address);//Recipient(받는사람)Type.TO,받는사람데이터가담긴 Address타입 객체
		message.setSubject(subject);//제목세팅
		message.setContent(content, "text/html;charset=UTF-8");//한글깨짐방지
		message.setSentDate(new java.util.Date());//보내는날짜세팅
		Transport.send(message); //보내기
		System.out.println("메일발송 성공");
		
		

	}catch (Exception e) {
		System.out.println("메일발송 실패");
		e.printStackTrace();
	}



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
