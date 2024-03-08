package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.HolidayCalendarEntry;

/**
 * Servlet implementation class AddHoliday
 */
@WebServlet("/AddHoliday")
public class AddHoliday extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHoliday() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>Holiday Calendar Entry</title>");
	
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">");
		out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\" crossorigin=\"anonymous\"></script>\n");
		out.println("<link href=\"./access/css/Styles.css\" rel=\"stylesheet\" type=\"text/css\">\n");
		
		out.println("</head><body>");
		out.println("<div class='text-center'>");
		out.println("<h1>Add Holiday</h1>");
		out.println("<div>");
//		div contains form
		
		out.println("<form id='AddHoliday' action='AddHoliday' method='post'>");
		out.println("<label for='holidayDate'>Holiday Date: </label>");
		
		out.println("<select id='holidayDate' name='day'>");
		out.println("<option value='01'>1 </option>");
		out.println("<option value='02'>2 </option>");
		out.println("<option value='03'>3 </option>");
		out.println("<option value='04'>4 </option>");
		out.println("<option value='05'>5 </option>");
		out.println("<option value='06'>6 </option>");
		out.println("<option value='07'>7 </option>");
		out.println("<option value='08'>8 </option>");
		out.println("<option value='09'>9 </option>");
		out.println("<option value='10'>10 </option>");
		out.println("<option value='11'>11 </option>");
		out.println("<option value='12'>12 </option>");
		out.println("<option value='13'>13 </option>");
		out.println("<option value='14'>14 </option>");
		out.println("<option value='15'>15 </option>");
		out.println("<option value='16'>16 </option>");
		out.println("<option value='17'>17 </option>");
		out.println("<option value='18'>18 </option>");
		out.println("<option value='19'>19 </option>");
		out.println("<option value='20'>20 </option>");
		out.println("<option value='21'>21 </option>");
		out.println("<option value='22'>22 </option>");
		out.println("<option value='23'>23 </option>");
		out.println("<option value='24'>24 </option>");
		out.println("<option value='25'>25 </option>");
		out.println("<option value='26'>26 </option>");
		out.println("<option value='27'>27 </option>");
		out.println("<option value='28'>28 </option>");
		out.println("<option value='29'>29 </option>");
		out.println("<option value='30'>30 </option>");
		out.println("<option value='31'>31 </option>");
		
		out.println("</select>");
		out.println("<select id='holidayDate' name='month'>");
		out.println("<option value='01'>January</option>");
		out.println("<option value='02'>Febuary</option>");
		out.println("<option value='03'>March</option>");
		out.println("<option value='04'>April</option>");
		out.println("<option value='05'>May</option>");
		out.println("<option value='06'>June</option>");
		out.println("<option value='07'>July</option>");
		out.println("<option value='08'>August</option>");
		out.println("<option value='09'>September</option>");
		out.println("<option value='10'>October</option>");
		out.println("<option value='11'>November</option>");
		out.println("<option value='12'>December</option>");
		out.println("</select>");
			
		out.println("<select id='holidayDate' name='year'>");
		out.println("<option value='2024'>2024</option>");
		out.println("<option value='2023'>2023</option>");
		out.println("<option value='2022'>2022</option>");
		out.println("<option value='2021'>2021</option>");
		out.println("<option value='2020'>2020</option>");
		out.println("<option value='2019'>2019</option>");
		out.println("</select>");
			
		out.println("<br></br>");

		out.println("<label for='holiday'>Holiday Name:<label>");
		out.println("<input type='text' id='holiday' name='holidayName' value=' '>");
		
		
	
		out.println("<button> Add Holiday<button>");
		out.println("</form>");
//		div contains form
		out.println("<div>");
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
		
		
		String holidayName = request.getParameter("holidayName");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		
		String dateString = String.format("%s-%s-%s", year, month, day);
		HolidayCalendarEntry entry = new HolidayCalendarEntry(dateString, holidayName);
		
		List<HolidayCalendarEntry> entries = (List<HolidayCalendarEntry>) getServletContext().getAttribute("entries");
		entries.add(entry);
		response.sendRedirect("HolidayCalendar");
	}

}
