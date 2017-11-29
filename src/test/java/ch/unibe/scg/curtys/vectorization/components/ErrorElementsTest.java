package ch.unibe.scg.curtys.vectorization.components;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author curtys
 */
public class ErrorElementsTest {

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

	private String text5 = "FileNotFoundException";

	private String text6 = "Simply compare JspRuntimeContext.checkCompile(), this calls \n"
			+ "ctxt.incrementRemoved() if a FileNotFoundException occur. JspServletWrapper \n"
			+ "only set a 404 if a FileNotFoundException occur and finish.";

	private String text7 = "catch (FileNotFoundException ex)";

	private String text8 = "Unexpected SyntaxError for /^{(.*)\\}$/";


	private ErrorElements vecElement = new ErrorElements();

	@Test
	public void filterTest() {
		assertTrue(vecElement.matchesFilter(text1));
		assertFalse(vecElement.matchesFilter(text2));
		assertFalse(vecElement.matchesFilter(text3));
		assertFalse(vecElement.matchesFilter(text4));
		assertTrue(vecElement.matchesFilter(text5));
		assertTrue(vecElement.matchesFilter(text6));
		assertTrue(vecElement.matchesFilter(text7));
		assertTrue(vecElement.matchesFilter(text8));
	}


}