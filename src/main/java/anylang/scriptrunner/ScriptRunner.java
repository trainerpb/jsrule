package anylang.scriptrunner;

import anylang.scriptrunner.exceptions.ScriptFailureException;
import anylang.scriptrunner.models.Script;

public interface ScriptRunner {

	public Object execute(Script script,Object ...arguments) throws ScriptFailureException;
}
