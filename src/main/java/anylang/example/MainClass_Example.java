package anylang.example;

import java.io.IOException;

import javax.script.ScriptException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import anylang.scriptloader.ScriptSource;
import anylang.scriptloader.factory.ScriptLoaderFactory;
import anylang.scriptrunner.ScriptType;
import anylang.scriptrunner.factory.ScriptRunnerFactory;
import anylang.scriptrunner.factory.impl.JavaScriptRunner;
import anylang.scriptrunner.factory.impl.PythonScriptRunner;
import anylang.scriptrunner.models.AbstractTextScript;

public class MainClass_Example {

	public static void main(String[] args) throws Exception{
		
		
		
	}

	private static void pythonRule1() throws IOException {
		String ruleId="my_function";
		int a=45;
		int b=50;
		String secondRule="antoherFunction";
		AbstractTextScript script=(AbstractTextScript) ScriptLoaderFactory.getScriptLoader(ScriptSource.FILE).load("D:\\boka\\A.py");
		script.setScriptName(ruleId);
		PythonScriptRunner pythonScriptRunner=(PythonScriptRunner) ScriptRunnerFactory.getScriptRunner(ScriptType.PYTHON);
		Object x=pythonScriptRunner.execute(script, a);
		System.out.println("Result is "+x);
		script.setScriptName(secondRule);
		 x=pythonScriptRunner.execute(script, b);
			System.out.println("Result is "+x);
	}

	private static void jsRule2() throws IOException, ScriptException {
		String ruleId="demoRule2";
		Student param=new Student("Female");
	
		AbstractTextScript script=(AbstractTextScript) ScriptLoaderFactory.getScriptLoader(ScriptSource.FILE).load("D:\\boka\\js\\A.js");
		script.setScriptName(ruleId);
		JavaScriptRunner jsr = (JavaScriptRunner) ScriptRunnerFactory.getScriptRunner(ScriptType.JAVASCRIPT);
		
		
		Object result=jsr.execute(script, jsr.pojoAsJsObject(param, t -> {
			try {
				return new ObjectMapper().writeValueAsString(t);
			} catch (JsonProcessingException e) {
				throw new IllegalArgumentException("Invalid input", e);
			}
			
		}));
		System.out.println(result);
	}

	private static void example1() throws IOException {
		String ruleId="demoRule1";
		Object[] params=new Object[] {5,10};
		
		AbstractTextScript script=(AbstractTextScript) ScriptLoaderFactory.getScriptLoader(ScriptSource.FILE).load("D:\\boka\\js\\A.js");
		script.setScriptName(ruleId);
		JavaScriptRunner jsr = (JavaScriptRunner) ScriptRunnerFactory.getScriptRunner(ScriptType.JAVASCRIPT);
		
		
		Object result=jsr.execute(script, params);
		System.out.println(result);
	}

	static class Student{
		private String sex;
		
		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public Student(String sex) {
			
			this.sex = sex;
		}
		
	}
}
