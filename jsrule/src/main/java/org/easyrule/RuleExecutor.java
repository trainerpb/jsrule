package org.easyrule;

import org.easyrule.exceptions.RuleLoadException;
import org.easyrule.exceptions.RuleNotFoundException;
import org.easyrule.exceptions.RuleParseError;

/**
 * @author Soham Sengupta
 * Date: Dec 18, 2021
 * org.easyrule
 * This interface abstracts execution of a Rule .
 * It provisions using a suitable loader to load the rule identified by an ID.  
 */
public interface RuleExecutor {
	/**
	 * @param loader
	 * @param ruleId
	 * @return
	 * Dec 18, 2021
	 * RuleExecutor.java
	 * Object
	 * TODO
	 */
	public default Object execute( String ruleId,Object ...args) throws Exception{
		Rule rule=getLoader().load(ruleId);
		
		return rule.execute(args);
	}

	/**
	 * This need to be provided
	 * @return Loader
	 * Dec 18, 2021
	 * RuleExecutor.java
	 * RuleLoader
	 * TODO
	 * @throws RuleLoadException 
	 * @throws RuleParseError 
	 * @throws RuleNotFoundException 
	 */
	public RuleLoader getLoader() throws RuleNotFoundException, RuleParseError, RuleLoadException;
}
