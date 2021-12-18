package org.easyrule.scripts;

import java.io.Reader;
import java.util.function.Function;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Soham Sengupta
 *  Date: Dec 18, 2021
 *   org.easyrule.scripts
 * 
 *  Utility class to load JavaScript methods and execute them as needed
 */
public class ScriptUtils {

	public static final String NASHORN = "Nashorn";
	private static ScriptEngine scriptEngine = null;

	/**
	 * Initialize script engine
	 */
	public ScriptUtils() {
		if (null == scriptEngine) {
			scriptEngine = new ScriptEngineManager().getEngineByName(ScriptUtils.NASHORN);
		}
	}

	/**
	 * @param reader
	 * @return {@link Invocable}
	 * @throws ScriptException 
	 * Dec 18, 2021 
	 * ScriptUtils.java 
	 * Invocable
	 * Try to Load script from a {@link Reader }.
	 */
	public Invocable loadScript(Reader reader) throws ScriptException {
		try {
			this.scriptEngine.eval(reader);
			Invocable invocable = (Invocable) this.scriptEngine;

			return invocable;
		} catch (ScriptException e) {
			throw e;
		}

	}

	/**
	 * @param functionName
	 * @return if a function exists in JavaScript code listing
	 * @throws ScriptException Dec 18, 2021 ScriptUtils.java boolean
	 * 
	 */
	public boolean isFunction(String functionName) throws ScriptException {
		String test = "typeof " + functionName + " === 'function' ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE";
		return (Boolean) this.scriptEngine.eval(test);
	}

	public static Object pojoAsJsObject(Object pojo,Function<Object, String> jsonSerializer) throws ScriptException {
		String strJson=jsonSerializer.apply(pojo);
		String input = String.format("JSON.parse('%s')", strJson);
		System.out.println("ScriptUtils.pojoAsJsObject()"+input);
		return  scriptEngine.eval(input);
	}

}
