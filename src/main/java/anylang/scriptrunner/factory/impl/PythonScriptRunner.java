package anylang.scriptrunner.factory.impl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import anylang.scriptrunner.ScriptRunner;
import anylang.scriptrunner.exceptions.ScriptFailureException;
import anylang.scriptrunner.models.AbstractTextScript;
import anylang.scriptrunner.models.Script;

public class PythonScriptRunner implements ScriptRunner {

	@Override
	public Object execute(Script script, Object... arguments) throws ScriptFailureException {
		PyObject result = null;
		AbstractTextScript pythonScript=(AbstractTextScript)script;
		try (PythonInterpreter pyInterp = new PythonInterpreter()) {
			pyInterp.exec(pythonScript.getScriptContent());
			String methodCallSytax=buildPythonFunctionCallSyntax(pythonScript,arguments);
			System.out.println("PythonScriptRunner.execute()"+methodCallSytax);
			 result= pyInterp.eval(methodCallSytax);
			
		}
		return result;
	}

	private String buildPythonFunctionCallSyntax(AbstractTextScript pythonScript,Object...objects ) {
		String arguments=Stream.of(objects).map(String::valueOf).collect(Collectors.joining(",","(",")"));
		return String.format("%s%s", pythonScript.getScriptName(),arguments);
	}

}
