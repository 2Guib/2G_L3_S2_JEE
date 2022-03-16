package difs.biblio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class LivreManager {
	
	public static final String MANAGER_ATTRIBUTE = "manager";
	
	private SessionFactory sessionFactory;
	
	public LivreManager() {
		System.out.println("Constructeur LivreManager");
		// Initialisation à partir du fichier src/main/resources/hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			// Récuperation du sessionFactory
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.err.println("Impossible de créer la SessionFactory !");
			e.printStackTrace();
		}
	}

	public List<Livre> getLivres() {
		List<Livre> livres = new ArrayList<Livre>();
		Session session = sessionFactory.openSession();
		CriteriaQuery<Livre> criteria = session.getCriteriaBuilder().createQuery(Livre.class);
		Root<Livre> livreRoot = criteria.from(Livre.class);
		criteria.select(livreRoot);
		livres = session.createQuery(criteria).getResultList();
		return livres;
	}
	
	public Livre getLivreById(int id) {
		Session session = sessionFactory.openSession();
		Livre livre = session.get(Livre.class, id);
		System.out.println("Titre: " + livre.getTitre());
		System.out.println("Author: " + livre.getAuteur());
		session.close();
		return livre;
	}
	
	public void addLivre(String titre, String auteur) {
		Livre l = new Livre();
		l.setTitre(titre);
		l.setAuteur(auteur);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(l);
		session.getTransaction().commit();
		
	}
}
