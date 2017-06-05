package ch.unibe.scg.curtys.vectorization.components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by scurty on 02.02.17.
 */
public class OperationalElementsTest {

	private String text1 = "You need to explicitly create a NativeArray rather than relying upon cx.newObject. The older code was written before it was explicitly standardized that array literals should call the standard built-in constructor. With your patch the following happens:\n"
			+ "\n"
			+ "js> function Array() { print('hi'); }\n"
			+ "js> var a = []\n"
			+ "hi\n"
			+ "Exception in thread \"main\" java.lang.ClassCastException: org.mozilla.javascript.NativeObject cannot be cast to org.mozilla.javascript.NativeArray\n"
			+ "\tat org.mozilla.javascript.ScriptRuntime.newArrayLiteral(ScriptRuntime.java:3469)\n"
			+ "\tat org.mozilla.javascript.Interpreter.interpretLoop(Interpreter.java:2059)\n"
			+ "\tat org.mozilla.javascript.Interpreter.interpret(Interpreter.java:845)\n"
			+ "\tat org.mozilla.javascript.InterpretedFunction.call(InterpretedFunction.java:164)\n"
			+ "\tat org.mozilla.javascript.ContextFactory.doTopCall(ContextFactory.java:426)\n"
			+ "\tat org.mozilla.javascript.ScriptRuntime.doTopCall(ScriptRuntime.java:3090)\n"
			+ "\tat org.mozilla.javascript.InterpretedFunction.exec(InterpretedFunction.java:175)\n"
			+ "\tat org.mozilla.javascript.tools.shell.Main.evaluateScript(Main.java:563)\n"
			+ "\tat org.mozilla.javascript.tools.shell.Main.processSource(Main.java:424)\n"
			+ "\tat org.mozilla.javascript.tools.shell.Main.processFiles(Main.java:196)\n"
			+ "\tat org.mozilla.javascript.tools.shell.Main$IProxy.run(Main.java:117)\n"
			+ "\tat org.mozilla.javascript.Context.call(Context.java:522)\n"
			+ "\tat org.mozilla.javascript.ContextFactory.call(ContextFactory.java:535)\n"
			+ "\tat org.mozilla.javascript.tools.shell.Main.exec(Main.java:179)\n"
			+ "\tat org.mozilla.javascript.tools.shell.Main.main(Main.java:157)";

	private String text2 = "Checking in src/org/mozilla/javascript/ScriptRuntime.java;\n"
			+ "/cvsroot/mozilla/js/rhino/src/org/mozilla/javascript/ScriptRuntime.java,v  <--  ScriptRuntime.java\n"
			+ "new revision: 1.319; previous revision: 1.318\n"
			+ "done\n"
			+ "Checking in testsrc/doctests/array.length.doctest;\n"
			+ "/cvsroot/mozilla/js/rhino/testsrc/doctests/array.length.doctest,v  <--  array.length.doctest\n"
			+ "initial revision: 1.1\n"
			+ "done";

	private String text3 = "2017-02-02 09:50:35,524 ERROR stats.magnolia.jcr.wrapper.ExtendingNodeWrapper    : Can't find \n"
			+ "2017-02-02 09:50:35,703 INFO  ource.yaml.AbstractFileResourceConfigurationSource: Setting \n"
			+ "2017-02-02 09:50:34,589 DEBUG nolia.module.utils.setup.UtilsModuleVersionHandler: checking \n"
			+ "2017-02-02 09:50:36,999 WARN  form.field.definition.BasicTextCodeFieldDefinition: BasicTextCodeFieldDefinition";

	private String text4 = "12:35:03.076 [main] INFO  ch.unibe.classifier.IssueClassifier\n"
			+ "12:35:03.076 [main] INFO  ch.unibe.classifier.IssueClassifier";

	private String text5 = "RuntimeException";

	private String text6 = "AnotherRuntimeException";

	private String text7 = "ContextFactory";

	private String text8 = "reallyLongMethodName()";

	private String text9 = "reallyLongMethodName(Object something)";

	private String text10 = "word";

	private String text11 = "method ()";

	private String text12 = "It would be nice to have functionality  "
			+ "right-click on class for\nwhich a Unit test was previously generated "
			+ "and have menu item \"Update tests\". \nThis functionality would be "
			+ "similar to the functionality currently provided when\nuser right-clicks "
			+ "on Source->Implement/override methods.  The presented dialog\nwould "
			+ "allow user to select methods (added since the last time tests were\ngenerated) "
			+ "for which to generate test skeletons.\n\nThanks,\nRoman.";

	private String text13 = "to (for example)";

	private String text14 = "JUnit";

	private String text15 = "Word";

	private String text16 = "reallyLongMethodName (Object something)";

	private OperationalElements vecElement = new OperationalElements();

	@Test
	public void filterTest() {
		assertTrue(vecElement.matchesFilter(text1));
		assertTrue(vecElement.matchesFilter(text2));
		assertTrue(vecElement.matchesFilter(text3));
		assertTrue(vecElement.matchesFilter(text4));
		assertFalse(vecElement.matchesFilter(text5));
		assertFalse(vecElement.matchesFilter(text6));
		assertTrue(vecElement.matchesFilter(text7));
		assertTrue(vecElement.matchesFilter(text8));
		assertTrue(vecElement.matchesFilter(text9));
		assertFalse(vecElement.matchesFilter(text10));
		assertTrue(vecElement.matchesFilter(text11));
		assertFalse(vecElement.matchesFilter(text12));
		assertFalse(vecElement.matchesFilter(text13));
		assertTrue(vecElement.matchesFilter(text14));
		assertFalse(vecElement.matchesFilter(text15));
		assertTrue(vecElement.matchesFilter(text16));
	}

}