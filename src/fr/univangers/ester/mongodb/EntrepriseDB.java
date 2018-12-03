package fr.univangers.ester.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class EntrepriseDB extends Database {
	
	private static final String C_ENTREPRISE = "C_ENTREPRISE";
	
	private static final String IDENTIFIANT = "Identifiant";
	private static final String NAME = "Nom";
	private static final String PASS = "Mot de passe";
	private static final String FIRSTCONNECTION = "Première connexion";
	private static final String SALARIES = "Salariés";
	private static final String ERROR_NO_EXIST = "Entreprise n'existe pas.";
	
	public void add(String identifiant, String name, String password) {
		if(exist(identifiant)) {
			throw new IllegalArgumentException("Identifiant déja ajouter");
		}
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		Document entreprise = new Document(IDENTIFIANT, identifiant)
				.append(NAME, name)
				.append(FIRSTCONNECTION, true)
				.append(PASS, cryptPassword(password))
				.append(SALARIES, new ArrayList<Document>());	
		entreprises.insertOne(entreprise);
	}
	
	public void delete(String identifiant) {
		if(!exist(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public void changePassword(String identifiant, String password) {
		if(!exist(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiant),
				new Document("$set", new Document(PASS, cryptPassword(password))));
	}
	
	public void changeFirstConnection(String identifiant, boolean firstConnection) {
		if(!exist(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiant),
				new Document("$set", new Document(FIRSTCONNECTION, firstConnection)));
	}
	
	public boolean isFirstCnx(String identifiant) {
		boolean res=true;
		if(exist(identifiant)) {
			MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		    FindIterable<Document> iterable = entreprises.find(Filters.eq(IDENTIFIANT, identifiant));
			res=iterable.first().getBoolean(FIRSTCONNECTION);
		}
		return res;
	}
	
	public boolean exist(String identifiant) {
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
	    FindIterable<Document> iterable = entreprises.find(Filters.eq(IDENTIFIANT, identifiant));
		return iterable.first() != null;
	}
	
	public boolean connect(String identifiant, String password) {
		boolean res = false;
		if(exist(identifiant)) {
			MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
			Document entreprise = entreprises.find(Filters.eq(IDENTIFIANT, identifiant)).first();
			res = verifyPassword(password, entreprise.getString(PASS));
		}
		return res;
	}
	
	public List<String> getSalariesEntreprise(String identifiant) {
		List<String> salaries = new ArrayList<>();
		if(!exist(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
	    Document entreprise = entreprises.find(Filters.eq(IDENTIFIANT, identifiant)).first();
	    if(entreprise.get(SALARIES) instanceof List<?>) {
		    List<?> objects = (List<?>)entreprise.get(SALARIES);
	    	for(Object object : objects) {
	    	    if (object instanceof String) {
	    	    	salaries.add((String) object);
	    	    }
	    	}
	    }
	    return salaries;
	}
	
	public void pushSalarieIntoEntreprise(String identifiantEntreprise, String identifiantSalarie) {
		if(identifiantEntreprise == null) {
			return;
		}
		if(!exist(identifiantEntreprise)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiantEntreprise),
				new Document("$push", new Document(SALARIES, identifiantSalarie)));
	}
	
	public void pullSalarieIntoEntreprise(String identifiantEntreprise, String identifiantSalarie) {
		if(!exist(identifiantEntreprise)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiantEntreprise),
				new Document("$pull", new Document(SALARIES, identifiantSalarie)));
	}
}
