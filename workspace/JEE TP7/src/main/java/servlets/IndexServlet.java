package servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DataAccess;

@WebServlet(value = "/index")
public class IndexServlet extends HttpServlet {
	
	private DataAccess dataAccess;
	
	@Override
	public void init() throws ServletException {
		this.dataAccess = new DataAccess();
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dataAccess.updateData();
		req.setAttribute("list", dataAccess.getData());
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		this.dataAccess.disconnect();
		super.destroy();
	}
}
