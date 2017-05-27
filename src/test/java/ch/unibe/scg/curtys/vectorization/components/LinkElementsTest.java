package ch.unibe.scg.curtys.vectorization.components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by scurty on 02.02.17.
 */
public class LinkElementsTest {

	private String text1 = "In the page\n"
			+ "http://jakarta.apache.org/tomcat/tomcat-5.5-doc/jndi-datasource-examples-howto.html\n"
			+ "the link to the \"DBCP javadocs\" is broken.\n"
			+ "It could be replaced with\n"
			+ "http://jakarta.apache.org/commons/dbcp/configuration.html (describe\n"
			+ "configuration parameters)\n"
			+ "or http://jakarta.apache.org/commons/dbcp/apidocs/index.html (the bare javadocs)";

	private String text2 = "http://jakarta.apache.org/tomcat/tomcat-5.5-doc/jndi-datasource-examples-howto.xml";

	private String text3 = "sample.html ";

	private String text4 = "sample.xhtml ";

	private  String text5 = "Checking in src/org/mozilla/javascript/ScriptRuntime.java";

	private LinkElements vecElement = new LinkElements();

	@Test
	public void filterTest() {
		assertTrue(vecElement.matchesFilter(text1));
		assertTrue(vecElement.matchesFilter(text2));
		assertTrue(vecElement.matchesFilter(text3));
		assertTrue(vecElement.matchesFilter(text4));
		assertFalse(vecElement.matchesFilter(text5));
	}

}