package anylang.scriptloader.factory;

import anylang.scriptloader.ScriptLoader;
import anylang.scriptloader.ScriptSource;
import anylang.scriptloader.exceptions.UnsupportedScriptSourceException;
import anylang.scriptloader.factory.impl.FileScriptLoader;

public class ScriptLoaderFactory {

	public static ScriptLoader getScriptLoader(ScriptSource scriptSource) {
		switch(scriptSource) {
		case FILE:
			return new FileScriptLoader();
		case TCP:
		case HTTP:
		case AWS_S3:
			default:
		}
		throw new UnsupportedScriptSourceException(scriptSource.name()+" is not supported yet!");
		
	}
}
