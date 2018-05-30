package test.ua.nure.dlubovskyi.Practice4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class AllTests {

	@Test
	public void part1Test() throws FileNotFoundException, IOException {
		Part1Test part1Test = new Part1Test();
		part1Test.constructor();
		part1Test.convertTestString();
	}

	@Test(expected = NumberFormatException.class)
	public void part2Test() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		Part2Test part2Test = new Part2Test();
		part2Test.arrayConvertor();
		part2Test.arraySort();
		part2Test.writeFile();
		part2Test.writeSorted();
		part2Test.main();
	}

	@Test
	public void part3Test() throws IOException {
		Part3Test part3Test = new Part3Test();
		part3Test.testMain();
		part3Test.testMainMethod();
	}

	@Test
	public void part4Test() {
		Part4Test part4Test = new Part4Test();
		part4Test.counstructorTest();
		part4Test.mainTest();
	}

	@Test
	public void part5Test() throws UnsupportedEncodingException {
		Part5Test part5Test = new Part5Test();
		part5Test.mainTest();
	}

	@Test
	public void parserTest() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		ParserTest parserTest = new ParserTest();
		parserTest.constructorTest();
		parserTest.iteratorTest();
	}
}
