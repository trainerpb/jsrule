package anylang.scriptloader;

import java.io.IOException;

import anylang.scriptrunner.models.Script;

public interface ScriptLoader {

	public Script load(String sourceIdentifier) throws IOException;
}
