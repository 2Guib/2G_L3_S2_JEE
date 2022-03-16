package difs.biblio.model;

import java.util.ArrayList;
import java.util.List;

public class LivreManager {
	
	public static final String MANAGER_ATTRIBUTE = "manager";

	public List<Livre> getLivres() {
		List<Livre> livres = new ArrayList<Livre>();
		for (int i=0; i<10; i++) {
			livres.add(livreBidon());
		}
		return livres;
	}
	
	private Livre livreBidon() {
		Livre l = new Livre();
		l.setId(666);
		l.setTitre("Livre Bidon");
		l.setAuteur("Michel Bidon");
		return l;
	}
}
