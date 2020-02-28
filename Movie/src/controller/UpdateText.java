package controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.MoviesDTO;
import service.BoardService;
import service.UpdateTextService;

/**
 * Servlet implementation class UpdateText
 */
@WebServlet("/UpdateText")
public class UpdateText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateText() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String savePath = "C://Users//6//git//repository//Movie//WebContent//fileUpload";
		int size = 10 * 1024 * 1024;
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, size, "UTF-8",
				new DefaultFileRenamePolicy());
		String fileName = "";
		File file = null;

		Enumeration efiles = multiRequest.getFileNames();
		while (efiles.hasMoreElements()) {
			String name = (String) efiles.nextElement();
			System.out.println(name);
			file =multiRequest.getFile(name);
		fileName+=file.getName();
		if(fileName!=null) {
			fileName+="&";
			System.out.println(fileName);
		}else {
			
		}
		
		}
		UpdateTextService service = new UpdateTextService();
		MoviesDTO dto = new MoviesDTO();
		dto.setbFile(fileName);
		dto.setPrice(Integer.parseInt(multiRequest.getParameter("price")));
		dto.setBoardtitle((String) multiRequest.getParameter("mname"));
		dto.setText(multiRequest.getParameter("text"));
		dto.setBoardnumber(Integer.parseInt(multiRequest.getParameter("mnum")));
		dto.setPhoto(fileName);

		boolean result = service.UpdateText(dto);

		if (result) {
			response.sendRedirect("search.jsp");
		} else {
			response.sendRedirect("fail.jsp");
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
