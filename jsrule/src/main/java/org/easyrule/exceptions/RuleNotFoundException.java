package org.easyrule.exceptions;

public class RuleNotFoundException extends IllegalArgumentException {

	public RuleNotFoundException(String s) {
		super(s);
		
	}
	
	public RuleNotFoundException() {
		super("Cannot find rule");
		
	}

}
