import java.math.BigInteger;

public class RSA {
    public static void main(String[] args) {
        // Step 1: Initialize variables
        int p = 7, q = 11, n = p * q, phi = (p - 1) * (q - 1);
        int e = findE(phi); // Public key
        int d = findD(e, phi); // Private key
        int plainText = 9;

        System.out.println("Public key (e): " + e);
        System.out.println("Private key (d): " + d);
        System.out.println("Plain text: " + plainText);

        // Step 2: Encrypt the message
        BigInteger N = BigInteger.valueOf(n);
        BigInteger encrypted = BigInteger.valueOf(plainText).pow(e).mod(N);
        System.out.println("Encrypted message: " + encrypted);

        // Step 3: Decrypt the message
        BigInteger decrypted = encrypted.pow(d).mod(N);
        System.out.println("Decrypted message: " + decrypted);
    }

    // Function to find e (public key)
    static int findE(int phi) {
        for (int e = 2; e < phi; e++) {
            if (gcd(e, phi) == 1) {
                return e;
            }
        }
        return 2; // Default
    }

    // Function to find d (private key)
    static int findD(int e, int phi) {
        for (int i = 1;; i++) {
            if ((1 + i * phi) % e == 0) {
                return (1 + i * phi) / e;
            }
        }
    }

    // Function to compute GCD
    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
