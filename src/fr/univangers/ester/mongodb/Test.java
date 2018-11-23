package fr.univangers.ester.mongodb;

public class Test {

	public static void main(String[] args) {
		Users users = new Users();

		/*
		users.addSalarie("s1", 1, null, "homme", 1992, "49", null, null, null, null);
		users.addSalarie("s2", 2, null, "homme", 1985, "49", null, null, null, null);
		*/
		System.out.println(users.existSalarie("s1"));
		System.out.println(users.connectSalarie("s1", null));
		System.out.println(users.existEntreprise("id66"));
		System.out.println(users.connectEntreprise("id66", "mdp"));
		
		
		users.addEntreprise("e1", "Marc", "pass");
		users.addEntreprise("id66", "AA", "mdp");
		users.addEntreprise("id55", "TT", "mdp");
		users.addSalarie("id00", 00, "00", "male", 1999, "vendée", "medical", "aide-soignant", "chu angers", "userEster");
	}

}
