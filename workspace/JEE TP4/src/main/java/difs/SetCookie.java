package difs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/SetCookies")
public class SetCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("domaine", "test");
		resp.addCookie(cookie);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"utf-8\">\r\n"
				+ "	<title>\\o/</title>\r\n"
				+ "</head><html><body>\r\n");
		

		out.println("<h1>Set cookie : </h1>");
		

		out.println("</body></html>");
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
