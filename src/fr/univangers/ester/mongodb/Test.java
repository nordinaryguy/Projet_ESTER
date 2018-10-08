package fr.univangers.ester.mongodb;

import java.util.Date;

import org.bson.types.ObjectId;

public class Test {

	public static void main(String[] args) {
		Users users = new Users();
		ObjectId id1 = users.addSalarie("mot de passe", "Femme", new Date(1989,5,20), 555, true);
		users.removeSalarie(id1);
	}

}
