package org.easyrule.impls.jsfileloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.script.Invocable;
import javax.script.ScriptException;

import org.easyrule.Rule;
import org.easyrule.RuleLoader;
import org.easyrule.exceptions.RuleLoadException;
import org.easyrule.exceptions.RuleNotFoundException;
import org.easyrule.exceptions.RuleParseError;
import org.easyrule.scripts.ScriptUtils;

/**
 * This class illustrates loading JavaScript method from localfile system.
 * @author Soham Sengupta
 * Date: Dec 18, 2021
 * org.easyrule.impls.jsfileloader
 */
public class JavaScriptFromFileSystemLoader implements RuleLoader {
	private Reader reader=null;

	private ScriptUtils scriptUtils=null;
	
	public JavaScriptFromFileSystemLoader(String strJSFilePath) throws RuleLoadException,RuleNotFoundException,RuleParseError{
		File jsFile=new File(strJSFilePath);
		
		try {
			this.reader =new FileReader(jsFile);
			this.scriptUtils=new ScriptUtils();
		} catch (FileNotFoundException e) {
			throw new RuleLoadException("Cannot load JSFile ::"+strJSFilePath);
		}
	}

	@Override
	public Rule load(String ruleId) throws RuleLoadException, RuleNotFoundException, RuleParseError {
		Rule rule=null;
		String functionName=ruleId;
		/**
		 * Check if ruleId , i.e. function exists
		 */
		try {
				Invocable invocable=this.scriptUtils.loadScript(this.reader);
				boolean isFunction=this.scriptUtils.isFunction(functionName) ;
				if(!isFunction) {
					throw new RuleNotFoundException("Cannot find function "+functionName);
				}
					
				/***
				 * Function , i.e. Rule exists . Try executing it.	
				 */
					
				rule=new Rule(ruleId, invocable);
				
				return rule;
			
			
		} catch (ScriptException e) {
			throw new RuleParseError();
		}
		
		
		
	}

}
