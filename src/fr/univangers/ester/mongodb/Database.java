package fr.univangers.ester.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import at.favre.lib.crypto.bcrypt.BCrypt;

public abstract class Database {
	
	private static final String HOSTNAME = "localhost";
	private static final int PORT = 27017;
	private static final String DBNAME = "BDD_ESTER_DEV";
	
	private static MongoClient client;
	private static MongoDatabase mgdb;
	
	public MongoDatabase db() {
		if(mgdb == null) {
			client =  MongoClients.create("mongodb://" + HOSTNAME + ":" + PORT);
			mgdb = client.getDatabase(DBNAME);
		}
		return mgdb;
	} 
	
	public String cryptPassword(String password) {
		return BCrypt.withDefaults().hashToString(BCrypt.MAX_COST, password.toCharArray());
	}
	
	public boolean verifyPassword(String password, String passwordCrypt) {
		return BCrypt.verifyer().verify(password.toCharArray(), passwordCrypt).verified;
	}
	
}
