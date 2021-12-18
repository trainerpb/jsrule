package org.easyrule.exceptions;

import java.io.IOException;

public class RuleLoadException extends IOException {

	public RuleLoadException(String message) {
		super(message);
		
	}
	
	public RuleLoadException() {
		super("::Cannot load rule::");
		
	}

}
