package difs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import difs.bean.Identifiant;
import difs.bean.Information;

@WebServlet(value = "/first")
public class FirstServlet extends HttpServlet {
	
	private static final String IDENTIFIANT = "idBean";
	private static final String INFORMATION = "infoBean";
	private static final String DATE = "date";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute(IDENTIFIANT) == null) {
			Identifiant i = new Identifiant();
			i.setIdentifiant(session.getId());
			session.setAttribute(IDENTIFIANT, i);
			System.out.println("session créée");
		}
		Information info = new Information();
		info.setContexte("Requete");
		info.setContenu(new Date().toString());
		

		req.setAttribute(INFORMATION, info);
		req.setAttribute(DATE, new Date());
		req.getRequestDispatcher("/WEB-INF/First.jsp").forward(req, resp);
	}
}
