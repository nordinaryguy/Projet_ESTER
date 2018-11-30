package fr.univangers.ester.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

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

}
