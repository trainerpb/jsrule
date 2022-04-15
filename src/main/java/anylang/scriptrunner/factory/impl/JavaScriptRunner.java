package anylang.scriptrunner.factory.impl;

import java.io.Reader;
import java.util.function.Function;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import anylang.scriptrunner.ScriptRunner;
import anylang.scriptrunner.exceptions.ScriptFailureException;
import anylang.scriptrunner.models.AbstractTextScript;
import anylang.scriptrunner.models.JavaScript;
import anylang.scriptrunner.models.Script;

public class JavaScriptRunner implements ScriptRunner {
	public static final String NASHORN = "Nashorn";
	private static ScriptEngine scriptEngine = null;
	
	 
	
	
	@Override
	public Object execute(Script script, Object... arguments) throws ScriptFailureException {
		AbstractTextScript javaScript=(AbstractTextScript)script;
		Invocable scriptInvocable=loadScript(javaScript.getScriptContent());
		try {
			return scriptInvocable.invokeFunction(script.getScriptName(), arguments);
		} catch (NoSuchMethodException | ScriptException e) {
			
			throw new ScriptFailureException(e);
		}
	}


	public JavaScriptRunner() {
		super();
		if (null == scriptEngine) {
			scriptEngine = new ScriptEngineManager().getEngineByName(JavaScriptRunner.NASHORN);
		}
	}

	
	/**
	 * @param reader
	 * @return {@link Invocable}
	 * @throws ScriptException 
	 * Apr 15, 2022 
	 * ScriptUtils.java 
	 * Invocable
	 * Try to Load script from a {@link Reader }.
	 */
	public Invocable loadScript(String scriptCode) throws ScriptFailureException {
		try {
			this.scriptEngine.eval(scriptCode);
			Invocable invocable = (Invocable) this.scriptEngine;

			return invocable;
		} catch (ScriptException e) {
			throw new ScriptFailureException("Failed to load script ",e);
		}

	}

	/**
	 * @param functionName
	 * @return if a function exists in JavaScript code listing
	 * @throws ScriptException 
	 * Apr 15, 2022 
	 * 
	 */
	public boolean isFunction(String functionName) throws ScriptException {
		String test = "typeof " + functionName + " === 'function' ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE";
		return (Boolean) this.scriptEngine.eval(test);
	}

	public  <T> Object pojoAsJsObject(T pojo,Function<? super T, String> jsonSerializer) throws ScriptException {
		String strJson=jsonSerializer.apply(pojo);
		String input = String.format("JSON.parse('%s')", strJson);
		
		return  scriptEngine.eval(input);
	}

	
}
