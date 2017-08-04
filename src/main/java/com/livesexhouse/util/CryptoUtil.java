package com.livesexhouse.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {

	/**
	 * Secret key for triple DES symmetric encryption algorithm.
	 */
	private static final String TRIPLE_DES_SECRET_KEY = "password"; //TODO nstankovic generate secret key

	private static final String TRIPLE_DES_DIGEST_ALGORITHM = "SHA-256";

	private static final String TRIPLE_DES_ALGORITHM = "DESede";

	private static final String CBC_CHIPER_MODE = "CBC";

	private static final String PKCS5_CHIPER_PADDING = "PKCS5Padding";

	private static final String TRIPLE_DES_TRANSFORMATION = TRIPLE_DES_ALGORITHM + "/" + CBC_CHIPER_MODE + "/"
			+ PKCS5_CHIPER_PADDING;

	public static byte[] encrypt(String data) throws Exception {
		MessageDigest md = MessageDigest.getInstance(TRIPLE_DES_DIGEST_ALGORITHM);
		byte[] digestOfPassword = md.digest(TRIPLE_DES_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = 16; j < 8;) {
			keyBytes[k++] = keyBytes[j++];
		}

		SecretKey key = new SecretKeySpec(keyBytes, TRIPLE_DES_ALGORITHM);
		IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		Cipher cipher = Cipher.getInstance(TRIPLE_DES_TRANSFORMATION);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);

		byte[] plainTextBytes = data.getBytes(StandardCharsets.UTF_8);
		byte[] cipherText = cipher.doFinal(plainTextBytes);

		return cipherText;
	}

	public static String decrypt(byte[] data) throws Exception {
		MessageDigest md = MessageDigest.getInstance(TRIPLE_DES_DIGEST_ALGORITHM);
		byte[] digestOfPassword = md.digest(TRIPLE_DES_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = 16; j < 8;) {
			keyBytes[k++] = keyBytes[j++];
		}

		SecretKey key = new SecretKeySpec(keyBytes, TRIPLE_DES_ALGORITHM);
		IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		Cipher decipher = Cipher.getInstance(TRIPLE_DES_TRANSFORMATION);
		decipher.init(Cipher.DECRYPT_MODE, key, iv);

		byte[] plainText = decipher.doFinal(data);

		return new String(plainText, "UTF-8");
	}
}
