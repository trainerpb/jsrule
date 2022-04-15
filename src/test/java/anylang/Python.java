package anylang;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;

import javax.script.ScriptEngineManager;

import org.junit.jupiter.api.Test;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

class Python {

	@Test
	void test() {
		new ScriptEngineManager().getEngineFactories().forEach(System.out::println);
		try (PythonInterpreter pyInterp = new PythonInterpreter()) {
			execfile("D:\\boka\\a.py", pyInterp);
			
			
		}
	}

	@Test
	public void givenPythonInterpreter_whenPrintExecuted_thenOutputDisplayed() {
		try (PythonInterpreter pyInterp = new PythonInterpreter()) {
			StringWriter output = new StringWriter();
			pyInterp.setOut(output);

			pyInterp.exec("print('Hello Baeldung Readers!!')");
			assertEquals("Should contain script output: ", "Hello Baeldung Readers!!", output.toString().trim());
			System.out.println(output.toString());
		}
	}

	void execfile(final String fileName, PythonInterpreter interpreter) {
		interpreter.execfile(fileName);
		PyObject obj= interpreter.eval("my_function(21)");
		System.out.println(obj);
		System.out.println(interpreter.get("x"));
	}

}
