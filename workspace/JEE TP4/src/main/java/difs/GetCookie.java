package difs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/GetCookies")
public class GetCookie extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] reqCookies = req.getCookies();
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"utf-8\">\r\n"
				+ "	<title>\\o/</title>\r\n"
				+ "</head><html><body>\r\n");
		

		out.println("<h1>Get cookie : </h1>");
		
		if (reqCookies != null) {
			for (Cookie c : reqCookies) {
				out.println("<p>"+ c.getName()+" : "+c.getValue()+"</p>");
			}			
		}

		out.println("</body></html>");
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
