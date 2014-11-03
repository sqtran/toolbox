package jasypt;

import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility for encrypting/decrypting obfuscated passwords
 */
public class TextEncryptorUtility {

    private static Logger logger = LoggerFactory.getLogger(TextEncryptorUtility.class);

    private static BasicTextEncryptor textEncryptor = init();

    private static final String KEY = "EVAAS_KEY";

    private static final String DEFAULT_PW = "defaultEncryptionPW";

    private static BasicTextEncryptor init() {
        BasicTextEncryptor bte = new BasicTextEncryptor();
        if (System.getenv(KEY) == null || "".equals(System.getenv(KEY))) {
            logger.error(String.format("environment variable %s not found", KEY));
            bte.setPassword(DEFAULT_PW);
        } else {
            bte.setPassword(System.getenv(KEY));
        }
        return bte;
    }

    /**
     * Called to encrypt a message
     * @param plainText The text to encrypt
     * @return The text in encrypted form
     */
    public static String encrypt(String plainText) {
        return textEncryptor.encrypt(plainText);
    }

    /**
     * Called to decrypt a message
     * @param encryptedText The encrypted text to decrypt
     * @return The decrypted text
     */
    public static String decrypt(String encryptedText) {
        return textEncryptor.decrypt(encryptedText);
    }

    /**
     * Just pass in an argument to see it encrypted and decrypted. It will throw an exception when it attempts to decrypt a value that wasn't properly
     * encrypted. You can ignore this scenario as you were probably trying to encrypt a value and don't care about what it looks like decrypted.
     * 
     * @param args The one and only argument should be the value that needs to be encrypted/decrypted
     */
    public static void main(String ... args) {
        System.out.println(String.format("Encrypted %s as %s", args[0], encrypt(args[0])));
        System.out.println(String.format("Decrypted %s as %s", args[0], decrypt(args[0])));
    }
}