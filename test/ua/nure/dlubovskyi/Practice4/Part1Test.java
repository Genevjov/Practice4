package test.ua.nure.dlubovskyi.Practice4;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import ua.nuredlubovskyi.Practice4.Part1;

public class Part1Test {

	private static final String[] ARG = {};

	@Test
	public void convertTestString() {
		Part1 part1 = new Part1();
		String actual = part1.changeString("This tutorial explains unit testing with JUnit 4.x and JUnit5.");
		String expected = "THIS TUTORIAL EXPLAINS UNIT TESTING WITH JUNIT 4.x and JUNIT5.";
		assertEquals(expected, actual);
		assertEquals("", part1.changeString(""));
		assertEquals(null, part1.changeString(null));
	}

	@Test
	public void constructor() {
		new Part1();
	}

	@Test
	public void main() {
		try {
			Part1.main(ARG);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
