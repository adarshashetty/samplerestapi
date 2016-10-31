package com.flebie.classes;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;

public class GenerateKeys {
	private String ALGO = "AES";
	private String keyString= "TheBestSecretKey";
    private byte[] keyValue = keyString.getBytes();
    
    public void shuffle()
    {
    	
    	List<Character> l = new ArrayList<Character>();
    	for(char c :  keyString.toCharArray()) //for each char of the word selectionned, put it in a list
    	    l.add(c); 
    	Collections.shuffle(l); //shuffle the list

    	StringBuilder sb = new StringBuilder(); //now rebuild the word
    	for(char c : l)
    	  sb.append(c);

    	keyString = sb.toString();
    }

    public void setKeyValue(String keyString) {
		this.keyValue = keyString.getBytes();
	}
    public byte[] getKeyValue() {
		return keyValue;
	}
public String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
}

}
