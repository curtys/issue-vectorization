package ch.unibe.scg.curtys.vectorization;


import ch.unibe.scg.curtys.vectorization.io.JSONReader;
import ch.unibe.scg.curtys.vectorization.issue.Issue;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by scurty on 25.02.17.
 */
public class VectorizationTest {

	private final VectorizationEngine engine = new VectorizationEngine();

	@Before
	public void setUp() {
		engine.initDefaults();

	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-506
	 */
	@Test
	public void testVectorization1() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-506.json").getPath());
		Issue issue = JSONReader.mapIssue(path);

		int[] expected = {0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1};
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertArrayEquals(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-248
	 */
	@Test
	public void testVectorization2() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-248.json").getPath());
		Issue issue = JSONReader.mapIssue(path);

		int[] expected = {0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1};
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertArrayEquals(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-565
	 */
	@Test
	public void testVectorization3() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-565.json").getPath());
		Issue issue = JSONReader.mapIssue(path);

		int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1};
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertArrayEquals(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=190685
	 */
	@Test
	public void testVectorization4() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-190685.json").getPath());
		Issue issue = JSONReader.mapIssue(path);

		int[] expected = createExpected(1, 1, 1,
				1, 0, 1, 0,
				0, 0, 0, 1,
				1, 1, 0, 1,
				0, 1, 0, 1,
				1, 1, 1);
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertArrayEquals(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=16113
	 */
	@Test
	public void testVectorization5() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-16113.json").getPath());
		Issue issue = JSONReader.mapIssue(path);

		int[] expected = createExpected(1, 1, 1,
				0, 0, 0, 1,
				0, 0, 0, 0,
				1, 0, 0, 1,
				0, 0, 0, 1,
				1, 1, 1);
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertArrayEquals(expected, vec.elements);
	}


	private void print(int[] expected, int[] actual) {
		System.out.println("           0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21");
		System.out.println("Expected: " + Arrays.toString(expected));
		System.out.println("Actual:   " + Arrays.toString(actual));
		System.out.println("0:  errorElements\n"
				+ "1:  operationalElements\n"
				+ "2:  codeSnippetElements\n"
				+ "3:  docKeywords\n"
				+ "4:  enhanceKeywords\n"
				+ "5:  requestKeywords\n"
				+ "6:  visibilityKeywords\n"
				+ "7:  actionKeywords\n"
				+ "8:  namingKeywords\n"
				+ "9:  implementationKeywords\n"
				+ "10: linkElementsComponent\n"
				+ "11: patchElementsComponent\n"
				+ "12: sysSpecElement\n"
				+ "13: priorityElement\n"
				+ "14: reproductionElements\n"
				+ "15: screenshotElements\n"
				+ "16: expectedBehaviour\n"
				+ "17: observedBehaviour\n"
				+ "18: testCaseKeywords\n"
				+ "19: versionElements\n"
				+ "20: componentElements\n"
				+ "21: productElements");
	}

	private int[] createExpected(int errorElements, int operationalElements, int codeSnippetElements,
			int docKeywords, int enhanceKeywords, int requestKeywords, int visibilityKeywords,
			int actionKeywords, int namingKeywords, int implementationKeywords, int linkElementComponent,
			int patchElementComponent, int sysSpecElement, int priorityElement, int reproductionElements,
			int screenshotElements, int expectedBehaviour, int observedBehaiour, int testCasesElement,
			int versionElement, int componentElement, int productElement) {
		return new int[] {errorElements, operationalElements, codeSnippetElements, docKeywords, enhanceKeywords,
		requestKeywords, visibilityKeywords, actionKeywords, namingKeywords, implementationKeywords,
		linkElementComponent, patchElementComponent, sysSpecElement, priorityElement, reproductionElements,
		screenshotElements, expectedBehaviour, observedBehaiour, testCasesElement, versionElement, componentElement,
		productElement};
	}
}
