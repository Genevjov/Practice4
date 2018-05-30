package ua.nure.dlubovskyi.Practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	// regs
	private static final String REG_CHARACTER = "(?U)(?:^|\\b)(\\p{L}\\b)";
	private static final String REG_INTEGER = "(?:^| )(\\d+)(?:\\z| )";
	private static final String REG_DOUBLE = "(?: |^)((?:\\.\\d+)|(?:\\d+\\.\\d+)|(?:\\d+\\.)(?= |\\z))";
	private static final String REG_STRING = "(?U)((?:[^0-9\\s\\.]\\S+)|(?:\\S+[^0-9\\s\\.]))";
	// input constants
	private static final String CHARACTER = "char";
	private static final String INTEGER = "int";
	private static final String DOUBLE = "double";
	private static final String STRING = "String";
	private static final String STOP = "stop";
	// input data
	private String data;

	public Part3(String filePath, String encoding) {
		data = Util.readFromFile(filePath, encoding);
	}

	// data searcher
	private static void findData(String regExp, String data) {
		Matcher matcher = Pattern.compile(regExp).matcher(data);
		StringBuilder sb = new StringBuilder();
		while (matcher.find()) {
			sb.append(matcher.group(1)).append(" ");
		}
		sb.replace(sb.length() - 1, sb.length(), "");
		System.out.println(sb.toString());
	}

	/**
	 * 
	 * @param type
	 * @throws IOException
	 */
	public static void getSelectedTypeData(String input) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (true) {
			s = br.readLine();
			if (STOP.equals(s) | Objects.isNull(s)) {
				break;
			}
			switch (s) {
			case CHARACTER:
				findData(REG_CHARACTER, input);
				break;
			case INTEGER:
				findData(REG_INTEGER, input);
				break;
			case DOUBLE:
				findData(REG_DOUBLE, input);
				break;
			case STRING:
				findData(REG_STRING, input);
				break;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		Part3 part3 = new Part3("part3.txt", "CP1251");
		part3.getSelectedTypeData(part3.data);
	}

}