package com.khjxiaogu.MusicToVoice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public final class Utils {
	public static byte[] readAll(InputStream i) throws IOException {
		ByteArrayOutputStream ba = new ByteArrayOutputStream(16384);
		int nRead;
		byte[] data = new byte[4096];

		try {
			while ((nRead = i.read(data, 0, data.length)) != -1)
				ba.write(data, 0, nRead);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}

		return ba.toByteArray();
	}
	public static byte[] readAll(File i) {
		try (FileInputStream fis = new FileInputStream(i)) {
			return Utils.readAll(fis);
		} catch (IOException ignored) {
			// TODO Auto-generated catch block
		}
		return new byte[0];
	}
	public static long getTime() { return new Date().getTime(); }
	public static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
