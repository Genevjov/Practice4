package ua.nure.dlubovskyi.Practice4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Util {
	/**
	 * 
	 * @param path
	 * @param encoding
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readFromFile(String path, String encoding) {
		// data reader container
		String readData = "";
		// result data container
		StringBuilder result = new StringBuilder();
		// reader
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(path)), encoding))) {
			while ((readData = reader.readLine()) != null) {
				result.append(readData);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getLocalizedMessage());
		} catch (UnsupportedEncodingException e) {
			System.err.println(e.getLocalizedMessage());
		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
		return result.toString();
	}
}