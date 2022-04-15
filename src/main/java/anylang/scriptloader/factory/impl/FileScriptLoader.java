package anylang.scriptloader.factory.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import anylang.scriptloader.ScriptLoader;
import anylang.scriptrunner.models.AbstractTextScript;
import anylang.scriptrunner.models.Script;

public class FileScriptLoader implements ScriptLoader {

	@Override
	public Script load(String sourceIdentifier) throws IOException {
		File sourceFile = new File(sourceIdentifier);
		if (!sourceFile.exists()) {
			throw new FileNotFoundException(sourceIdentifier);
		}
		String content = null;
		
		content = Files.lines(sourceFile.toPath()).collect(Collectors.joining(System.lineSeparator()));
		return new AbstractTextScript().builder().scriptContent(content).build();
		
	}

}
