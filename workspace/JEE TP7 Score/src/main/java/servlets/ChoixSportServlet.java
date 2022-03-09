package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DataAccess;

/**
 * Servlet implementation class ChoixSportServlet
 */
@WebServlet("/sport")
public class ChoixSportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DATA_SPORTS = "dataSports";
	
	private DataAccess dataAccess;
	
	@Override
		public void init() throws ServletException {
			this.dataAccess = new DataAccess();
			super.init();
		}
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute(DATA_SPORTS, dataAccess.getDiscs());
		this.getServletContext().getRequestDispatcher("/WEB-INF/sport.jsp").forward(req, resp);
	}
	
	@Override
		public void destroy() {
			this.dataAccess.disconnect();
			super.destroy();
		}

}
