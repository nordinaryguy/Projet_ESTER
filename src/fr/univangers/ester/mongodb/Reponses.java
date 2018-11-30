package fr.univangers.ester.mongodb;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class Reponses extends Database {

	private static final String C_REPONSE = "C_REPONSE";

	public static final String IDENTIFIANT_SALARIE = "Identifiant salarie";
	public static final String IDENTIFIANT_QUESTIONNAIRE = "Identifiant questionnaire";
	public static final String REPONSES_QUESTIONS = "Reponses questions";
	public static final String IDENTIFIANT_QUESTION = "Identifiant question";
	public static final String QUESTION = "Question";
	public static final String REPONSE = "Reponse";
	
	public void addReponse(String identifiantSalarie, String identifiantQuestionnaire, List<Map<String, String>> reponsesQuestions) {
		MongoCollection<Document> reponses = db().getCollection(C_REPONSE);
		Document reponse = new Document(IDENTIFIANT_SALARIE, identifiantSalarie)
				.append(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire)
				.append(REPONSES_QUESTIONS, reponsesQuestions);
		reponses.insertOne(reponse);
	}
	
	public boolean existReponsesQuestions(String identifiantSalarie, String identifiantQuestionnaire) {
		MongoCollection<Document> reponses = db().getCollection(C_REPONSE);
	    FindIterable<Document> iterable = reponses.find(Filters.and(Filters.eq(IDENTIFIANT_SALARIE, identifiantSalarie), 
				Filters.eq(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire)));
		return iterable.first() != null;
	}
	
	public List<Map<String, String>> getReponsesQuestions(String identifiantSalarie, String identifiantQuestionnaire) {
		if(!existReponsesQuestions(identifiantSalarie, identifiantQuestionnaire)) {
			throw new IllegalArgumentException("N'existe pas.");	
		}
		MongoCollection<Document> reponses = db().getCollection(C_REPONSE);
		Document reponse = reponses.find(Filters.and(Filters.eq(IDENTIFIANT_SALARIE, identifiantSalarie), 
				Filters.eq(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire))).first();
		return (List<Map<String, String>>) reponse.get(REPONSES_QUESTIONS);
	}
	
	public int getPourcentageReponses(String identifiantQuestionnaire, String identifiantQuestion, String reponse) {
		int nombreTotal = 0;
		int nombreReponse = 0;
		MongoCollection<Document> reponses = db().getCollection(C_REPONSE);
		MongoCursor<Document> cursor = reponses.find(Filters.eq(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire)).iterator();
		while(cursor.hasNext()) {
			List<Map<String, String>> listReponse = (List<Map<String, String>>) cursor.next().get(REPONSES_QUESTIONS);
			for(Map<String, String> mapReponse : listReponse) {
				if(mapReponse.get(IDENTIFIANT_QUESTION).toString().equals(identifiantQuestion)) {
					if(mapReponse.get(REPONSE).toString().equals(reponse))
						nombreReponse++;
					nombreTotal++;
					break;
				}
			}
		}
		return nombreTotal == 0 ? 0 : nombreReponse / nombreTotal;
	}
	
}
