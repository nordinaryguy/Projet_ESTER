package fr.univangers.ester.mail;

public class TestMail {

	public static void main(String[] args) {
		Mail mail = new Mail("sender@xxx.xxx","*****","recipient@xxxx.xxx","host","port");
		mail.sendMail("test Mot de passe provisoire",mail.mdpProvisoireBodyText("nom") , true);
	}

}
