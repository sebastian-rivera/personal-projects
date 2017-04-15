package com.ellipticalcode.util;

/**
 * Created by Sebastian Rivera on 1/6/2017.
 */
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.KeyStore;

public class Encryption
{
    //private static final Resource encryptionPropertiesFile = new ClassPathResource("encryption.properties");
    private static final Resource encryptionKeyFile = new ClassPathResource("crypto.jck");

    public static String encrypt(String strToEncrypt)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            final SecretKeySpec secretKey = new SecretKeySpec(getEncodedKey(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            final String encryptedString = java.util.Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
            return encryptedString;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String strToDecrypt)
    {
        if(strToDecrypt == null)
            return null;

        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            final SecretKeySpec secretKey = new SecretKeySpec(getEncodedKey(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final String decryptedString = new String(cipher.doFinal(java.util.Base64.getDecoder().decode(strToDecrypt)));
            return decryptedString;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;

        }
    }

    public static byte[] getEncodedKey() {

        try {

            //Properties encryptionProperties = new Properties();
            //encryptionProperties.load(encryptionPropertiesFile.getInputStream());
            String keystorePassword = "SrVaRcH2018CrOnO";
            String keyAlias = "seba";
            String keyPassword = "SeBaKeYmAsTeR2018CrOnO";

            KeyStore keyStore = KeyStore.getInstance("JCEKS");
            keyStore.load(encryptionKeyFile.getInputStream(), keystorePassword.toCharArray());
            Key key = keyStore.getKey(keyAlias, keyPassword.toCharArray());

            return key.getEncoded();
        } catch(Exception e) {

            e.printStackTrace();
            return null;
        }

    }

}

