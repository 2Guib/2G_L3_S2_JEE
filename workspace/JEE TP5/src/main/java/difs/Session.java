package difs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/session")
public class Session extends HttpServlet {
	
	private Map<String,Integer> connexions;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.connexions = new HashMap<String, Integer>();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"utf-8\">\r\n"
				+ "	<title>\\o/</title>\r\n"
				+ "</head><html><body>\r\n");
		
		if (session == null) {
			session = req.getSession();
			this.connexions.put(session.getId(), 1);
			out.println("<h1>Bienvenue ! "+session.getId()+"</h1>");
		} else {
			this.connexions.put(session.getId(), this.connexions.get(session.getId()) + 1);
			out.println("<h1>Bon retour parmis nous ! "+session.getId()+"</h1>");
			out.println("<h3> C'est la "+this.connexions.get(session.getId())+"eme fois qu'on te vois</h3>");
		}

		out.println("</body></html>");
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
