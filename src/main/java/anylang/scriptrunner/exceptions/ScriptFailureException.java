package anylang.scriptrunner.exceptions;

import javax.script.ScriptException;

public class ScriptFailureException extends RuntimeException {

	private static final long serialVersionUID = -8381996671122805650L;

	public ScriptFailureException(Throwable e) {
		super(e);
	}

	public ScriptFailureException(String msg, ScriptException e) {
		super(msg,e);
	}

}
