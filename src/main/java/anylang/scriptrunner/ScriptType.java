package anylang.scriptrunner;

public enum ScriptType {

	JAVA("JAVA"), JAVASCRIPT("JAVASCRIPT"), PYTHON("PYTHON"),
	SCALA("SCALA"), GRROVY("GRROVY"), NODE("NODE");

	private String scriptLanguage;
	ScriptType(String scriptLanguage) {
		this.scriptLanguage=scriptLanguage;
	}

}
