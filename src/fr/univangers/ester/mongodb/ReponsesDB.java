package fr.univangers.ester.mongodb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	public List<String> getListSalaire(String identifiantQuestionnaire) {
		List<String> identifiantSalaries = new ArrayList<>();
		MongoCollection<Document> cReponses = db().getCollection(C_REPONSE);
	    MongoCursor<Document> cursor = cReponses.find(Filters.eq(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire)).iterator();
	    while(cursor.hasNext())
	    	identifiantSalaries.add(cursor.next().getString(IDENTIFIANT_SALARIE));
	    return identifiantSalaries;
	}
	
	public Map<String, String> getReponses(String identifiantSalarie, String identifiantQuestionnaire) {
		if(!existReponse(identifiantSalarie, identifiantQuestionnaire)) {
			throw new IllegalArgumentException("N'existe pas.");	
		}
		MongoCollection<Document> cReponses = db().getCollection(C_REPONSE);
		Document reponse = cReponses.find(Filters.and(Filters.eq(IDENTIFIANT_SALARIE, identifiantSalarie), 
				Filters.eq(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire))).first();
		Map<?, ?> tempReponses = (Map<?, ?>) reponse.get(REPONSES);
		Map<String, String> reponses = new HashMap<>(tempReponses.size());
		for(Map.Entry<?, ?> entry : tempReponses.entrySet()){
			reponses.put((String)entry.getKey(), (String)entry.getValue()); 
	    }
		return  reponses;
	}
	
	public int getPourcentageReponses(String identifiantQuestionnaire, String identifiantQuestion, String reponse) {
		double nombreTotal = 0;
		double nombreReponse = 0;
		MongoCollection<Document> cReponses = db().getCollection(C_REPONSE);
		MongoCursor<Document> cursor = cReponses.find(Filters.eq(IDENTIFIANT_QUESTIONNAIRE, identifiantQuestionnaire)).iterator();
		while(cursor.hasNext()) {
			Map<?, ?> reponses = (Map<?, ?>) cursor.next().get(REPONSES);
			if(reponses.containsKey(identifiantQuestion)) {
				if(reponses.get(identifiantQuestion).toString().equals(reponse)) {
					nombreReponse++;
				}
				nombreTotal++;
			}
		}
		return nombreTotal == 0 ? 0 : (int)(nombreReponse / nombreTotal * 100);
	}
	
}
