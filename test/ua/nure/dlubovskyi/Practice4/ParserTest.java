package test.ua.nure.dlubovskyi.Practice4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import ua.nuredlubovskyi.Practice4.Parser;

public class ParserTest {
	Parser parser;

	@Before
	@Test
	public void constructorTest() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		parser = new Parser("part5.txt", "CP1251");
	}

	@Test
	public void iteratorTest() {
		Iterator<String> iterator = parser.iterator();
		assertTrue(!Objects.isNull(iterator));
	}
}
