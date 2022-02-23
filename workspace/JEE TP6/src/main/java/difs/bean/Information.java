package difs.bean;

import java.io.Serializable;

public class Information implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String source;
	private String contexte;
	private String contenu;
	
	public Information() {
		super();
		this.source = "";
		this.contexte = "";
		this.contenu = "";
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}	
}
