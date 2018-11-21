package fr.univangers.ester.mongodb;

public class Test {

	public static void main(String[] args) {
		Users users = new Users();
		users.addEntreprise("id66", "AA", "mdp");
		users.addEntreprise("id55", "TT", "mdp");
		users.addSalarie("id00", 00, "00", "male", 1999, "vendée", "medical", "aide-soignant", "chu angers", "userEster");
	}

}
