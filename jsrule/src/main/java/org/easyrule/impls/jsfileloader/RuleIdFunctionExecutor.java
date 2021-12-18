package org.easyrule.impls.jsfileloader;

import org.easyrule.RuleExecutor;
import org.easyrule.RuleLoader;
import org.easyrule.exceptions.RuleLoadException;
import org.easyrule.exceptions.RuleNotFoundException;
import org.easyrule.exceptions.RuleParseError;

/**
 * @author Soham Sengupta
 * Date: Dec 18, 2021
 * org.easyrule.impls.jsfileloader
 * 
 * Illustrates how to run a rule if ruleId is name of the JavaScript function
 */
public class RuleIdFunctionExecutor implements RuleExecutor {

	
	private String jsFilePath;
	
	public RuleIdFunctionExecutor(String jsFilePath) {
		
		this.jsFilePath = jsFilePath;
	}

	@Override
	public RuleLoader getLoader() throws RuleNotFoundException, RuleParseError, RuleLoadException {
		// TODO Auto-generated method stub
		return new JavaScriptFromFileSystemLoader(jsFilePath);
	}
	
	

}
