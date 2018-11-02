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

public class Mail {
	protected String aemailSender;
	protected String aemailMdp;
	protected String aemailRecipient;
	protected PwdGenerator pwdGenerator;
	protected String ahost;
	protected String aport;
	
	public Mail(String emailSender,String emailMdp,String emailRecipient,String host,String port){
		this.aemailSender=emailSender;
		this.aemailMdp=emailMdp;
		this.aemailRecipient=emailRecipient;
		this.ahost=host;
		this.aport=port;
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

	public boolean sendMail(String subject,String body,boolean bodyIsHTML) {
		Session session=this.initializeSession();
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
			Address fromAddress= new InternetAddress(this.aemailSender);
			Address toAddress= new InternetAddress(this.aemailRecipient);
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
	
	public String mdpProvisoireBodyText(String name) {
		String message="<p><b>Bienvenue "+name+",</b></p><br/>";
		message += "<p>Vous avez fait une demande de création de profil sur <a href=>lien vers page d'acceuil</a> </p>";
		message += "<p>Afin de vous connectez <a href=>Cliquez ici</a> </p> <br/>";
		message += "<pstyle=\"text-align:Center;\"><b>mot de passe provisoire :" + PwdGenerator.generatePassword()+"</b> </p><br/>";
		message += "<p>Bien Cordialement,</p>"+
				   "<p>L'équipe de <a href=>lien vers page d'acceuil</a> </p>";
		return message;
	}
	
	public String mdpOublieBodyText(String name,String url) {
		String message="<p><b>Bonjour "+name+",</b></p><br/>";
		message += "<p>Vous avez demandé à réinitialiser votre mot de passe. Cliquez sur ce lien pour recevoir un nouveau mot de passe :  </p>";
		message += "<p><a href=\""+url+"\">cliquez ici</a> </p> <br/>";
		message += "<p>Bien Cordialement,</p>"+
				   "<p>L'équipe de <a href=>lien vers page d'acceuil</a> </p>";
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


	public String getemailRecipient() {
		return aemailRecipient;
	}


	public void setemailRecipient(String aemailRecipient) {
		this.aemailRecipient = aemailRecipient;
	}
	
}
