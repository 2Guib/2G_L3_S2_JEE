package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DataAccess;

/**
 * Servlet implementation class PodiumServlet
 */
@WebServlet("/podium")
public class PodiumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataAccess dataAccess;
	
	@Override
		public void init() throws ServletException {
			this.dataAccess = new DataAccess();
			super.init();
		}
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("podium", dataAccess.getPodiumByDisc(Integer.parseInt(req.getParameter("sport"))));
		this.getServletContext().getRequestDispatcher("/WEB-INF/podium.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		this.dataAccess.disconnect();
		super.destroy();
	}

}
