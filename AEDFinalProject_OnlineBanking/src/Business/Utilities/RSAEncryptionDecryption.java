/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utilities;

/**
 * * Simple RSA public key encryption algorithm implementation.
 * @author amitha.murali
 */

import java.math.BigInteger;
import java.security.SecureRandom;



 
public class RSAEncryptionDecryption {
  private BigInteger n, d, e;

  private int bitlen = 1024;

  /** Create an instance that can encrypt using someone else public key. */
  public RSAEncryptionDecryption(BigInteger newn, BigInteger newe) {
    n = newn;
    e = newe;
  }

  /** Create an instance that can both encrypt and decrypt. */
  public RSAEncryptionDecryption(int bits) {
    bitlen = bits;
    SecureRandom random = new SecureRandom();
    BigInteger p = new BigInteger(bitlen / 2, 100, random);
    BigInteger q = new BigInteger(bitlen / 2, 100, random);
    n = p.multiply(q);
    BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
        .subtract(BigInteger.ONE));
    e = new BigInteger("3");
    while (m.gcd(e).intValue() > 1) {
      e = e.add(new BigInteger("2"));
    }
    d = e.modInverse(m);
  }

  /** Encrypt the given plaintext message. */
  public synchronized String encrypt(String message) {
    return (new BigInteger(message.getBytes())).modPow(e, n).toString();
  }

  /** Encrypt the given plaintext message. */
  public synchronized BigInteger encrypt(BigInteger message) {
    return message.modPow(e, n);
  }

  /** Decrypt the given ciphertext message. */
  public synchronized String decrypt(String message) {
    return new String((new BigInteger(message)).modPow(d, n).toByteArray());
  }

  /** Decrypt the given ciphertext message. */
  public synchronized BigInteger decrypt(BigInteger message) {
    return message.modPow(d, n);
  }

  /** Generate a new public and private key set. */
  public synchronized void generateKeys() {
    SecureRandom random = new SecureRandom();
    BigInteger p = new BigInteger(bitlen / 2, 100, random);
    BigInteger q = new BigInteger(bitlen / 2, 100, random);
    n = p.multiply(q);
    BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
        .subtract(BigInteger.ONE));
    e = new BigInteger("3");
    while (m.gcd(e).intValue() > 1) {
      e = e.add(new BigInteger("2"));
    }
    d = e.modInverse(m);
  }

  /** Return the modulus. */
  public synchronized BigInteger getN() {
    return n;
  }

  /** Return the public key. */
  public synchronized BigInteger getE() {
    return e;
  }

  /** Trivial test program. */
  public void testProgram(String text) {
//    RSAEncryptionDecryption rsa = new RSAEncryptionDecryption(1024);


   // String text1 = "Yellow and Black Border Collies";
    System.out.println("Plaintext: " + text);
    BigInteger plaintext = new BigInteger(text.getBytes());

    BigInteger ciphertext = encrypt(plaintext);
    System.out.println("Ciphertext: " + ciphertext);
    plaintext = decrypt(ciphertext);

    String text2 = new String(plaintext.toByteArray());
    System.out.println("Plaintext: " + text2);
  }
}

