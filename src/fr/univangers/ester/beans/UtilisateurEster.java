package fr.univangers.ester.beans;

import fr.univangers.ester.mongodb.UtilisateurEsterDB;

public class UtilisateurEster implements UtilisateurBeans {
	
	public enum Status {
		  MEDECIN ("Medecin"),
		  ADMINISTRATEUR ("Administrateur"),
		  INFIRMIER ("Infirmier"),
		  PREVENTEUR ("Preventeur"),
		  ASSISTANT ("Assistant");
		
		  private String name = "";
		  
		  Status(String name){
		    this.name = name;
		  }
		  
		  public static Status toStatus(String name) {
			  Status status = Status.ASSISTANT;
			  if(name.equals(Status.ADMINISTRATEUR.name))
				  status = Status.ADMINISTRATEUR;
			  else if(name.equals(Status.ASSISTANT.name))
				  status = Status.ASSISTANT;
			  else if(name.equals(Status.INFIRMIER.name))
				  status = Status.INFIRMIER;
			  else if(name.equals(Status.PREVENTEUR.name))
				  status = Status.PREVENTEUR;
			  else if(name.equals(Status.MEDECIN.name))
				  status = Status.MEDECIN;
			  return status;
		  }
		  
		  @Override
		  public String toString(){
		    return name;
		  }
	}

	private Status status;
	private String identifiant;
	private String password;
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}
	
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
		UtilisateurEsterDB users = new UtilisateurEsterDB();
		return users.connect(identifiant, password);
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

	@Override
	public boolean isAdministrateur() {
		return status == Status.ADMINISTRATEUR;
	}

	@Override
	public boolean isMedecin() {
		return status == Status.MEDECIN;
	}

	@Override
	public boolean isPreventeur() {
		return status == Status.PREVENTEUR;
	}

	@Override
	public boolean isAssistant() {
		return status == Status.ASSISTANT;
	}

	@Override
	public boolean isInfirmier() {
		return status == Status.INFIRMIER;

	}

	@Override
	public boolean isFirstConnection() {
		UtilisateurEsterDB user=new UtilisateurEsterDB();
		return user.isFirstCnx(identifiant);
	}

}
