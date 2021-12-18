package org.easyrule.exceptions;

public class RuleParseError extends IllegalArgumentException {

	public RuleParseError(String s) {
		super(s);
		
	}

	public RuleParseError() {
		super("Error parsing rule syntax");
		
	}

}
