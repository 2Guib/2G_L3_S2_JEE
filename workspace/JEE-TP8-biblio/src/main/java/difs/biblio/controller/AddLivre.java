package difs.biblio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import difs.biblio.model.LivreManager;

@WebServlet("/addlivre")
public class AddLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LivreManager manager;
      
	@Override
	public void init() throws ServletException {
		super.init();
		this.manager = (LivreManager) getServletContext().getAttribute(LivreManager.MANAGER_ATTRIBUTE);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.manager.addLivre("BIDON", "AUTEUR BIDON");
		
	}

}
