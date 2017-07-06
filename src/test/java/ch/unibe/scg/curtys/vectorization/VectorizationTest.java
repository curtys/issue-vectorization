package ch.unibe.scg.curtys.vectorization;


import ch.unibe.scg.curtys.vectorization.io.JsonIO;
import ch.unibe.scg.curtys.vectorization.issue.Issue;
import ch.unibe.scg.curtys.vectorization.issue.IssueDeserializationMappingImpl;
import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author curtys
 */
public class VectorizationTest {

	private final VectorizationEngine engine = new VectorizationEngine();
	private static final double MIN_PRECISION = 0.9;
	private final static boolean VERBOSE = true;

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
		Issue issue = JsonIO.mapIssue(path);

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
		Issue issue = JsonIO.mapIssue(path);

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
		Issue issue = JsonIO.mapIssue(path);

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
		Issue issue = JsonIO.mapIssue(path);

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
		Issue issue = JsonIO.mapIssue(path);

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

	/**
	 * Issue in question: 105498 from eclipse project https://bugs.eclipse.org/bugs/show_bug.cgi?id=105498
	 */
	@Test
	public void testVectorization6() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/2_105498_3.json").getPath());
		Issue issue = JsonIO.mapIssue(path, IssueDeserializationMappingImpl.class);

		int[] expected = createExpected(0, 1, 0,
				0, 1, 0, 0,
				0, 0, 0, 0,
				0, 1, 0, 0,
				0, 0, 0, 0,
				0, 1, 1);
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: 30168 from firefox project
	 */
	@Test
	public void testVectorization7() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/0_30168_1.json").getPath());
		Issue issue = JsonIO.mapIssue(path, IssueDeserializationMappingImpl.class);

		int[] expected = createExpected(0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 1,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 1);
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: 5575 from eclipse project
	 */
	@Test
	public void testVectorization8() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/2_5575_3.json").getPath());
		Issue issue = JsonIO.mapIssue(path, IssueDeserializationMappingImpl.class);

		int[] expected = createExpected(0, 0, 0,
				0, 0, 0, 0,
				0, 1, 0, 0,
				0, 1, 0, 0,
				0, 0, 0, 0,
				0, 1, 1);
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugs.eclipse.org/bugs/show_bug.cgi?id=29802
	 */
	@Test
	public void testVectorization9() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/3_29802_1.json").getPath());
		Issue issue = JsonIO.mapIssue(path, IssueDeserializationMappingImpl.class);

		int[] expected = createExpected(0, 1, 1,
				0, 0, 0, 1,
				0, 1, 0, 1,
				0, 1, 0, 0,
				0, 0, 0, 0,
				0, 1, 1);
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugs.eclipse.org/bugs/show_bug.cgi?id=152222
	 */
	@Test
	public void testVectorization10() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/3_152222_2.json").getPath());
		Issue issue = JsonIO.mapIssue(path, IssueDeserializationMappingImpl.class);

		int[] expected = createExpected(0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 0, 0,
				0, 0, 0, 0,
				0, 1, 1);
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: ???
	 */
	@Test
	public void testVectorization11() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/5_13359_1.json").getPath());
		Issue issue = JsonIO.mapIssue(path, IssueDeserializationMappingImpl.class);

		int[] expected = createExpected(0, 0, 0,
				0, 0, 0, 0,
				0, 1, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 1);
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}


	private void print(int[] expected, int[] actual) {
		if (!VERBOSE) return;
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

	private void assertSimilarity(int[] expected, int[] actual) {
		if(expected.length != actual.length) {
			throw new AssertionFailedError("Length of arrays do not match");
		}
		List<Integer> confusion = new ArrayList<>();
		for (int i = 0; i < expected.length; i++) {
			if (expected[i] != actual[i]) {
				confusion.add(i);
				if (VERBOSE) {
					System.out.println("WARN: Array elements at index " + i + " do not match. Expected: "
							+ expected[i] + " Actual: " + actual[i]);
				}
			}
		}
		double similarity = 1 - ((double) confusion.size() / (double) expected.length);
		if (similarity < MIN_PRECISION) {
			throw new AssertionFailedError("Arrays differ beyond similarity threshold. "
					+ "Assertion failed on " + confusion.size() + " of "
					+ expected.length + " elements. Similarity " + similarity);
		}
	}
}
