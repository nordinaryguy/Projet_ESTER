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
	private static final String PASSWORD = "Mot de passe";
	private static final String FIRSTCONNECTION = "Première connexion";
	private static final String SALARIES = "Salariés";
	
	public void addEntreprise(String identifiant, String name, String password) {
		if(existEntreprise(identifiant)) {
			throw new IllegalArgumentException("Identifiant déja ajouter");
		}
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		Document entreprise = new Document(IDENTIFIANT, identifiant)
				.append(NAME, name)
				.append(FIRSTCONNECTION, true)
				.append(PASSWORD, password)
				.append(SALARIES, new ArrayList<Document>());	
		entreprises.insertOne(entreprise);
	}
	
	public void deleteEntreprise(String identifiant) {
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public void changePasswordEntreprise(String identifant, String password) {
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(PASSWORD, password)));
	}
	
	public void changeFirstConnectionEntreprise(String identifant, boolean firstConnection) {
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(FIRSTCONNECTION, firstConnection)));
	}
	
	public boolean isFirstCnxEntreprise(String identifiant) {
		boolean res=true;
		if(existEntreprise(identifiant)) {
			MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		    FindIterable<Document> iterable = entreprises.find(Filters.eq(IDENTIFIANT, identifiant));
			res=iterable.first().getBoolean(FIRSTCONNECTION);
		}
		return res;
	}
	
	public boolean existEntreprise(String identifiant) {
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
	    FindIterable<Document> iterable = entreprises.find(Filters.eq(IDENTIFIANT, identifiant));
		return iterable.first() != null;
	}
	
	public boolean connectEntreprise(String identifiant, String password) {
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
	    FindIterable<Document> iterable = entreprises.find(Filters.and(Filters.eq(IDENTIFIANT, identifiant),
	    		Filters.eq(PASSWORD, password)));
		return iterable.first() != null;
	}
	
	public List<String> getSalariesEntreprise(String identifiant) {
		List<String> salaries = new ArrayList<>();
		if(!existEntreprise(identifiant)) {
			throw new IllegalArgumentException("L'entreprise n'existe pas.");	
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
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiantEntreprise),
				new Document("$push", new Document(SALARIES, identifiantSalarie)));
	}
	
	public void pullSalarieIntoEntreprise(String identifiantEntreprise, String identifiantSalarie) {
		MongoCollection<Document> entreprises = db().getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiantEntreprise),
				new Document("$pull", new Document(SALARIES, identifiantSalarie)));
	}
}
