package ua.nure.dlubovskyi.Practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Random;

public class Part2 {
	// path
	private static final String RAW_DATA = "part2.txt";
	// output path
	private static final String SORTED_DATA = "part2_sorted.txt";
	// max elements
	private static final int N = 10;
	// max num value
	private static final int MAX = 50;

	/**
	 * Write array to file
	 * 
	 * @param path
	 */
	public static void writeFile(String path) {
		if (!Objects.isNull(path) && !path.isEmpty()) {

			File file = new File(path);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
			try (FileWriter fWriter = new FileWriter(path)) {
				for (int i = 0; i < N; i++) {
					fWriter.write(new Random().nextInt(MAX) + 1 + " ");
				}
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * 
	 * @param stringArray
	 * @return converted string to int array
	 */
	public static int[] arrayConvertor(String[] stringArray) {
		if (Objects.isNull(stringArray)) {
			return null;
		}
		int[] resultArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			resultArray[i] = Integer.parseInt(stringArray[i]);
		}
		return resultArray;
	}

	/**
	 * 
	 * @param array
	 * @return sorted array using bubble sort
	 */
	public static int[] arraySort(int[] array) {
		if (Objects.isNull(array)) {
			return null;
		}
		int[] sortedArray = array;
		for (int i = 0; i < sortedArray.length; i++) {
			for (int j = i; j < sortedArray.length; j++) {
				if (sortedArray[i] > sortedArray[j]) {
					int temp = array[i];
					sortedArray[i] = sortedArray[j];
					sortedArray[j] = temp;
				}
			}
		}
		return sortedArray;
	}

	/**
	 * Write sorted array to file
	 * 
	 * @param data
	 * @param path
	 */
	public static void writeSortedData(String data, String path) {
		if (!Objects.isNull(data) && !Objects.isNull(path) && !data.isEmpty() && !path.isEmpty()) {

			String[] stringValues = data.split(" ");
			int[] array = arraySort(arrayConvertor(stringValues));

			try (FileWriter fWriter = new FileWriter(path)) {
				for (int i : array) {
					fWriter.write(i + " ");
				}
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		writeFile(RAW_DATA);
		writeSortedData(Util.readFromFile(RAW_DATA, "CP1251"), SORTED_DATA);
		System.out.println("input ==> " + Util.readFromFile(RAW_DATA, "CP1251"));
		System.out.println("output ==> " + Util.readFromFile(SORTED_DATA, "CP1251"));

	}

}