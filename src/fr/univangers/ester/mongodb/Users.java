package fr.univangers.ester.mongodb;

import java.util.Date;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import fr.univangers.ester.beans.Utilisateur.Status;

public class Users extends Database {
	
	private static final String C_USER_ESTER = "C_USER_ESTER";
	private static final String C_URL_TOKEN="C_URL_TOKEN";
	
	private static final String IDENTIFIANT = "Identifiant";
	private static final String URLTOKEN="Url Token";
	private static final String NAME = "Nom";
	private static final String FIRSTNAME = "Prénom";
	private static final String FIRSTCONNECTION = "Première connexion";
	private static final String PASSWORD = "Mot de passe";
	private static final String MAIL = "Mail";
	private static final String STATUS = "Statut";
	private static final String EXPIREDATE="Date expiration";
	
	public Users() {
		super();
	}
	
	public void addUserEster(String identifiant, String name, String firstName, String mail, String password, Status status) {
		if(existUserEster(identifiant)) {
			throw new IllegalArgumentException("Identifiant déja ajouter");
		}
		MongoCollection<Document> users = db().getCollection(C_USER_ESTER);
		Document user = new Document(IDENTIFIANT, identifiant)
				.append(NAME, name)
				.append(FIRSTNAME, firstName)
				.append(MAIL, mail)
				.append(FIRSTCONNECTION, true)
				.append(PASSWORD, password)
				.append(STATUS, status.toString());	
		users.insertOne(user);
	}
	
	public Status getStatusUserEster(String identifiant) {
		if(!existUserEster(identifiant)) {
			throw new IllegalArgumentException("Utilisateur n'existe pas.");	
		}
		MongoCollection<Document> users = db().getCollection(C_USER_ESTER);
		Document user = users.find(Filters.eq(IDENTIFIANT, identifiant)).first();
		return Status.toStatus(user.getString(STATUS));
	}
	
	public void deleteUserEster(String identifiant) {
		MongoCollection<Document> users = db().getCollection(C_USER_ESTER);
		users.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public boolean changePasswordUserEster(String identifant, String password) {
		MongoCollection<Document> users = db().getCollection(C_USER_ESTER);
		return (users.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(PASSWORD, password)))) != null;
	}
	
	public void changeFirstConnectionUserEster(String identifant, boolean firstConnection) {
		MongoCollection<Document> users = db().getCollection(C_USER_ESTER);
		users.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(FIRSTCONNECTION, firstConnection)));
	}
	
	public boolean isFirstCnxUserEster(String identifiant) {
		boolean res=true;
		if(existUserEster(identifiant)) {
			MongoCollection<Document> users = db().getCollection(C_USER_ESTER);
		    FindIterable<Document> iterable = users.find(Filters.eq(IDENTIFIANT, identifiant));
			res=iterable.first().getBoolean(FIRSTCONNECTION);
		}
		return res;
	}
	public boolean existUserEster(String identifiant) {
		MongoCollection<Document> users = db().getCollection(C_USER_ESTER);
	    FindIterable<Document> iterable = users.find(Filters.eq(IDENTIFIANT, identifiant));
		return iterable.first() != null;
	}
	
	public boolean connectUserEster(String identifiant, String password) {
		MongoCollection<Document> users = db().getCollection(C_USER_ESTER);
	    FindIterable<Document> iterable = users.find(Filters.and(Filters.eq(IDENTIFIANT, identifiant),
	    		Filters.eq(PASSWORD, password)));
		return iterable.first() != null;
	}
	
	public void addUrlToken(String identifiant,String token,Date expireDate) {
		MongoCollection<Document> urlTokens = db().getCollection(C_URL_TOKEN);
		if(existUrlToken(identifiant))
			deleteUrlToken(identifiant);
		Document urlToken = new Document(IDENTIFIANT, identifiant)
				.append(URLTOKEN, token)
				.append(EXPIREDATE, expireDate);
		urlTokens.insertOne(urlToken);
	}
	
	
	public void deleteUrlToken(String identifiant) {
		MongoCollection<Document> urlTokens = db().getCollection(C_URL_TOKEN);
		urlTokens.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public boolean hasUrlToken(String email) {
		MongoCollection<Document> urlTokens = db().getCollection(C_URL_TOKEN);
	    FindIterable<Document> iterable = urlTokens.find(Filters.eq(IDENTIFIANT,email));
		return iterable.first() != null && valideUrlToken((String) iterable.first().get(URLTOKEN));
	}
	public boolean existUrlToken(String token) {
		MongoCollection<Document> urlTokens = db().getCollection(C_URL_TOKEN);
	    FindIterable<Document> iterable = urlTokens.find(Filters.eq(URLTOKEN, token));
		return iterable.first() != null;
	}
	
	public String getIdentforToken(String token) {
		MongoCollection<Document> urlTokens = db().getCollection(C_URL_TOKEN);
	    Document urlToken = urlTokens.find(Filters.eq(URLTOKEN, token)).first();
	    return (String) urlToken.get(IDENTIFIANT);
	}
	
	public boolean valideUrlToken(String token) {
		MongoCollection<Document> urlTokens = db().getCollection(C_URL_TOKEN);
	    Document urlToken = urlTokens.find(Filters.eq(URLTOKEN, token)).first();
	    Date expireDate=(Date) urlToken.get(EXPIREDATE);
	    Date currentDate=new Date();
	    return (expireDate.after(currentDate));
	}
	
}
