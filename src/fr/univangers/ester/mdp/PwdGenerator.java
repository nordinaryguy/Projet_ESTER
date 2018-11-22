package fr.univangers.ester.mdp;

import java.security.SecureRandom;

public class PwdGenerator {
	//définition du jeu de caractère
	protected static final  String SYMBOLS = "^$*.[]{}()?-\"!@#%&/\\,><:;|_~"; //(29)
    protected static final  String LOWERCASE ="abcdefghijkmnopqrstuvwxyz"; //alphabet miniscule sans l (25)
    protected static final String UPPERCASE = "ABCDEFGHIJKLMNPQRSTUVWXYZ"; // alhabet majuscule sauf O  (25)
    protected static final String NUMBERS ="23456789"; //hormis 0 et  1 (8)
    protected static final String ALL_CHARS = "ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz23456789^$*.[]{}()?-\\\"!@#%&/\\\\,><:;|_~";
    
    private static SecureRandom mRand=new SecureRandom();
    private static int mPwdLength=8;
    private static int mCodeLength=5;
    
    public PwdGenerator() {
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
    
    public static String generateCode() {
    	if(mCodeLength < 5) {
    		System.out.println("Unsecure Length !!!");
    	}
    	char[] id=new char[mCodeLength];
    	int randIndex;
    	String idShuffled;
    	//augmenter la longueur de l'id si limite des possibilités atteintes 
    			/*****  TODO  ********/ 
	    //id constitué de lettres en majuscule et chiffres sans doublons 
	    StringBuilder upperNumeric=new StringBuilder(UPPERCASE.concat(NUMBERS));
	    for(int i=0;i<mCodeLength;i++) {
	    	randIndex=mRand.nextInt(upperNumeric.length());
	    	id[i]=upperNumeric.charAt(randIndex);
	    	upperNumeric.deleteCharAt(randIndex);
	    }
	    //permuter l'id 
	    idShuffled =shuffle(id);
	    //check if it already exists in DataBase
	    	/*****  to do  ********/ 
    	return idShuffled;
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
