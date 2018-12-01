package fr.univangers.ester.mongodb;

import java.util.Map;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class ReponsesDB extends Database {

	private static final String C_REPONSE = "C_REPONSE";

	public static final String IDENTIFIANT_SALARIE = "Identifiant salarie";
	public static final String IDENTIFIANT_QUESTIONNAIRE = "Identifiant questionnaire";
	public static final String REPONSES = "Reponses";
	
	public void addReponse(String identifiantSalarie, String identifiantQuestionnaire, Map<String, String> reponses) {
		MongoCollection<Document> cReponses = db().getCollection(C_REPONSE);
		Document reponse = new Document(IDENTIFIANT_SALARIE, identifiantSalarie)
				.append(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire)
				.append(REPONSES, reponses);
		cReponses.insertOne(reponse);
	}
	
	public boolean existReponse(String identifiantSalarie, String identifiantQuestionnaire) {
		MongoCollection<Document> cReponses = db().getCollection(C_REPONSE);
	    FindIterable<Document> iterable = cReponses.find(Filters.and(Filters.eq(IDENTIFIANT_SALARIE, identifiantSalarie), 
				Filters.eq(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire)));
		return iterable.first() != null;
	}
	
	public Map<String, String> getReponses(String identifiantSalarie, String identifiantQuestionnaire) {
		if(!existReponse(identifiantSalarie, identifiantQuestionnaire)) {
			throw new IllegalArgumentException("N'existe pas.");	
		}
		MongoCollection<Document> cReponses = db().getCollection(C_REPONSE);
		Document reponse = cReponses.find(Filters.and(Filters.eq(IDENTIFIANT_SALARIE, identifiantSalarie), 
				Filters.eq(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire))).first();
		return (Map<String, String>) reponse.get(REPONSES);
	}
	
	public int getPourcentageReponses(String identifiantQuestionnaire, String identifiantQuestion, String reponse) {
		double nombreTotal = 0;
		double nombreReponse = 0;
		MongoCollection<Document> cReponses = db().getCollection(C_REPONSE);
		MongoCursor<Document> cursor = cReponses.find(Filters.eq(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire)).iterator();
		while(cursor.hasNext()) {
			Map<String, String> reponses = (Map<String, String>) cursor.next().get(REPONSES);
			if(reponses.containsKey(identifiantQuestion)) {
				if(reponses.get(identifiantQuestion).equals(reponse)) {
					nombreReponse++;
				}
				nombreTotal++;
			}
		}
		return nombreTotal == 0 ? 0 : (int)(nombreReponse / nombreTotal * 100);
	}
	
}
