package fr.univangers.ester.mdp;

import java.security.SecureRandom;

public class PwdGenerator {
	//définition du jeu de caractère
	protected static final  String SYMBOLS = "^$*.[]{}()?-\"!@#%&/\\,><:;|_~"; //(29)
    protected static final  String LOWERCASE ="abcdefghijkmnopqrstuvwxyz"; //alphabet miniscule sans l (25)
    protected static final String UPPERCASE = "ABCDEFGHIJKLMNPQRSTUVWXYZ"; // alhabet majuscule sauf O  (25)
    protected static final String NUMBERS ="23456789"; //hormis 0 et  1 (8)
    protected static final String ALL_CHARS = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz23456789^$*.[]{}()?-\\\"!@#%&/\\\\,><:;|_~";
    
    private static SecureRandom mRand;
    private static int mPwdLength;
    
    public PwdGenerator(int pPwdLength) {
    	mRand=new SecureRandom();
    	mPwdLength=pPwdLength;
    }
    
    
    public static String generatePassword() {
    	if(mPwdLength < 6) {
    		System.out.println("Unsecure Length !!!");
    	}
    	char[] password=new char[mPwdLength];
    	//placer les caractères requis : 5 caractères alphanumeric  et un sympbole 
    		//au moins une majuscule 
    		password[0]=UPPERCASE.charAt(mRand.nextInt(UPPERCASE.length()));
    		//au moins une miniscule
    		password[1]=LOWERCASE.charAt(mRand.nextInt(LOWERCASE.length()));
    		//au moins un chiffre
    		password[2]=NUMBERS.charAt(mRand.nextInt(NUMBERS.length()));
    		//au moins un symbole
    		password[3]=SYMBOLS.charAt(mRand.nextInt(SYMBOLS.length()));
    	
    		
    	//completer le reste du mot de passe avec tous les caractères si 
    	for(int i=3;i<mPwdLength;i++) {
    		password[i]=ALL_CHARS.charAt(mRand.nextInt(ALL_CHARS.length()));
    	}
    	
    	//permuter le mot de passe et retourner
    	
    	return shuffle(password);
    }
    

    private static String shuffle(char[] characters) {
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int)(Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
	
}
