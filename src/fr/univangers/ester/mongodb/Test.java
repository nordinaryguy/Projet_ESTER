package fr.univangers.ester.mongodb;

public class Test {

	public static void main(String[] args) {
		Users users = new Users();
		users.deleteEntreprise("id66");
		users.deleteEntreprise("id55");
		users.addEntreprise("id66", "AA", false, "mdp");
		users.addEntreprise("id55", "TT", false, "mdp");
		users.pushSalarieIntoEntreprise("id55", "id3");
		users.pushSalarieIntoEntreprise("id55", "id4");
		for(String salarie : users.getSalariesEntreprise("id55")) {
			System.out.println(salarie);
		}
		users.pullSalarieIntoEntreprise("id55","id4");
		users.changePasswordEntreprise("id55", "mpd2");
		for(String salarie : users.getSalariesEntreprise("id55")) {
			System.out.println(salarie);
		}
		System.out.println(users.connectEntreprise("id0", "mdp"));
		System.out.println(users.connectEntreprise("id0", "mdpf"));
	}

}
