package ua.nure.dlubovskyi.Practice4;

import java.io.IOException;

public class Part4 {
	// path
	private static final String FILE_NAME = "part4.txt";
	// encoding
	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) {

		Parser parser;
		try {
			parser = new Parser(FILE_NAME, ENCODING);
			for (String string : parser) {
				System.out.println(string);
			}
		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}

	}

}