package ch.unibe.scg.curtys.vectorization.components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author curtys
 */
public class KeywordVectorComponentTest {

	private String text1 = "Collect the frequently discussed issues from the mailing list and the wiki into an FAQ document.";

	private String text2 = "Checking in src/org/mozilla/javascript/ScriptRuntime.java;\n"
			+ "/cvsroot/mozilla/js/rhino/src/org/mozilla/javascript/ScriptRuntime.java,v  <--  ScriptRuntime.java\n"
			+ "new revision: 1.319; previous revision: 1.318\n"
			+ "done\n"
			+ "Checking in testsrc/doctests/array.length.doctest;\n"
			+ "/cvsroot/mozilla/js/rhino/testsrc/doctests/array.length.doctest,v  <--  array.length.doctest\n"
			+ "initial revision: 1.1\n"
			+ "done";

	private String text3 = "Currently Rhino optimizer generates one Java class per JavaScript function which\n"
			+ "may lead to significant runtime overhead. I think it would be worth to try to\n"
			+ "replace that by a single class with a switch dispatch to select code for a\n"
			+ "particular function. I open this report to record work on it.";

	private String text4 = "exceptional RuntimeException";
	private String text5 = "exception!";



	@Test
	public void matchesRepository() throws Exception {

		KeywordVectorComponent vecElement = new KeywordVectorComponent("document");
		assertTrue(vecElement.matchesRepository(text1));
		assertFalse(vecElement.matchesRepository(text2));
		assertFalse(vecElement.matchesRepository(text3));

		vecElement = new KeywordVectorComponent("faq");
		assertTrue(vecElement.matchesRepository(text1));
		assertFalse(vecElement.matchesRepository(text2));
		assertFalse(vecElement.matchesRepository(text3));

		vecElement = new KeywordVectorComponent("faq", "optimizer");
		assertTrue(vecElement.matchesRepository(text1));
		assertFalse(vecElement.matchesRepository(text2));
		assertTrue(vecElement.matchesRepository(text3));

		vecElement = new KeywordVectorComponent("rhino", "javascript");
		assertFalse(vecElement.matchesRepository(text1));
		assertTrue(vecElement.matchesRepository(text2));
		assertTrue(vecElement.matchesRepository(text3));

		vecElement = new KeywordVectorComponent("exception");
		assertFalse(vecElement.matchesRepository(text4));
		assertTrue(vecElement.matchesRepository(text5));
	}

}