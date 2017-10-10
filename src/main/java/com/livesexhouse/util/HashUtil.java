package com.livesexhouse.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(HashUtil.class);

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Enter a String to sign");
			System.exit(-1);
		}
		System.out.println("Signed String: " + signString(args[0]));
	}

	/**
	 * From a base 64 representation, returns the corresponding byte[]
	 *
	 * @param data
	 *            String The base64 representation
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] base64ToByte(String data) throws IOException {
	    return Base64.decodeBase64(data);
	}

	/**
	 * From a byte[] returns a base 64 representation
	 *
	 * @param data
	 *            byte[]
	 * @return String
	 */
	public static String byteToBase64(byte[] data) {
		return new String(Base64.encodeBase64(data));
	}

	/**
	 * Generating Hash Message Authentication Code (HMAC) in Hexadecimal value.
	 * 
	 * For list of available algorithms see <a href=
	 * "http://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Mac">HMAC
	 * Algorithms</a>
	 * 
	 * @param data
	 * @param key
	 * @param algorithm
	 * @return String
	 */
	public static String getHmacHexadecimalValue(String data, String key, String algorithm) {
		return getHexadecimalValue(getHmac(data, key, algorithm));
	}

	private static String signString(String request) {
		byte[] digest = DigestUtils.sha256(request);
		return new String(Base64.encodeBase64(digest));
	}

	private static byte[] getHmac(String data, String key, String algorithm) {
		byte[] result = null;
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
			Mac mac = Mac.getInstance(algorithm);
			mac.init(secretKeySpec);
			result = mac.doFinal(data.getBytes());
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			LOGGER.error(e.getMessage());
		}
		return result;
	}

	private static String getHexadecimalValue(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		for (byte b : bytes) {
			result.append(String.format("%02x", b));
		}
		return result.toString();
	}

}