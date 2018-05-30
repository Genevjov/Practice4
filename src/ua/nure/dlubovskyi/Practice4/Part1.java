package ua.nure.dlubovskyi.Practice4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	// input file
	private static final String FILE_NAME = "part1.txt";
	// reg for matcher
	private static final String REG_EXP = "(?U)((?:^|\\b)\\w{4,}\\b)";

	/**
	 * @param input
	 * @return changed string
	 */
	public String changeString(String input) {
		if (Objects.isNull(input)) {
			return null;
		}
		// create matcher
		Matcher matcher = Pattern.compile(REG_EXP).matcher(input);
		String result = new String(input);
		while (matcher.find()) {
			// updating string
			result = result.replaceFirst(matcher.group(1), matcher.group(1).toUpperCase());
		}
		return result;
	}

	public static void main(String[] args) throws IOException, FileNotFoundException {
		Part1 part1 = new Part1();
		System.out.println(part1.changeString(Util.readFromFile(FILE_NAME, "CP1251")));

	}
}