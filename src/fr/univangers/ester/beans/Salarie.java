package fr.univangers.ester.beans;

import fr.univangers.ester.mongodb.Users;

public class Salarie implements User {

	private String identifiant;

	@Override
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	@Override
	public String getIdentifiant() {
		return identifiant;
	}
	
	@Override
	public boolean validate() {
		Users users = new Users();
		return users.existSalarie(identifiant);
	}

	@Override
	public boolean isEntreprise() {
		return false;
	}

	@Override
	public boolean isSalarie() {
		return true;
	}

	@Override
	public boolean isUtilisateur() {
		return false;
	}

	@Override
	public boolean isAdministrateur() {
		return false;
	}

	@Override
	public boolean isMedecin() {
		return false;
	}

	@Override
	public boolean isPreventeur() {
		return false;
	}

	@Override
	public boolean isAssistant() {
		return false;
	}

	@Override
	public boolean isInfirmier() {
		return false;
	}

}
