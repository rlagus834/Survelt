package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	public FileDownload() {
		super();
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // reads input file from an absolute path
	String filename=request.getParameter("bfile");//다운받을 파일의 특정이름	
    String filePath = "C://Users//6//git//repository//project//WebContent//fileUpload/"+filename; //다운경로+다운받을파일이름
    File downloadFile = new File(filePath);   //다운경로+다운받을파일이름 file타입의 객체에 셋팅하면서 객체 선언
    FileInputStream inStream = new FileInputStream(downloadFile);//FileInputStream=상대적으로 제각기 다른 파일경로를 인식할수있게 해석해서 읽어오는기능
     
    // if you want to use a relative path to context root:
    String relativePath = getServletContext().getRealPath("");
    
    // obtains ServletContext
    ServletContext context = getServletContext();//
     
    // gets MIME type of the file
    String mimeType = context.getMimeType(filePath);  // 기계어로  
    if (mimeType == null) {        
        // set to binary type if MIME mapping not found
        mimeType = "application/octet-stream";  // 없으면 컴퓨터에 기록하게하기위해
;    }
     
    // modifies response
    response.setContentType(mimeType); //mimeType으로 응답
    response.setContentLength((int) downloadFile.length()); //
     
    // forces download
    String headerKey = "Content-Disposition";
    String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
    response.setHeader(headerKey, headerValue);
     
    // obtains response's output stream
    OutputStream outStream = response.getOutputStream();
     
    byte[] buffer = new byte[4096];
    int bytesRead = -1;
     
    while ((bytesRead = inStream.read(buffer)) != -1) {
        outStream.write(buffer, 0, bytesRead);
    }
     
    inStream.close();
    outStream.close();     
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}