package ch.unibe.scg.curtys.vectorization;


import ch.unibe.scg.curtys.vectorization.io.JsonIO;
import ch.unibe.scg.curtys.vectorization.issue.Issue;
import ch.unibe.scg.curtys.vectorization.issue.IssueDeserializationMappingImpl;
import ch.unibe.scg.curtys.vectorization.testutils.VectorArchive;
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
	private static final double MIN_PRECISION = 0.95;
	private final static boolean VERBOSE = false;
	private final static boolean DEBUG = true;

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

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "506");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-248
	 */
	@Test
	public void testVectorization2() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-248.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("JCR", "248");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-565
	 */
	@Test
	public void testVectorization3() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-565.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "565");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=190685
	 */
	@Test
	public void testVectorization4() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-190685.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "190685");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=16113
	 */
	@Test
	public void testVectorization5() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-16113.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "16113");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: 105498 from eclipse project https://bugs.eclipse.org/bugs/show_bug.cgi?id=105498
	 */
	@Test
	public void testVectorization6() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/2_105498_3.json").getPath());
		Issue issue = JsonIO.mapIssue(path, IssueDeserializationMappingImpl.class);

		int[] expected = createExpected(0, 1, 0,
				0, 1, 1, 0,
				0, 0, 0, 0,
				0, 1, 0, 0,
				0, 0, 0, 1,
				0, 1, 1, 1);
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
				0, 1, 1, 1);
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
				0, 1, 1, 1);
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
				1, 1, 0, 1,
				0, 1, 0, 0,
				0, 0, 0, 1,
				0, 1, 1, 1);
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
				0, 1, 1, 1);
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
				0, 1, 1, 0);
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-1072
	 */
	@Test
	public void testVectorization12() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-1072.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "1072");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-911
	 */
	@Test
	public void testVectorization13() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-911.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "911");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-815
	 */
	@Test
	public void testVectorization14() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-815.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "815");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-582
	 */
	@Test
	public void testVectorization15() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-582.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "582");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-450
	 */
	@Test
	public void testVectorization16() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-450.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "450");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-315
	 */
	@Test
	public void testVectorization17() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-315.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "315");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-303
	 */
	@Test
	public void testVectorization18() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-303.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "303");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-295
	 */
	@Test
	public void testVectorization19() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-295.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "295");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-244
	 */
	@Test
	public void testVectorization20() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-244.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "244");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/HTTPCLIENT-167
	 */
	@Test
	public void testVectorization21() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/HTTPCLIENT-167.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("HTTPCLIENT", "167");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-316
	 */
	@Test
	public void testVectorization22() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-316.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("JCR", "316");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-481
	 */
	@Test
	public void testVectorization23() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-481.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("JCR", "481");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-533
	 */
	@Test
	public void testVectorization24() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-533.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("JCR", "533");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-695
	 */
	@Test
	public void testVectorization25() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-695.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("JCR", "695");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-814
	 */
	@Test
	public void testVectorization26() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-814.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("JCR", "814");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-1047
	 */
	@Test
	public void testVectorization27() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-1047.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("JCR", "1047");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-1128
	 */
	@Test
	public void testVectorization28() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-1128.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("JCR", "1128");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/JCR-1268
	 */
	@Test
	public void testVectorization29() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/JCR-1268.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("JCR", "1268");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-252
	 */
	@Test
	public void testVectorization30() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-252.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "252");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-317
	 */
	@Test
	public void testVectorization31() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-317.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "317");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-454
	 */
	@Test
	public void testVectorization32() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-454.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "454");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-598
	 */
	@Test
	public void testVectorization33() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-598.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "598");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-667
	 */
	@Test
	public void testVectorization34() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-667.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "667");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-991
	 */
	@Test
	public void testVectorization35() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-991.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "991");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-1153
	 */
	@Test
	public void testVectorization36() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-1153.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "1153");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-1425
	 */
	@Test
	public void testVectorization37() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-1425.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "1425");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-1564
	 */
	@Test
	public void testVectorization38() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-1564.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "1564");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://issues.apache.org/jira/browse/LUCENE-1812
	 */
	@Test
	public void testVectorization39() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/LUCENE-1812.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("LUCENE", "1812");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=132217
	 */
	@Test
	public void testVectorization40() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-132217.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "132217");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=185165
	 */
	@Test
	public void testVectorization41() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-185165.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "185165");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=219055
	 */
	@Test
	public void testVectorization42() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-219055.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "219055");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=334900
	 */
	@Test
	public void testVectorization43() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-334900.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "334900");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=367385
	 */
	@Test
	public void testVectorization44() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-367385.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "367385");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=399958
	 */
	@Test
	public void testVectorization45() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-399958.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "399958");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=433878
	 */
	@Test
	public void testVectorization46() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-433878.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "433878");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=508527
	 */
	@Test
	public void testVectorization47() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-508527.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "508527");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=540724
	 */
	@Test
	public void testVectorization48() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-540724.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "540724");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bugzilla.mozilla.org/show_bug.cgi?id=686797
	 */
	@Test
	public void testVectorization49() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/RHINO-686797.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("RHINO", "686797");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=17492
	 */
	@Test
	public void testVectorization50() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-17492.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "17492");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=20029
	 */
	@Test
	public void testVectorization51() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-20029.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "20029");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=28875
	 */
	@Test
	public void testVectorization52() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-28875.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "28875");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=30028
	 */
	@Test
	public void testVectorization53() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-30028.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "30028");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=31592
	 */
	@Test
	public void testVectorization54() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-31592.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "31592");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=32431
	 */
	@Test
	public void testVectorization55() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-32431.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "32431");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=33810
	 */
	@Test
	public void testVectorization56() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-33810.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "33810");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=39433
	 */
	@Test
	public void testVectorization57() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-39433.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "39433");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=41661
	 */
	@Test
	public void testVectorization58() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-41661.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "41661");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=45255
	 */
	@Test
	public void testVectorization59() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-45255.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "45255");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}

	/**
	 * Issue in question: https://bz.apache.org/bugzilla/show_bug.cgi?id=51042
	 */
	@Test
	public void testVectorization60() throws Exception {
		Path path = Paths.get(VectorizationTest.class.getResource("/testdata/TOMCAT-51042.json").getPath());
		Issue issue = JsonIO.mapIssue(path);

		int[] expected = VectorArchive.getVector("TOMCAT", "51042");
		Vector vec = engine.createVector(issue);
		print(expected, vec.elements);
		assertSimilarity(expected, vec.elements);
	}


	private void print(int[] expected, int[] actual) {
		if (!VERBOSE) return;
			printVectorLegend(expected, actual);
	}

	private void printVectorLegend(int[] expected, int[] actual) {
		if (!VERBOSE && !DEBUG) return;
		System.out.println("           0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22");
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
				+ "13: highPriorityElement\n"
				+ "14: reproductionElements\n"
				+ "15: screenshotElements\n"
				+ "16: expectedBehaviour\n"
				+ "17: observedBehaviour\n"
				+ "18: testCaseKeywords\n"
				+ "19: versionElements\n"
				+ "20: componentElements\n"
				+ "21: productElements\n"
				+ "22: lowPriorityElement");
	}

	private int[] createExpected(int errorElements, int operationalElements, int codeSnippetElements,
			int docKeywords, int enhanceKeywords, int requestKeywords, int visibilityKeywords,
			int actionKeywords, int namingKeywords, int implementationKeywords, int linkElementComponent,
			int patchElementComponent, int sysSpecElement, int highPriorityElement, int reproductionElements,
			int screenshotElements, int expectedBehaviour, int observedBehaviour, int testCasesElement,
			int versionElement, int componentElement, int productElement, int lowPriorityElement) {
		return new int[] {errorElements, operationalElements, codeSnippetElements, docKeywords, enhanceKeywords,
		requestKeywords, visibilityKeywords, actionKeywords, namingKeywords, implementationKeywords,
		linkElementComponent, patchElementComponent, sysSpecElement, highPriorityElement, reproductionElements,
		screenshotElements, expectedBehaviour, observedBehaviour, testCasesElement, versionElement, componentElement,
		productElement, lowPriorityElement};
	}

	private void assertSimilarity(int[] expected, int[] actual) {
		if(expected == null || actual == null) {
			throw new AssertionFailedError("Vector is null");
		}
		if(expected.length != actual.length) {
			throw new AssertionFailedError("Length of arrays do not match");
		}
		List<Integer> confusion = new ArrayList<>();
		for (int i = 0; i < expected.length; i++) {
			if (expected[i] != actual[i]) {
				confusion.add(i);
				if (DEBUG) {
					System.out.println("WARN: Array elements at index " + i + " do not match. Expected: "
							+ expected[i] + " Actual: " + actual[i]);
					if (!VERBOSE) printVectorLegend(expected, actual);
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
