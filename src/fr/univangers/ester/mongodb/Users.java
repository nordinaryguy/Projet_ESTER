package fr.univangers.ester.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Users {
/*
	private static final String SALARIES = "Salariés";
	private static final String SEXE = "Sexe";
	private static final String NUMERODEPARTEMENT = "Numéro de département";
	private static final String NOMDEPARTEMENT = "Nom de département";
	private static final String DATEDENAISSANCE = "Date de naissance";
	private static final String ENTREPRISES = "Entreprises";
	private static final String UTILISATEURS = "Utilisateurs";
	private static final String DEPARTEMENTS = "Départements";
	private static final String MOTDEPASSE = "Mot de passe";
	private static final String LISTEDESALARIES = "Liste de salariés";
	private static final String PREMIERECONNEXION = "Première connexion";
	private static final String REGION = "Region";
	
	public ObjectId addSalarie(String motDePasse, String sexe, Date dateDeNaissance, int numero, boolean premiereConnexion) {
		MongoCollection<Document> salaries = database.getCollection(SALARIES);
		Document salarie = new Document(MOTDEPASSE, motDePasse)
				.append(SEXE, sexe)
				.append(DATEDENAISSANCE, dateDeNaissance)
				.append(NUMERODEPARTEMENT, numero)
				.append(PREMIERECONNEXION, premiereConnexion);
		salaries.insertOne(salarie);
		return salarie.getObjectId("_id");
	}
	
	public void removeSalarie(ObjectId id) {
		MongoCollection<Document> entreprises = database.getCollection(SALARIES);
		entreprises.deleteOne(Filters.eq("_id", id));
	}
	
	public ObjectId addEntreprise(String motDePasse,  List<String> listeSalaries, boolean premiereConnexion) {
		MongoCollection<Document> entreprises = database.getCollection(ENTREPRISES);
		Document entreprise = new Document(MOTDEPASSE, motDePasse)
				.append(LISTEDESALARIES, listeSalaries)
				.append(PREMIERECONNEXION, premiereConnexion);
		entreprises.insertOne(entreprise);
		return entreprise.getObjectId("_id");
	}
	
	public ObjectId addUtilisateur(String motDePasse, List<String> listeSalaries, boolean premiereConnexion) {
		MongoCollection<Document> utilisateurs = database.getCollection(UTILISATEURS);
		Document utilisateur = new Document(MOTDEPASSE, motDePasse)
				.append(LISTEDESALARIES, listeSalaries)
				.append(PREMIERECONNEXION, premiereConnexion);
		utilisateurs.insertOne(utilisateur);
		return utilisateur.getObjectId("_id");
	}
	
	public ObjectId addDepartement(int numero, String nom, String region) {
		MongoCollection<Document> departements = database.getCollection(DEPARTEMENTS);
		Document departement = new Document(NUMERODEPARTEMENT, numero)
				.append(NOMDEPARTEMENT, nom)
				.append(REGION, region);
		departements.insertOne(departement);
		return departement.getObjectId("_id");
	}
	
	
	
	

	
	
	*/
	
	private static final String C_SALARIE = "C_SALARIE";
	private static final String C_ENTREPRISE = "C_ENTREPRISE";
	private static final String C_USER_ESTER = "C_USER_ESTER";
	
	private static final String IDENTIFIANT = "Identifiant";
	private static final String NAME = "Nom";
	private static final String FIRSTNAME = "Prénom";
	private static final String FIRSTCONNECTION = "Première connexion";
	private static final String PASSWORD = "Mot de passe";
	private static final String MAIL = "Mail";
	private static final String SALARIES = "Salariés";
	private static final String STATUS = "Statut";
	
	private static final String HOSTNAME = "localhost";
	private static final int PORT = 27017;
	private static final String DBNAME = "BDD_ESTER_DEV";
	
	private MongoClient client;
	private MongoDatabase database;
	
	public Users() {
		client =  MongoClients.create("mongodb://" + HOSTNAME + ":" + PORT);
		database = client.getDatabase(DBNAME);
	}
	
	public void addUserEster(String identifiant, String name, String firstName, String mail, String password, String status) {
		if(existUserEster(identifiant)) {
			throw new IllegalArgumentException("Identifiant déja ajouter");
		}
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
		Document user = new Document(IDENTIFIANT, identifiant)
				.append(NAME, name)
				.append(FIRSTNAME, firstName)
				.append(MAIL, mail)
				.append(FIRSTCONNECTION, false)
				.append(PASSWORD, password)
				.append(STATUS, status);	
		users.insertOne(user);
	}
	
	public void deleteUserEster(String identifiant) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
		users.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public void changePasswordUserEster(String identifant, String password) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
		users.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(PASSWORD, password)));
	}
	
	public void changeFirstConnectionUserEster(String identifant, boolean firstConnection) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
		users.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(FIRSTCONNECTION, firstConnection)));
	}
	
	public boolean existUserEster(String identifiant) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
	    FindIterable<Document> iterable = users.find(Filters.eq(IDENTIFIANT, identifiant));
		return iterable.first() != null;
	}
	
	public boolean connectUserEster(String identifiant, String password) {
		MongoCollection<Document> users = database.getCollection(C_USER_ESTER);
	    FindIterable<Document> iterable = users.find(Filters.and(Filters.eq(IDENTIFIANT, identifiant),
	    		Filters.eq(PASSWORD, password)));
		return iterable.first() != null;
	}
	
	public void addEntreprise(String identifiant, String name, String password) {
		if(existEntreprise(identifiant)) {
			throw new IllegalArgumentException("Identifiant déja ajouter");
		}
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		Document entreprise = new Document(IDENTIFIANT, identifiant)
				.append(NAME, name)
				.append(FIRSTCONNECTION, false)
				.append(PASSWORD, password)
				.append(SALARIES, new ArrayList<Document>());	
		entreprises.insertOne(entreprise);
	}
	
	public void deleteEntreprise(String identifiant) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.deleteOne(Filters.eq(IDENTIFIANT, identifiant));
	}
	
	public void changePasswordEntreprise(String identifant, String password) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(PASSWORD, password)));
	}
	
	public void changeFirstConnectionEntreprise(String identifant, boolean firstConnection) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifant),
				new Document("$set", new Document(FIRSTCONNECTION, firstConnection)));
	}
	
	public boolean existEntreprise(String identifiant) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
	    FindIterable<Document> iterable = entreprises.find(Filters.eq(IDENTIFIANT, identifiant));
		return iterable.first() != null;
	}
	
	public boolean connectEntreprise(String identifiant, String password) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
	    FindIterable<Document> iterable = entreprises.find(Filters.and(Filters.eq(IDENTIFIANT, identifiant),
	    		Filters.eq(PASSWORD, password)));
		return iterable.first() != null;
	}
	
	public void pushSalarieIntoEntreprise(String identifiantEntreprise, String identifiantSalarie) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiantEntreprise),
				new Document("$push", new Document(SALARIES, identifiantSalarie)));
	}
	
	public List<String> getSalariesEntreprise(String identifiant) {
		List<String> salaries = new ArrayList<>();
		if(!existEntreprise(identifiant)) {
			throw new IllegalArgumentException("L'entreprise n'existe pas.");	
		}
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
	    Document entreprise = entreprises.find(Filters.eq(IDENTIFIANT, identifiant)).first();
	    if(entreprise.get(SALARIES) instanceof List<?>) {
		    List<?> objects = (List<?>)entreprise.get(SALARIES);
	    	for(Object object : objects) {
	    	    if (object instanceof String) {
	    	    	salaries.add((String) object);
	    	    }
	    	}
	    }
	    return salaries;
	}
	
	public void pullSalarieIntoEntreprise(String identifiantEntreprise, String identifiantSalarie) {
		MongoCollection<Document> entreprises = database.getCollection(C_ENTREPRISE);
		entreprises.findOneAndUpdate(Filters.eq(IDENTIFIANT, identifiantEntreprise),
				new Document("$pull", new Document(SALARIES, identifiantSalarie)));
	}
	
	
}
