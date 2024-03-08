package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.HolidayCalendarEntry;

/**
 * Servlet implementation class HolidayCalendar
 */
@WebServlet(urlPatterns="/HolidayCalendar", loadOnStartup=1)
public class HolidayCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolidayCalendar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		List<HolidayCalendarEntry> entries = new ArrayList<HolidayCalendarEntry>();
		
		entries.add(new HolidayCalendarEntry("2024-01-01", "New Year's Day"));
		entries.add(new HolidayCalendarEntry("2024-01-15", "Martin Luther King Jr. Day"));
		entries.add(new HolidayCalendarEntry("2024-02-12", "Lincoln's Birthday"));
		entries.add(new HolidayCalendarEntry("2024-02-19", "Presidents' Day"));
		entries.add(new HolidayCalendarEntry("2024-07-04", "Independence Day"));
		entries.add(new HolidayCalendarEntry("2024-09-02", "Labor Day"));
		entries.add(new HolidayCalendarEntry("2024-11-28", "Thanksgiving Day"));
		entries.add(new HolidayCalendarEntry("2024-12-25", "Christmas Day"));
		
		getServletContext().setAttribute("entries", entries);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<HolidayCalendarEntry> entries = (List<HolidayCalendarEntry>) getServletContext().getAttribute("entries");
				
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>Holiday Calendar Entry</title>");
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">");
		out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\" crossorigin=\"anonymous\"></script>\n");
		out.println("<link href=\"./access/css/Styles.css\" rel=\"stylesheet\" type=\"text/css\">\n");
		out.println("</head><body>");
		out.println("<div class='text-center'>");
		out.println("<h1>US Holidays</h1>");
		
		out.println("<div class='myTable'>"
				+ "<table class='table table-striped table-hover'>"
				+ "<thead>"
				+ "<tr>"
				+ "<th scope='col'>Date</th>"
				+ "<th scope='col'>Holiday</th>"
				+ "<th scope='col'>Update | Delete</th>"
				+ "</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (HolidayCalendarEntry entry : entries) {
	
			out.println("<tr>");
			out.println("<td>" + entry.getHolidayDate() + "</td>");
			out.println("<td>" + entry.getHoliday() + "</td>");
			out.println("<td> <a href='UpdateHoliday?id=" + entry.getId() + "'>Update</a> | "
					+ "<a href='DeleteHoliday?id=" + entry.getId() + "'>Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("<a class= 'btn btn-secondary w-40' href='AddHoliday' role='button'>Add Holiday</a>");
		//out.println("<a href='AddHoliday' class='btn btn-secondary w-40'> Add Holiday<button>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
