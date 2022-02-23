package difs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.InfoProverbe;
import bean.Utilisateur;


@WebServlet(value = "/proverbe")
public class ProverbeServlet extends HttpServlet {
	
	private static final String PARAM_NAME = "name";
	private static final String PARAM_NUMBER = "number";
	

	private static final String PROVERBE_BEAN = "proverbeBean";
	
	private static String proverbesFile = "./WEB-INF/proverbes.txt";
	private List<String> fileLines;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.fileLines = new ArrayList<String>();
		InputStream stream = getServletContext().getResourceAsStream(proverbesFile);
		String line;
		try {
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
			line = fileReader.readLine();
			while (line != null) {
				fileLines.add(line);
				line = fileReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute(IndexServlet.USER_SESSION);
		if (user != null) {
			System.out.println("session trouve : "+user);
		} else {
			user = new Utilisateur();
			user.setNom(req.getParameter(PARAM_NAME));
			session.setAttribute(IndexServlet.USER_SESSION, user);	
			System.out.println("creation session" + user);
		}
		System.out.println(user);
		InfoProverbe proverbe = new InfoProverbe();
		proverbe.setNom(user.getNom());
		proverbe.setNumProverbe(Integer.parseInt(req.getParameter(PARAM_NUMBER)));
		if (proverbe.getNumProverbe() >=0 && proverbe.getNumProverbe() < fileLines.size()) {
			proverbe.setProverbe(fileLines.get(proverbe.getNumProverbe()));
		}
		req.setAttribute(PROVERBE_BEAN, proverbe);
		this.getServletContext().getRequestDispatcher("/WEB-INF/proverbe.jsp").forward(req, resp);
	}
}
