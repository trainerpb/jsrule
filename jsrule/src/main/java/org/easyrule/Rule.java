package org.easyrule;

import javax.script.Invocable;
import javax.script.ScriptException;

public class Rule {
	private String id;
	private Invocable ruleInvocable;
	

	public Rule(String id, Invocable ruleInvocable) {
		super();
		this.id = id;
		this.ruleInvocable = ruleInvocable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Invocable getRuleInvocable() {
		return ruleInvocable;
	}

	public void setRuleInvocable(Invocable ruleInvocable) {
		this.ruleInvocable = ruleInvocable;
	}
	/**
	 * @param args
	 * @return result of execution
	 * @throws NoSuchMethodException
	 * @throws ScriptException
	 * Dec 18, 2021
	 * Rule.java
	 * Object
	 * 
	 */
	public Object execute(Object ...args) throws NoSuchMethodException, ScriptException {
		return this.ruleInvocable.invokeFunction(id, args);
	}

}
