package network.eden.jsoncraft.interpreteur;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourcesReader {

	private static final String definitionsPath = "resources" + File.separator + "definitions";

	public static Optional<Set<String>> readDefinitions() {
		return readInternalResources(definitionsPath);
	}

	public static Optional<Set<String>> readInternalResources(String resourcesDir) {
		try {
			URI uri = Thread.currentThread().getClass().getResource(File.separator + resourcesDir).toURI();
			Path myPath;
			if (uri.getScheme().equals("jar")) {
				FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
				myPath = fileSystem.getPath(File.separator + resourcesDir);
			} else {
				myPath = Paths.get(uri);
			}
			Set<String> definitions = Files.walk(myPath, 1)
					.filter(Files::isRegularFile)
					.filter(Files::isReadable)
					.map((file) -> {
						try {
							return Files.readAllBytes(file);
						} catch (IOException e) {
							System.err.format("Couldn't load resource '%s'!", file.getFileName());
							e.printStackTrace();
							return null;
						}
					})
					.filter(Objects::nonNull)
					.map((bytes) -> new String(bytes, StandardCharsets.UTF_8))
					.collect(Collectors.toSet());

			return Optional.of(definitions);
		} catch (IOException | URISyntaxException ex) {
			System.err.format("Couldn't load resources directory '%s'!", resourcesDir);
			ex.printStackTrace();
			return Optional.empty();
		}
	}

}
