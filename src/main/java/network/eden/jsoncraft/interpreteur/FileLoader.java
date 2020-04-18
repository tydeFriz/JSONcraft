package network.eden.jsoncraft.interpreteur;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileLoader {

	public static List<String> getAll() {
		List<String> definitions = new ArrayList<>();

		List<File> filesInFolder = new ArrayList<>();
		try {
			filesInFolder = Files.walk(Paths.get("./main/java/network/eden/jsoncraft/resources/definitions/"))
					.filter(Files::isRegularFile)
					.map(Path::toFile)
					.collect(Collectors.toList());
		} catch (Exception e) {
			//TODO
		}

		for (File file : filesInFolder) {
			try {
				StringBuilder builder = new StringBuilder();
				Scanner myReader = new Scanner(file);

				while (myReader.hasNextLine()) {
					builder.append(myReader.nextLine());
				}
				myReader.close();
				definitions.add(builder.toString());
			} catch (FileNotFoundException e) {
				System.out.println("could not load " + file.getName());
				e.printStackTrace();
			}
		}

		return definitions;
	}

}
