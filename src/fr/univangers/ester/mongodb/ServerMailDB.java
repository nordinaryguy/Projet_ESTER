package fr.univangers.ester.mongodb;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class ServerMailDB extends Database {

	private static final String C_SERVER_MAIL="C_SERVER_MAIL";

	private static final String PASSWORD = "Mot de passe";
	private static final String MAIL = "Mail";
	private static final String HOST="Host";
	private static final String PORTSERVERMAIL="PortServerMail";
	
	public boolean serverMailEmpty() {
		MongoCollection<Document> mailInfo = db().getCollection(C_SERVER_MAIL);
		return mailInfo.find().first() == null;
	}
	
	public void addDefautServer() {
		if(serverMailEmpty()) {
			MongoCollection<Document> mailInfo= db().getCollection(C_SERVER_MAIL);
			Document mailServer = new Document(MAIL,"projet.ester@gmail.com")
					.append(PASSWORD,"masterInformatique")
					.append(HOST,"smtp.gmail.com")
					.append(PORTSERVERMAIL,"587");
			mailInfo.insertOne(mailServer);
		}
	}
	
	public void addServerMail(String mail,String password,String host,String port) {
		deleteServerMail();
		MongoCollection<Document> mailInfo= db().getCollection(C_SERVER_MAIL);
		Document mailServer = new Document(MAIL,mail)
				.append(PASSWORD,cryptPassword(password))
				.append(HOST,host)
				.append(PORTSERVERMAIL,port);
		mailInfo.insertOne(mailServer);
	}
	
	public void deleteServerMail() {
		if(!serverMailEmpty()) {
			MongoCollection<Document> mailInfo = db().getCollection(C_SERVER_MAIL);
			mailInfo.drop();
		}
	}
	
	public Document getMailServerDocument() {
		MongoCollection<Document> mailServer = db().getCollection(C_SERVER_MAIL);
	    return mailServer.find().first();
	}
	
	public String getServerMail() {
		return (String) getMailServerDocument().get(MAIL);
	}
	
	public String getServerMailPass() {
		return (String) getMailServerDocument().get(PASSWORD);
	}
	
	public String getServerHost() {
		return (String) getMailServerDocument().get(HOST);
	}
	
	public String getServerPort() {
		return (String) getMailServerDocument().get(PORTSERVERMAIL);
	}
}
