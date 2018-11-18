package com.ester.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Users {
	
	private static final String C_SALARIE = "C_SALARIE";
	private static final String C_ENTREPRISE = "C_ENTREPRISE";
	private static final String C_USER_ESTER = "C_USER_ESTER";
	private static final String C_URL_TOKEN="C_URL_TOKEN";
	
	private static final String IDENTIFIANT = "Identifiant";
	private static final String URLTOKEN="Url Token";
	private static final String NAME = "Nom";
	private static final String FIRSTNAME = "Prénom";
	private static final String FIRSTCONNECTION = "Première connexion";
	private static final String PASSWORD = "Mot de passe";
	private static final String MAIL = "Mail";
	private static final String SALARIES = "Salariés";
	private static final String STATUS = "Statut";
	private static final String EXPIREDATE="Date expiration";
	
	private static final String ANONYMITYNUMBER = "Numéro d’anonymat";
	private static final String SEX = "Sexe";
	private static final String BIRTHYEAR = "Année de naissance";
	private static final String DEPARTMENT = "Département";
	private static final String ACTIVITYAREA = "Secteur d’activité";
	private static final String POSTNAME = "Nom du poste";
	private static final String QUESTIONNAIRESANSWERED = "Questionnaires répondus";
	private static final String QUESTIONNAIRESUNANSWERED = "Questionnaires non répondus";
	private static final String ENTREPRISE = "Entreprise";
	private static final String USERESTER = "Utilisateur ESTER ID";
	private static final String NBCONNECTION = "Nombre de connexion";
	private static final String TIMECONNECTION = "Durée de la connexion";
	
	
	
	private static final String HOSTNAME = "localhost";
	private static final int PORT = 27017;
	private static final String DBNAME = "BDD_ESTER_DEV";
	
	private MongoClient client;
	private MongoDatabase database;
	
	public Users() {
		client =  MongoClients.create("mongodb://" + HOSTNAME + ":" + PORT);
		database = client.getDatabase(DBNAME);
	}
	
	public void addSalarie(String identifiant, int anonymityNumber, String password, String sex, int birthYear, 
			String department, String activityArea, String postName, String entreprise, String userEster) {
		MongoCollection<Document> salaries = database.getCollection(C_SALARIE);
		Document salarie = new Document(IDENTIFIANT, identifiant)
				.append(ANONYMITYNUMBER, anonymityNumber)
				.append(FIRSTCONNECTION, true)
				.append(PASSWORD, password)
				.append(SEX, sex)
				.append(BIRTHYEAR, birthYear)
				.append(DEPARTMENT, department)
				.append(ACTIVITYAREA, activityArea)
				.append(POSTNAME, postName)
				.append(QUESTIONNAIRESANSWERED, new ArrayList<Document>())
				.append(QUESTIONNAIRESUNANSWERED, new ArrayList<Document>())
				.append(ENTREPRISE, entreprise)
				.append(USERESTER, userEster)
				.append(NBCONNECTION, 0)
				.append(TIMECONNECTION, 0);	
		salaries.insertOne(salarie);
		pushSalarieIntoEntreprise(entreprise, identifiant);
	}
	
	public void deleteSalarie(String identifiant) {
		MongoCollection<Document> salaries = database.getCollection(C_SALARIE);
		salaries.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public void changePasswordSalarie(String identifant, String password) {
		MongoCollection<Document> salaries = database.getCollection(C_SALARIE);
		salaries.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(PASSWORD, password)));
	}
	
	public void changeFirstConnectionSalarie(String identifant, boolean firstConnection) {
		MongoCollection<Document> salaries = database.getCollection(C_SALARIE);
		salaries.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(FIRSTCONNECTION, firstConnection)));
	}
	
	public boolean existSalarie(String identifiant) {
		MongoCollection<Document> salaries = database.getCollection(C_SALARIE);
	    FindIterable<Document> iterable = salaries.find(Filters.eq(IDENTIFIANT, identifiant));
		return iterable.first() != null;
	}
	
	public boolean connectSalarie(String identifiant, String password) {
		MongoCollection<Document> salaries = database.getCollection(C_USER_ESTER);
	    FindIterable<Document> iterable = salaries.find(Filters.and(Filters.eq(IDENTIFIANT, identifiant),
	    		Filters.eq(PASSWORD, password)));
		return iterable.first() != null;
	}
	
	public void addUserEster(String identifiant, String name, String firstName, String mail, String password, String status) {
		if(existUserEster(identifiant)) {
			throw new IllegalArgumentException("Identifiant déja ajouter");
		}
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
		Document user = new Document(IDENTIFIANT, identifiant)
				.append(NAME, name)
				.append(FIRSTNAME, firstName)
				.append(MAIL, mail)
				.append(FIRSTCONNECTION, true)
				.append(PASSWORD, password)
				.append(STATUS, status);	
		users.insertOne(user);
	}
	
	public void deleteUserEster(String identifiant) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
		users.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public void changePasswordUserEster(String identifant, String password) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
		users.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(PASSWORD, password)));
	}
	
	public void changeFirstConnectionUserEster(String identifant, boolean firstConnection) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
		users.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(FIRSTCONNECTION, firstConnection)));
	}
	
	public boolean existUserEster(String identifiant) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
	    FindIterable<Document> iterable = users.find(Filters.eq(IDENTIFIANT, identifiant));
		return iterable.first() != null;
	}
	
	public boolean connectUserEster(String identifiant, String password) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
	    FindIterable<Document> iterable = users.find(Filters.and(Filters.eq(IDENTIFIANT, identifiant),
	    		Filters.eq(PASSWORD, password)));
		return iterable.first() != null;
	}
	
	public void addEntreprise(String identifiant, String name, String password) {
		if(existEntreprise(identifiant)) {
			throw new IllegalArgumentException("Identifiant déja ajouter");
		}
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		Document entreprise = new Document(IDENTIFIANT, identifiant)
				.append(NAME, name)
				.append(FIRSTCONNECTION, true)
				.append(PASSWORD, password)
				.append(SALARIES, new ArrayList<Document>());	
		entreprises.insertOne(entreprise);
	}
	
	public void deleteEntreprise(String identifiant) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public void changePasswordEntreprise(String identifant, String password) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(PASSWORD, password)));
	}
	
	public void changeFirstConnectionEntreprise(String identifant, boolean firstConnection) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(FIRSTCONNECTION, firstConnection)));
	}
	
	public boolean existEntreprise(String identifiant) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
	    FindIterable<Document> iterable = entreprises.find(Filters.eq(IDENTIFIANT, identifiant));
		return iterable.first() != null;
	}
	
	public boolean connectEntreprise(String identifiant, String password) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
	    FindIterable<Document> iterable = entreprises.find(Filters.and(Filters.eq(IDENTIFIANT, identifiant),
	    		Filters.eq(PASSWORD, password)));
		return iterable.first() != null;
	}
	
	public void pushSalarieIntoEntreprise(String identifiantEntreprise, String identifiantSalarie) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiantEntreprise),
				new Document("$push", new Document(SALARIES, identifiantSalarie)));
	}
	
	public List<String> getSalariesEntreprise(String identifiant) {
		List<String> salaries = new ArrayList<>();
		if(!existEntreprise(identifiant)) {
			throw new IllegalArgumentException("L'entreprise n'existe pas.");	
		}
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
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
	
	public void pullSalarieIntoEntreprise(String identifiantEntreprise, String identifiantSalarie) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiantEntreprise),
				new Document("$pull", new Document(SALARIES, identifiantSalarie)));
	}
	

	public void addUrlToken(String identifiant,String token,Date expireDate) {
		MongoCollection<Document> urlTokens = database.getCollection(C_URL_TOKEN);
		if(existUrlToken(identifiant))
			deleteUrlToken(identifiant);
		Document urlToken = new Document(IDENTIFIANT, identifiant)
				.append(URLTOKEN, token)
				.append(EXPIREDATE, expireDate);
		urlTokens.insertOne(urlToken);
	}
	
	
	public void deleteUrlToken(String identifiant) {
		MongoCollection<Document> urlTokens = database.getCollection(C_URL_TOKEN);
		urlTokens.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public boolean existUrlToken(String token) {
		MongoCollection<Document> urlTokens = database.getCollection(C_URL_TOKEN);
	    FindIterable<Document> iterable = urlTokens.find(Filters.eq(URLTOKEN, token));
		return iterable.first() != null;
	}
	
	public String getIdentforToken(String token) {
		MongoCollection<Document> urlTokens = database.getCollection(C_URL_TOKEN);
	    Document urlToken = urlTokens.find(Filters.eq(URLTOKEN, token)).first();
	    return (String) urlToken.get(IDENTIFIANT);
	}
	
	public boolean valideUrlToken(String token) {
		MongoCollection<Document> urlTokens = database.getCollection(C_URL_TOKEN);
	    Document urlToken = urlTokens.find(Filters.eq(URLTOKEN, token)).first();
	    Date expireDate=(Date) urlToken.get(EXPIREDATE);
	    Date currentDate=new Date();
	    return (expireDate.after(currentDate));
	}
	
}