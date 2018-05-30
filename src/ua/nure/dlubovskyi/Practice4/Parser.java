package ua.nure.dlubovskyi.Practice4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Iterable<String> {
	// input data container
	private String inputData;
	/**
	 * 
	 * @param fileName
	 * @param encoding
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Parser(String fileName, String encoding)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		inputData = Util.readFromFile(fileName, encoding);
	}

	/**
	 * 
	 * @author Dlubovkyi O. Iterator class
	 *
	 */
	class MyIterator implements Iterator<String> {
		private final String regex = "(?Um)(\\p{javaUpperCase}.+?(?:\\.|\\?|!))";
		private boolean flag = false;
		private Matcher matcher;
		private String lastMatch = "";

		MyIterator() {
			Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
			matcher = pattern.matcher(inputData);
		}

		// control position flag
		private void changeFlag() {
			flag = !flag;
		}

		@Override
		public boolean hasNext() {
			if (!flag) {
				changeFlag();
				return matcher.find();
			} else {
				throw new UnsupportedOperationException();
			}
		}

		@Override
		public String next() {
			if (flag) {
				changeFlag();
				lastMatch = matcher.group(1).replace(System.lineSeparator(), "");
				return lastMatch;
			} else {
				throw new UnsupportedOperationException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * @return {@link MyIterator}
	 */
	@Override
	public MyIterator iterator() {
		return new MyIterator();
	}

}