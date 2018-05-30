package test.ua.nure.dlubovskyi.Practice4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import ua.nuredlubovskyi.Practice4.Part3;
import ua.nuredlubovskyi.Practice4.Util;

public class Part3Test {

	private static final InputStream STD_IN = System.in;
	private static final String ENCODING = "Cp1251";

	@Test
	public void testMainMethod() throws IOException {
		System.setIn(new ByteArrayInputStream(
				"char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(ENCODING)));
		Part3.getSelectedTypeData(Util.readFromFile("part3.txt", "CP1251"));
		System.setIn(STD_IN);
	}

	@Test
	public void testMain() throws IOException {
		System.setIn(new ByteArrayInputStream(
				"char^String^int^double^stop".replace("^", System.lineSeparator()).getBytes(ENCODING)));
		Part3.main(null);
		System.setIn(STD_IN);
	}
}
