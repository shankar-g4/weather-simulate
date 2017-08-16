package com.weather.simulate.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Utility class for file operations
 * 
 * @author shankar
 *
 */
public class FileUtil {

	public InputStream getResourceFile(String filepath) {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(filepath);
		return is;
	}

	public static void writeToFile(String outFilepath, List<String> lines) {
		Path file = Paths.get(outFilepath);
		try {
			Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
