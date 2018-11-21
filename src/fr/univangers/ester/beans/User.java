package fr.univangers.ester.beans;

public interface User {
	
	public void setIdentifiant(String identifiant);
	public String getIdentifiant();
	public boolean validate();
	public boolean isEntreprise();
	public boolean isSalarie();
	public boolean isUtilisateur();
	
}