package CryptoDemo;

public class Main {
    public static void main(String[] args) throws Exception {
        Alice alice = new Alice();
        Bob bob = new Bob();

        // ===== SYMMETRIC ENCRYPTION (AES-256) =====
        System.out.println("\n=== SYMMETRIC ENCRYPTION (AES-256-GCM) ===");
        String message = "Hello Bob, this is Alice.";
        byte[] aesKey = CryptoUtils.generateAESKey();

        byte[] encrypted = CryptoUtils.encryptAES(message, aesKey);
        String decrypted = CryptoUtils.decryptAES(encrypted, aesKey);
        System.out.println("Decrypted Message: " + decrypted);

        // ===== ASYMMETRIC ENCRYPTION (RSA-2048) =====
        System.out.println("\n=== ASYMMETRIC ENCRYPTION (RSA-2048) ===");
        byte[] encryptedRSA = CryptoUtils.encryptRSA(message.getBytes(), bob.getPublicKey());
        byte[] decryptedRSA = CryptoUtils.decryptRSA(encryptedRSA, bob.getPrivateKey());
        System.out.println("Decrypted RSA Message: " + new String(decryptedRSA));

        // ===== DIGITAL SIGNATURE (RSA-2048) =====
        System.out.println("\n=== DIGITAL SIGNATURE (SHA256withRSA) ===");
        byte[] signature = CryptoUtils.signMessage(message.getBytes(), alice.getPrivateKey());
        boolean isVerified = CryptoUtils.verifySignature(message.getBytes(), signature, alice.getPublicKey());
        System.out.println("Signature Valid: " + isVerified);
    }
}