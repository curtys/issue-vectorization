package ch.unibe.scg.curtys.vectorization.components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by scurty on 02.02.17.
 */
public class CodeSnippetElementsTest {

	private String text1 = "Storing numerical constants in the single class\n"
			+ "\n"
			+ "This is a small step to address the issue, but it makes sense on its own since\n"
			+ "currently script containing\n"
			+ "\n"
			+ "function f() { return 1; }\n"
			+ "function g() { return 1; }\n"
			+ "\n"
			+ "print(f()+g()+Math.sqrt(1));\n"
			+ "\n"
			+ "would create 3 classes each contain a code to generate a wrapper Number object\n"
			+ "to represent 1 and with the patch the single constant from the class for the\n"
			+ "main script will be used.";

	private String text2 = "Currently Rhino optimizer generates one Java class per JavaScript function which\n"
			+ "may lead to significant runtime overhead. I think it would be worth to try to\n"
			+ "replace that by a single class with a switch dispatch to select code for a\n"
			+ "particular function. I open this report to record work on it.";

	private String text3 = "void constructor(Context cx, Scriptable scope, int id)\n"
			+ "{\n"
			+ "    store id\n"
			+ "    static call to firestGeneratedClass._i<id>(this, cx, scope);\n"
			+ "}";

	private CodeSnippetElements vecElement = new CodeSnippetElements();

	@Test
	public void filterTest() {
		assertTrue(vecElement.matchesFilter(text1));
		assertFalse(vecElement.matchesFilter(text2));
		assertTrue(vecElement.matchesFilter(text3));
	}

}