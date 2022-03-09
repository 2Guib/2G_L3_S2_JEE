package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Appel;

public class DataAccess {
	
	private static final String url = "jdbc:mysql://localhost:3306/java";
	private static final String user = "java";
	private static final String password = "";
	
	private static final String REQUEST = "SELECT * FROM pays;";

	private List<String> data;
	private Connection con;
	
	public DataAccess() {
		this.data = new ArrayList<>();
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
	
	public void updateData() {
		this.data.clear();
		try (
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(REQUEST);){
			
			while (rs.next()) {
				String res = "";
				for (int i=1;i<rs.getMetaData().getColumnCount(); i++) {
					res += rs.getString(i)+" | ";
				}
				this.data.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getData() {
		return data;
	}
	
	public void disconnect() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
