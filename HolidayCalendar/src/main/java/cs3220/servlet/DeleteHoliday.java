package cs3220.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.HolidayCalendarEntry;

/**
 * Servlet implementation class DeleteHoliday
 */
@WebServlet("/DeleteHoliday")
public class DeleteHoliday extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHoliday() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<HolidayCalendarEntry> entries = (List<HolidayCalendarEntry>) getServletContext().getAttribute("entries");
		int id = Integer.parseInt(request.getParameter("id"));
		HolidayCalendarEntry entry = null;
		for (HolidayCalendarEntry temp: entries) {
			if(temp.getId() == id) {
				entry = temp;
				break;
			}
		}
		if (entry != null) {
			entries.remove(entry);
		}
		response.sendRedirect("HolidayCalendar");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
