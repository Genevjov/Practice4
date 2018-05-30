package test.ua.nure.dlubovskyi.Practice4;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import ua.nuredlubovskyi.Practice4.Part5;

public class Part5Test {
	@Test
	public void mainTest() throws UnsupportedEncodingException {
		System.setIn(new ByteArrayInputStream(
				"table en^apple ru^table ru^apple en^stop".replace("^", System.lineSeparator()).getBytes("CP1251")));
		Part5.main(new String[] {});
		System.setIn(System.in);
	}

}
