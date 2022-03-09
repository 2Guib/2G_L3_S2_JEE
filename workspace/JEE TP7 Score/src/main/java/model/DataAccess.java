package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Podium;
import beans.Discipline;
import beans.Sportif;

public class DataAccess {
	
	private static final String url = "jdbc:mysql://localhost:3306/java";
	private static final String user = "java";
	private static final String password = "";
	
	private static final String SELECT_DISC = "SELECT * FROM discipline\n";

	private Connection con;
	
	public DataAccess() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			this.con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Discipline> getDiscs() {
		List<Discipline> sports = new ArrayList<Discipline>();
		
		try (
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SELECT_DISC);){
			
			while (rs.next()) {
				Discipline s = new Discipline();
				s.setId(rs.getInt("id_disc"));
				s.setNom(rs.getString("nom_disc"));
				s.setType(rs.getString("type_disc"));
				s.setId_sport(rs.getInt("id_sport"));
				sports.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sports;
	}
	
	public Discipline getDiscById(int id) {
		Discipline disc = null;
		String req = SELECT_DISC;
		req += "WHERE id_disc = "+id;
		try (
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(req);
				){
			
			while (rs.next()) {
				disc = new Discipline();
				disc.setId(rs.getInt("id_disc"));
				disc.setNom(rs.getString("nom_disc"));
				disc.setType(rs.getString("type_disc"));
				disc.setId_sport(rs.getInt("id_sport"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return disc;
		
	}
	
	public Sportif getMedailleByDisc(int idDisc, String medaille) {
		Sportif smedaille = null;
		String req = "SELECT S.id_sportif, S.nom, S.prenom, S.cio FROM sportif S, gagner G\n";
		req += "WHERE G.id_disc = "+idDisc+"\n";
		req += "AND G.id_sportif = S.id_sportif\n";
		req += "AND G.medaille = '" + medaille +"'";
		
		try (
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(req);
				) {
			if (rs.next()) {
				smedaille = new Sportif();
				smedaille.setId(rs.getInt("id_sportif"));
				smedaille.setNom(rs.getString("nom"));
				smedaille.setPrenom(rs.getString("prenom"));
				smedaille.setCio(rs.getString("cio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return smedaille;		
	}
	
	
	
	public Podium getPodiumByDisc(int idDisc) {
		Podium p = new Podium();
		p.setSport(this.getDiscById(idDisc));
		p.setBronze(this.getMedailleByDisc(idDisc, "B"));
		p.setSilver(this.getMedailleByDisc(idDisc, "S"));
		p.setGold(this.getMedailleByDisc(idDisc, "G"));
		return p;
		
	}
	
	
	public void disconnect() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
