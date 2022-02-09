package difs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NombreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final int MAX_NOMBRE = 101;
	
	private Random rand;
	private int bonheurHumanite2022;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.rand = new Random();
		this.bonheurHumanite2022 = rand.nextInt(MAX_NOMBRE);
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int nb1 = rand.nextInt(MAX_NOMBRE);
		int nb2 = rand.nextInt(MAX_NOMBRE);
		int nb3 = rand.nextInt(MAX_NOMBRE);
		int nb4 = rand.nextInt(MAX_NOMBRE);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"utf-8\">\r\n"
				+ "	<title>Nombres du bonheur</title>\n"
				+ "<link href=\"css.css\" rel=\"stylesheet\" type=\"text/css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n");
		
		out.println("<h1>Nombres du bonheur</h1>");
		out.println("<h2>Le nombre de l'humanité est : "+this.bonheurHumanite2022+"</h2>");
		out.println("<ul>");
		out.println("<li>"+nb1+"</li>");
		out.println("<li>"+nb2+"</li>");
		out.println("<li>"+nb3+"</li>");
		out.println("<li>"+nb4+"</li>");
		out.println("</ul>");
		out.println("<img src=\"boule-de-cristal.jpeg\"/>");
		
		out.println("</body></html>");
		resp.setStatus(HttpServletResponse.SC_OK);
	}
	
	

}
