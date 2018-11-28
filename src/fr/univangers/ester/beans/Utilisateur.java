package fr.univangers.ester.beans;

import fr.univangers.ester.mongodb.Users;

public class Utilisateur implements User {
	
	public enum Status {
		  MEDECIN ("Medecin"),
		  ADMINISTRATEUR ("Administrateur"),
		  INFIRMIER ("Infirmier"),
		  PREVENTEUR ("Preventeur"),
		  ASSISTANCE ("Assistant");
		
		  private String name = "";
		  
		  Status(String name){
		    this.name = name;
		  }
		  
		  public static Status toStatus(String name) {
			  Status status = Status.ASSISTANCE;
			  if(name == Status.ADMINISTRATEUR.name)
				  status = Status.ADMINISTRATEUR;
			  else if(name == Status.ASSISTANCE.name)
				  status = Status.ASSISTANCE;
			  else if(name == Status.INFIRMIER.name)
				  status = Status.INFIRMIER;
			  else if(name == Status.PREVENTEUR.name)
				  status = Status.PREVENTEUR;
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
		return status == Status.ASSISTANCE;
	}

}
