package sherlock.auth.server;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

import static junit.framework.TestCase.assertNotNull;

public class KeystoreTest {

    @Test
    public void keypair() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(SherlochAuthServer.KEYSTORE_JKS), "letmein".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(SherlochAuthServer.KEY);
        assertNotNull(keyPair);
    }
}
