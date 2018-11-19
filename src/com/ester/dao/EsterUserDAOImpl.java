package com.ester.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.ester.beans.EsterUser;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class EsterUserDAOImpl implements EsterUserDAO {

	private DAOFactory daoFactory;
	private static final String C_USER_ESTER = "C_USER_ESTER";


	public EsterUserDAOImpl(DAOFactory pDaoFactory) {
		this.daoFactory  = pDaoFactory;	
	}

	@Override
	public void addUserEster(EsterUser pUserEster) {
		// TODO Auto-generated method stub
		MongoDatabase databaseConnection = null;
		try {
			databaseConnection = daoFactory.getConnexionToDatabase();
			Gson gson = new Gson();
			MongoCollection<Document> collection = databaseConnection.getCollection(C_USER_ESTER);
	        Document document = Document.parse(gson.toJson(pUserEster));
	        collection.insertOne(document);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<EsterUser> listEsterUsers() {
		// TODO Auto-generated method stub
		MongoDatabase databaseConnection = null;
		try {
			databaseConnection = daoFactory.getConnexionToDatabase();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
