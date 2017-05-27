package ch.unibe.scg.curtys.vectorization.components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by scurty on 02.02.17.
 */
public class ReproductionElementsTest {

	private String text1 = "Currently Rhino optimizer generates one Java class per JavaScript function which\n"
			+ "may lead to significant runtime overhead. I think it would be worth to try to\n"
			+ "replace that by a single class with a switch dispatch to select code for a\n"
			+ "particular function. I open this report to record work on it.";

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

	private String text4 = "A list:\n"
			+ "1. a list item";

	private String text5 = "A list:\n"
			+ "* a list item";

	private String text6 = "A list:\n"
			+ "- a list item";

	private ReproductionElements vecElement = new ReproductionElements();

	@Test
	public void filterTest() {
		assertFalse(vecElement.matchesFilter(text1));
		assertFalse(vecElement.matchesFilter(text2));
		assertFalse(vecElement.matchesFilter(text3));
		assertFalse(vecElement.matchesFilter(text4));
		assertFalse(vecElement.matchesFilter(text5));
		assertFalse(vecElement.matchesFilter(text6));
	}

}