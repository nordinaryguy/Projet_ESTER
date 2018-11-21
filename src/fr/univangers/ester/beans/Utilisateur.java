package fr.univangers.ester.beans;

import fr.univangers.ester.mongodb.Users;

public class Utilisateur implements User {

	private String identifiant;
	private String password;

	@Override
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	@Override
	public String getIdentifiant() {
		return identifiant;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public boolean validate() {
		Users users = new Users();
		return users.connectSalarie(identifiant, password);
	}

	@Override
	public boolean isEntreprise() {
		return false;
	}

	@Override
	public boolean isSalarie() {
		return false;
	}

	@Override
	public boolean isUtilisateur() {
		return true;
	}

}
