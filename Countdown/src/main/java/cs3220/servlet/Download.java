package cs3220.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		File file = new File("/User/john/Downloads/");
		FileInputStream in = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();
		response.setHeader("Content-Length", "" + file.length());
		response.setContentType("image/jpg");
		response.setHeader("Content-Disposition", "inline; filename=cs3220.jpg");
		//response.setHeader("Content-Disposition", "attachment; filename=cs3220.jpg");
		byte[] buffer = new byte[2048];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) > 0) {
			out.write(buffer, 0 ,bytesRead);
		}
		in.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
