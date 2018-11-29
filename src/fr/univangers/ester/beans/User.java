package fr.univangers.ester.beans;

public interface User {
	
	public void setIdentifiant(String identifiant);
	public String getIdentifiant();
	public boolean validate();
	public boolean isEntreprise();
	public boolean isSalarie();
	public boolean isUtilisateur();
	public boolean isAdministrateur();
	public boolean isMedecin();
	public boolean isPreventeur();
	public boolean isAssistant();
	public boolean isInfirmier();

}
