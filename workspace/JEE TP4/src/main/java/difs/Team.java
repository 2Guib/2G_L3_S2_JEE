package difs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Team extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	private static String proverbesFile = "/WEB-INF/proverbes.txt";
	private Random random;
	private List<String> fileLines;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.random = new Random();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String teamColor = getServletConfig().getInitParameter("color");
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"utf-8\">\r\n"
				+ "	<title>\\o/</title>\r\n"
				+ "</head>\r\n");
		

		out.println("<body style=\"background-color:"+ teamColor+"\">");
		out.println("<h1>Panda...</h1>");
		out.println("<img src=\"panda.jpg\"/>");
		

		out.println("</body></html>");
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
