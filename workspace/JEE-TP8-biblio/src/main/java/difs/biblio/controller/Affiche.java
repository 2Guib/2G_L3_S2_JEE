package difs.biblio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import difs.biblio.model.LivreManager;


@WebServlet("/affiche")
public class Affiche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LivreManager manager;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.manager = (LivreManager) getServletContext().getAttribute(LivreManager.MANAGER_ATTRIBUTE);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(this.manager.getLivres());
		request.setAttribute("livres", this.manager.getLivres());
		this.getServletContext().getRequestDispatcher("/WEB-INF/affiche.jsp").forward(request, response);
	}

}
