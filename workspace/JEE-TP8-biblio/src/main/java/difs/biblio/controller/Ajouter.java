package difs.biblio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import difs.biblio.model.LivreManager;

/**
 * Servlet implementation class Ajouter
 */
@WebServlet("/ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LivreManager manager;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouter.jsp").forward(request, response);
	}
}
