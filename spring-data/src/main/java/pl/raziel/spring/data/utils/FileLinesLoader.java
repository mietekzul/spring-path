package pl.raziel.spring.data.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Created by dlok on 02/06/2017.
 */
@Component
class FileLinesLoader {
	List<String> loadLines(String filePath) {
		try {
			return Files.readAllLines(
					Paths.get(
							new ClassPathResource(
									filePath)
									.getURI()));
		} catch (IOException e) {
			throw new RuntimeException(
					String.format(
							"Error while reading lines from file %s",
							filePath),
					e);
		}
	}

	List<String> loadLinesShuffled(String filePath) {
		List<String> lines = loadLines(filePath);
		Collections.shuffle(lines);
		return lines;
	}
}
