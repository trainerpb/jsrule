package anylang.scriptrunner.models;

import java.util.Objects;

import anylang.scriptrunner.exceptions.ScriptFailureException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbstractTextScript implements Script {

	private String scriptName;
	private String scriptContent;
	public String getScriptName() {
		if(Objects.isNull(scriptName)||scriptName.isEmpty()) {
			throw new ScriptFailureException(new IllegalArgumentException("scriptName was not set. Verify that you set scriptName, i.e. functionName etc. "));
		}
		return scriptName;
	}
	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}
	public String getScriptContent() {
		return scriptContent;
	}
	public void setScriptContent(String scriptContent) {
		this.scriptContent = scriptContent;
	}
	

}
