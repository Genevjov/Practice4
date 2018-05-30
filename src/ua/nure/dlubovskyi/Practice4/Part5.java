package ua.nure.dlubovskyi.Practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class Part5 {

	private static final String BASE_NAME = "resources";
	private static final String STOP_WORD = "stop";

	public static void main(String[] args) {
		getResourceValue();
	}

	/**
	 * Get resource value
	 */
	public static void getResourceValue() {
		// reader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// input container
		String inputData = "";
		// options array
		String[] values = new String[2];
		ResourceBundle resourceBundle;
		while (true) {

			try {
				inputData = reader.readLine();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			if (inputData.equals(STOP_WORD) | Objects.isNull(inputData)) {
				break;
			}
			values = inputData.split(" ");
			// getting resource
			resourceBundle = ResourceBundle.getBundle(BASE_NAME, new Locale(values[values.length - 1]));
			System.out.println(resourceBundle.getString(values[0]));

		}
	}
}
