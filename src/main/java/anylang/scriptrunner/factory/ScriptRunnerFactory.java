package anylang.scriptrunner.factory;

import anylang.scriptrunner.ScriptRunner;
import anylang.scriptrunner.ScriptType;
import anylang.scriptrunner.exceptions.UnsupportedScriptTypeException;
import anylang.scriptrunner.factory.impl.JavaScriptRunner;
import anylang.scriptrunner.factory.impl.PythonScriptRunner;

public class ScriptRunnerFactory {

	public static ScriptRunner getScriptRunner(ScriptType scriptType) {
		switch (scriptType) {
		case JAVASCRIPT:
			return new JavaScriptRunner();
		case PYTHON:
			return new PythonScriptRunner();
		case JAVA:
		case NODE:
			
		
			
		case SCALA:
			throw new UnsupportedScriptTypeException(scriptType.name() + " is not suppored");
		default:
			break;
		}
		throw new UnsupportedScriptTypeException(scriptType.name() + " is not suppored");

	}
}
