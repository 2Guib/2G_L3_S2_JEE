package difs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.InfoProverbe;
import bean.Utilisateur;

@WebServlet(value = "/")
public class IndexServlet extends HttpServlet {
	
	public static final String USER_SESSION = "USER_SESSION";
	public static final String USER_BEAN = "userBean";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute(USER_SESSION);
		if (user != null) {
			System.out.println("INDEX"+user+user.getNom());
			req.setAttribute(USER_BEAN, user);
		} else {
			System.out.println("No user");
			req.setAttribute(USER_BEAN, null);
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}
