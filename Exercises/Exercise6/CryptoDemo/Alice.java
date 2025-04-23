package CryptoDemo;

import java.security.*;

public class Alice {
    private final KeyPair keyPair;

    public Alice() throws NoSuchAlgorithmException {
        this.keyPair = CryptoUtils.generateRSAKeyPair();
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }
}
