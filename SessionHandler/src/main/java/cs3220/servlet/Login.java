package cs3220.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
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
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	List<UserEntry> users = new ArrayList<UserEntry>();
    	users.add(new UserEntry("john@gmail.com", "John", "test123"));
    	users.add(new UserEntry("jane@gmail.com", "Jane", "test456"));
    	
    	getServletContext().setAttribute("users", users);
    	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String destination = "index.jsp";
		String errorMessage = null;
		
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