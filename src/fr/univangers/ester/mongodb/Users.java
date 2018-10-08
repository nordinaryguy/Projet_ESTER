package fr.univangers.ester.mongodb;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Users {
	private static final String HOSTNAME = "localhost";
	private static final int PORT = 27017;
	private static final String DBNAME = "Users";

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
	
	private MongoClient client;
	private MongoDatabase database;
	
	public Users() {
		client =  MongoClients.create("mongodb://" + HOSTNAME + ":" + PORT);
		database = client.getDatabase(DBNAME);
	}
	
	public ObjectId addSalarie(String motDePasse, String sexe, Date dateDeNaissance, int numero, boolean premiereConnexion) {
		MongoCollection<Document> entreprises = database.getCollection(SALARIES);
		Document entreprise = new Document(MOTDEPASSE, motDePasse)
				.append(SEXE, sexe)
				.append(DATEDENAISSANCE, dateDeNaissance)
				.append(NUMERODEPARTEMENT, numero)
				.append(PREMIERECONNEXION, premiereConnexion);
		entreprises.insertOne(entreprise);
		return entreprise.getObjectId("_id");
	}
	
	public void removeSalarie(ObjectId id) {
		MongoCollection<Document> entreprises = database.getCollection(SALARIES);
		entreprises.deleteOne(Filters.eq("_id", id));
	}
	
	public void addEntreprise(String motDePasse,  List<String> listeSalaries, boolean premiereConnexion) {
		MongoCollection<Document> entreprises = database.getCollection(ENTREPRISES);
		Document entreprise = new Document(MOTDEPASSE, motDePasse)
				.append(LISTEDESALARIES, listeSalaries)
				.append(PREMIERECONNEXION, premiereConnexion);
		entreprises.insertOne(entreprise);
	}
	
	public void addUtilisateur(String motDePasse, List<String> listeSalaries, boolean premiereConnexion) {
		MongoCollection<Document> utilisateurs = database.getCollection(UTILISATEURS);
		Document utilisateur = new Document(MOTDEPASSE, motDePasse)
				.append(LISTEDESALARIES, listeSalaries)
				.append(PREMIERECONNEXION, premiereConnexion);
		utilisateurs.insertOne(utilisateur);
	}
	
	public void addDepartement(int numero, String nom, String region) {
		MongoCollection<Document> departements = database.getCollection(DEPARTEMENTS);
		Document departement = new Document(NUMERODEPARTEMENT, numero)
				.append(NOMDEPARTEMENT, nom)
				.append(REGION, region);
		departements.insertOne(departement);
	}
}
