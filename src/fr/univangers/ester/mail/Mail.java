package fr.univangers.ester.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.univangers.ester.mdp.PwdGenerator;
import fr.univangers.ester.mongodb.Users;

/*******USE******************************************
To use it you must add to the database the email sender
,password , the host and port

to test I created a email
email : projet.ester@gmail.com
password : masterInformatique
host : smtp.gmail.com
port : 587

*****************************************************/


public class Mail {
	protected String aemailSender;
	protected String aemailMdp;
	protected String ahost;
	protected String aport;
	
	public Mail() {
		Users user=new Users();
		this.aemailSender=user.getServerMail();
		this.aemailMdp=user.getServerMailPass();
		this.ahost=user.getServerHost();
		this.aport=user.getServerPort();
	}
	

	private Session initializeSession() {
		//get a mail session
		Properties properties=new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host", this.ahost);
		properties.put("mail.smtp.port", this.aport);
	
		// creates a new session with an authenticator 
        Authenticator auth = new Authenticator() {
        	@Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(aemailSender,aemailMdp);
            }
        };
        
		Session session=Session.getDefaultInstance(properties,auth);
		session.setDebug(true);
		return session;
	}

	public boolean sendMail(String emailRecipient,String subject,String body,boolean bodyIsHTML) {
		Session session=initializeSession();
		// Create a message
		try {
			Message message = new MimeMessage(session);
			message.setSubject(subject);
			//set body email
			if(bodyIsHTML)
				message.setContent(body, "text/html");
			else
				message.setText(body);
			// Here we set the addresses
			Address fromAddress= new InternetAddress(aemailSender);
			Address toAddress= new InternetAddress(emailRecipient);
			message.setRecipient(Message.RecipientType.TO,toAddress);
			message.setFrom(fromAddress);
			
			//send email
			Transport.send(message);
			System.out.println("Mail successfully sent"); 
			return true;
		}catch(MessagingException mex) {
			mex.printStackTrace();
			return false;
		}
		
	}
	
	public String mdpProvisoireBodyText(String mdp,String urlLogin) {
		String message="<p><b>Bienvenue ,</b></p><br/>";
		message += "<p>Pour vote première connexion, </p>";
		message += "<pstyle=\"text-align:Center;\"><b>le mot de passe provisoire :" + mdp+"</b> </p><br/>";
		message += "<p>Afin de vous connectez <a href=\""+urlLogin+"\">Cliquez ici</a> </p> <br/>";
		message += "<p>Bien Cordialement,</p>"+
				   "<p>L'équipe ester </p>";
		return message;
	}
	
	public String mdpOublieBodyText(String url) {
		String message="<p><b>Bonjour ,</b></p><br/>";
		message += "<p>Vous avez demandé à réinitialiser votre mot de passe. Cliquez sur ce lien pour recevoir un nouveau mot de passe :  </p>";
		message += "<p><a href=\""+url+"\">cliquez ici</a> </p> <br/>";
		message += "<p>Bien Cordialement,</p>"+
				   "<p>L'équipe de ester </p>";
		return message;
	}
	
	public String getemailSender() {
		return aemailSender;
	}


	public void setemailSender(String aemailSender) {
		this.aemailSender = aemailSender;
	}


	public String getemailMdp() {
		return aemailMdp;
	}

	public void setemailMdp(String aemailMdp) {
		this.aemailMdp = aemailMdp;
	}

	
}
