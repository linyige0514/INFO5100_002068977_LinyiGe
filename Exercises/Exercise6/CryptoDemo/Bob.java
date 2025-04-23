package CryptoDemo;

import java.security.*;

public class Bob {
    private final KeyPair keyPair;

    public Bob() throws NoSuchAlgorithmException {
        this.keyPair = CryptoUtils.generateRSAKeyPair();
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }
}
