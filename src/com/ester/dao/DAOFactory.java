package com.ester.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DAOFactory {

	private static final String FICHIER_PROPERTIES = "/com/ester/dao/dao.properties";
	private static final String PROPERTY_SERVER    = "SERVER";
	private static final String PROPERTY_PORT      = "PORT";
	private static final String PROPERTY_DBNAME    = "DBNAME";

	private String server;
	private String port;
	private String dbname;
	private MongoClient client;
	private MongoDatabase database;

	DAOFactory( String pServer, String pPort, String pDbname ) {
		this.server = pServer;
		this.port = pPort;
		this.dbname = pDbname;
	}

	public static DAOFactory getInstance() throws DAOConfigurationException {
		Properties properties = new Properties();
		String server;
		String port;
		String dbname;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

		if ( fichierProperties == null ) {
			throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
		}

		try {
			properties.load( fichierProperties );
			server = properties.getProperty( PROPERTY_SERVER);
			port = properties.getProperty( PROPERTY_PORT );
			dbname = properties.getProperty( PROPERTY_DBNAME );
		} catch ( IOException e ) {
			throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
		}

		DAOFactory instance = new DAOFactory( server, port, dbname );
		return instance;
	}


	// Retourne la connexion vers la base de données mongodb en utilisant les informations spécifiées dans le fichier dao.properties
	MongoDatabase getConnexionToDatabase() {
		client =  MongoClients.create("mongodb://" + server + ":" + port);
		database = client.getDatabase(dbname);

		return database;
	}

	/*
	 * Méthodes de récupération de l'implémentation des différents DAO 
	 */
	public EsterUserDAO getUserEsterDao() {
		return new EsterUserDAOImpl( this );
	}
}
