package fr.univangers.ester.mongodb;

import java.util.Date;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class UrlTokenDB extends Database {
	
	private static final String C_URL_TOKEN="C_URL_TOKEN";

	private static final String IDENTIFIANT = "Identifiant";
	private static final String URLTOKEN="Url Token";
	private static final String EXPIREDATE="Date expiration";
	
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
