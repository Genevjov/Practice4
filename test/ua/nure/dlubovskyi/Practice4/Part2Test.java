package test.ua.nure.dlubovskyi.Practice4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import ua.nuredlubovskyi.Practice4.Part2;

public class Part2Test {
	private static final String[] ARG = {};

	int[] arr = { 8, 4, 12, 43, 1 };
	String name = "part2test.txt";
	File file = new File(name);

	@Test
	public void writeFile() {
		Part2.writeFile(name);
		assertTrue(file.exists());
		file.delete();
		Part2.writeFile(null);
		assertFalse(file.exists());
		Part2.writeFile("");
		assertFalse(file.exists());
	}

	@Test
	public void arrayConvertor() {
		assertArrayEquals(arr, Part2.arrayConvertor(new String[] { "8", "4", "12", "43", "1" }));
		assertArrayEquals(null, Part2.arrayConvertor(null));

	}

	@Test
	public void arraySort() {
		assertArrayEquals(new int[] { 1, 4, 8, 12, 43 }, Part2.arraySort(arr));
		assertEquals(null, Part2.arraySort(null));
	}

	@Test(expected = NumberFormatException.class)
	public void writeSorted() {
		Part2.writeSortedData("22 32 43", name);
		assertTrue(file.exists());
		file.delete();
		Part2.writeSortedData("", "");
		assertFalse(file.exists());
		Part2.writeSortedData(null, null);
		assertFalse(file.exists());
		Part2.writeSortedData("asd", name);
	}

	@Test
	public void main() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		Part2.main(ARG);
	}

}
