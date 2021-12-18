package org.easyrule;

import javax.naming.LinkException;

import org.easyrule.exceptions.RuleLoadException;
import org.easyrule.exceptions.RuleNotFoundException;
import org.easyrule.exceptions.RuleParseError;

/**
 * @author Soham Sengupta
 * Date: Dec 18, 2021
 * org.easyrule
 */
public interface RuleLoader {
	/**
	 * @param ruleId
	 * @return {@link Rule} 
	 * @throws RuleLoadException
	 * @throws RuleNotFoundException
	 * @throws RuleParseError
	 * Dec 18, 2021
	 * RuleLoader.java
	 * Rule
	 * 
	 */
	public Rule load(String ruleId) throws RuleLoadException,RuleNotFoundException,RuleParseError;
}
