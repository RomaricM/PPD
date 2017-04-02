package outils;

import java.util.ArrayList;

public class Utilisateur {
	
	private int noutil;
	private String login;
	private String mdp;
	private String email;
//	private boolean alertmail;
//	private boolean alertappli;
	private ArrayList<Appareil> listapp;
	
	public int getNoutil() {
		return noutil;
	}
	public String getLogin() {
		return login;
	}
	public String getMdp() {
		return mdp;
	}
	public String getEmail() {
		return email;
	}
	public ArrayList<Appareil> getListapp() {
		return listapp;
	}
	
	

}
