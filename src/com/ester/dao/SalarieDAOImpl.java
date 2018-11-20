package com.ester.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.ester.beans.Salarie;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class SalarieDAOImpl implements SalarieDAO {
	
	private DAOFactory daoFactory;
	private static final String C_SALARIE = "C_SALARIE";
	private static final String IDENTIFIANT = "mSecureIdGenerated";


	public SalarieDAOImpl(DAOFactory pDaoFactory) {
		this.daoFactory  = pDaoFactory;	
	}

	@Override
	public void addSalarie(Salarie pSalarie) {
		// TODO Auto-generated method stub
		MongoDatabase databaseConnection = null;
		try {
			databaseConnection = daoFactory.getConnexionToDatabase();
			Gson gson = new Gson();
			MongoCollection<Document> collection = databaseConnection.getCollection(C_SALARIE);
	        Document document = Document.parse(gson.toJson(pSalarie));
	        collection.insertOne(document);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateSalarie(Salarie pSalarie, String pIdentifiantUnique) {
		// TODO Auto-generated method stub
		MongoDatabase databaseConnection = null;
		try {
			databaseConnection = daoFactory.getConnexionToDatabase();
			Gson gson = new Gson();
			MongoCollection<Document> salaries = databaseConnection.getCollection(C_SALARIE);
	        Document salarie = Document.parse(gson.toJson(pSalarie));
	        salaries.replaceOne(Filters.eq(IDENTIFIANT,pSalarie.getmSecureIdGenerated()), salarie);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public boolean salarieExists(String pIdentifiantUnique) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Salarie getSalarie(String pIdentifiantUnique) {
		// TODO Auto-generated method stub
		MongoDatabase databaseConnection = null;
		Salarie salarieBean = new Salarie();
		try {
			databaseConnection = daoFactory.getConnexionToDatabase();
			Gson gson = new Gson();
			MongoCollection<Document> salaries = databaseConnection.getCollection(C_SALARIE);
	        Document salarie = salaries.find(Filters.eq(IDENTIFIANT, pIdentifiantUnique)).first();
	        salarieBean = gson.fromJson(salarie.toJson(), Salarie.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return salarieBean;
	}

	@Override
	public ArrayList<Salarie> listSalarie() {
		// TODO Auto-generated method stub
		return null;
	}

}
