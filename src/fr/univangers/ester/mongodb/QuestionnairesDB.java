package fr.univangers.ester.mongodb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class QuestionnairesDB extends Database {

	private static final String C_QUESTIONNAIRE = "C_QUESTIONNAIRE";

	private static final String NAME = "Nom";
	private static final String HTML = "Html";
	private static final String IDENTIFIANT = "Identifiant";
	private static final String IDENTIFIANT_ESTER = "Identifiant utilisateur ESTER";
	private static final String DATE_SUBMISSION = "Date de soumission";
	private static final String ERROR_NO_EXIST = "Le questionnaire n'existe pas.";
	
	public void addQuestionnaire(String name, String identifiant, String html, String identifiantEster) {
		MongoCollection<Document> questionnaires = db().getCollection(C_QUESTIONNAIRE);
		Document questionnaire = new Document(NAME, name)
				.append(IDENTIFIANT, identifiant)
				.append(HTML, html)
				.append(IDENTIFIANT_ESTER, identifiantEster)
				.append(DATE_SUBMISSION, new Date());
		questionnaires.insertOne(questionnaire);
	}
	
	public boolean existQuestionnaire(String identifiant) {
		MongoCollection<Document> questionnaires = db().getCollection(C_QUESTIONNAIRE);
	    FindIterable<Document> iterable = questionnaires.find(Filters.eq(IDENTIFIANT, identifiant));
		return iterable.first() != null;
	}
	
	public String getHTMLQuestionnaire(String identifiant) {
		if(!existQuestionnaire(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> questionnaires = db().getCollection(C_QUESTIONNAIRE);
		Document questionnaire = questionnaires.find(Filters.eq(IDENTIFIANT, identifiant)).first();
		return questionnaire.getString(HTML);
	}
	
	public String getName(String identifiant) {
		if(!existQuestionnaire(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> questionnaires = db().getCollection(C_QUESTIONNAIRE);
		Document questionnaire = questionnaires.find(Filters.eq(IDENTIFIANT, identifiant)).first();
		return questionnaire.getString(NAME);
	}
	
	public Date getDateSubmission(String identifiant) {
		if(!existQuestionnaire(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> questionnaires = db().getCollection(C_QUESTIONNAIRE);
		Document questionnaire = questionnaires.find(Filters.eq(IDENTIFIANT, identifiant)).first();
		return questionnaire.getDate(DATE_SUBMISSION);
	}
	
	public String getIdentifiantEster(String identifiant) {
		if(!existQuestionnaire(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);		
		}
		MongoCollection<Document> questionnaires = db().getCollection(C_QUESTIONNAIRE);
		Document questionnaire = questionnaires.find(Filters.eq(IDENTIFIANT, identifiant)).first();
		return questionnaire.getString(IDENTIFIANT_ESTER);
	}
	
	public void deleteQuestionnaire(String identifiant) {
		if(!existQuestionnaire(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);		
		}
		MongoCollection<Document> questionnaires = db().getCollection(C_QUESTIONNAIRE);
		questionnaires.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public void changeHTMLQuestionnaire(String identifiant, String html) {
		if(!existQuestionnaire(identifiant)) {
			throw new IllegalArgumentException(ERROR_NO_EXIST);	
		}
		MongoCollection<Document> questionnaires = db().getCollection(C_QUESTIONNAIRE);
		questionnaires.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiant),
				new Document("$set", new Document(HTML, html)));
	}
	
	public List<String> getIdentifiantQuestionnaires() {
		List<String> identifiants = new ArrayList<>();
		MongoCollection<Document> questionnaires = db().getCollection(C_QUESTIONNAIRE);
		MongoCursor<Document> cursor = questionnaires.find().iterator();
	    while(cursor.hasNext()) {
	    	Object identifiant = cursor.next().get(IDENTIFIANT);
	    	if(identifiant != null)
	    		identifiants.add(identifiant.toString());
	    }
	    return identifiants;
	}
	
}
