package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs3220.model.UserEntry;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String destination = "index.jsp";
		String errorMessage = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("<>");
		out.println("<html><head><title>Login</title>");
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">");
		out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\" crossorigin=\"anonymous\"></script>\n");
		out.println("<link href=\"./access/css/Styles.css\" rel=\"stylesheet\" type=\"text/css\">\n");
		out.println("</head><body>");
		out.println("<div class ='d-flex justify-content-center'>");
		out.println("<div class='card'>");
		out.println("<div class='card-body'>");
		out.println("<div class='col col-lg-2'>");
		out.println("<div>Hello Testing </div>");
		
		out.println("</div>");//div for card col
		out.println("</div>");//div for card body
		out.println("</div>");//div for card class
		out.println("<div>");//div for flex
		
		if (email != null && password != null) {
			List<UserEntry> users = (List<UserEntry>) getServletContext().getAttribute("users");
			for (UserEntry user : users) {
				if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
					HttpSession session = request.getSession(true);
					session.setAttribute("name", user.getName());
					request.setAttribute("name", user.getName());
					destination = "LoginSuccess.jsp";
					break;
				} else {
					continue;
				}
			}
			errorMessage = "Email and Password not match";
		} else {
			errorMessage = "User not found";
		}
		request.setAttribute("errorMessage", errorMessage);
		request.getRequestDispatcher(destination).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}





//====================================================================================================================================
//	create a forum tag
//	record the user's input for email and password and check the entry
//	you can pull this with request.getParameter(name='value')
//		if it does not exist reroute user to a different page telling them it doesn't exist
//		if it does redirect to login ==> via respond





//====================================================================================================================================
