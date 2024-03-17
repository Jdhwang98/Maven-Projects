package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs3220.model.UserEntry;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String name = request.getParameter("name");
		String errorMessage = null;
		String destination = "index.jsp";
		
		if (email.isEmpty() || name.isEmpty() || password.isEmpty()) {
			errorMessage = "All fields are required!";
		}
		
		if (errorMessage != null) {
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("Register.jsp").forward(request,response);
		}
		else {
			List<UserEntry> users = (List<UserEntry>) getServletContext().getAttribute("users");
			if (users == null) {
				users = new ArrayList<>();
				getServletContext().setAttribute("users", users);
			}
			users.add(new UserEntry(email,name,password));
			request.getRequestDispatcher(destination).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}
}
