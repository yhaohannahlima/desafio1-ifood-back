package br.com.foodtrack.tracking.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class TrackingCrypto {
	public static String encriptar(String original) throws Exception {
		
		String strMinhaChave = "123456789 123456789 123456789 12"; 
		Key minhaChave = new SecretKeySpec(strMinhaChave.getBytes(), "AES");
		
		Cipher cipher = Cipher.getInstance("AES");
		
		cipher.init(Cipher.ENCRYPT_MODE, minhaChave);
		
		cipher.update(original.getBytes());
				
		String originalCripto = new String(cipher.doFinal(), "UTF-8");				
		byte[] teste = originalCripto.getBytes();
		
		StringBuilder cryptoHex = new StringBuilder();
		for (byte b: teste) {
			cryptoHex.append(Integer.toHexString(b));
		}
		
		return cryptoHex.toString();
	}
}
