package ch.unibe.scg.curtys.vectorization.testutils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author curtys
 */
public class VectorArchive {

	private static Map<IssueKey, int[]> archive = new HashMap<>();

	static {
		String project = "HTTPCLIENT";
		// https://issues.apache.org/jira/browse/HTTPCLIENT-167
		String id = "167";
		int [] vector = createExpectedVector(0, 1, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				1, 0, 1, 0,
				0, 0, 0, 0,
				1, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-244
		id = "244";
		vector = createExpectedVector(0, 1, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				1, 0, 1, 0,
				0, 0, 0, 0,
				1, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-295
		id = "295";
		vector = createExpectedVector(1, 1, 1,
				0, 1, 1, 1,
				1, 0, 1, 1,
				1, 0, 0, 0,
				0, 0, 0, 1,
				1, 1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-303
		id = "303";
		vector = createExpectedVector(1, 1, 1,
				1, 1, 1, 0,
				0, 0, 0, 1,
				1, 0, 0, 0,
				0, 0, 0, 0,
				1, 1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-315
		id = "315";
		vector = createExpectedVector(0, 1, 1,
				0, 0, 0, 0,
				0, 0, 0, 0,
				1, 0, 1, 0,
				0, 0, 0, 0,
				1, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-450
		id = "450";
		vector = createExpectedVector(0, 1, 1,
				0, 0, 0, 1,
				0, 0, 0, 0,
				0, 0, 1, 0,
				0, 0, 0, 1,
				1, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-506
		id = "506";
		vector = createExpectedVector(0, 1, 0,
				0, 1, 1, 0, 0,
				0, 1, 1,
				1, 1, 1,
				0, 0, 0,
				0, 0, 1, 1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-582
		id = "582";
		vector = createExpectedVector(0, 0, 0,
				1, 1, 1, 0,
				1, 1, 0, 0,
				1, 0, 1, 0,
				0, 0, 0, 0,
				0, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-815
		id = "815";
		vector = createExpectedVector(0, 1, 0,
				1, 1, 0, 0,
				1, 0, 0, 1,
				0, 1, 1, 0,
				0, 0, 0, 0,
				0, 0, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-911
		id = "911";
		vector = createExpectedVector(1, 1, 1,
				0, 1, 1, 1,
				1, 1, 1, 1,
				1, 1, 0, 0,
				0, 0, 0, 0,
				1, 1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/HTTPCLIENT-1072
		id = "1072";
		vector = createExpectedVector(0, 0, 0,
				0, 0, 1, 0,
				0, 0, 0, 1,
				0, 0, 1, 0,
				0, 0, 0, 0,
				1, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		project = "JCR";

		// https://issues.apache.org/jira/browse/JCR-248
		id = "248";
		vector = createExpectedVector(0, 1, 1,
				0, 1, 1, 1, 0,
				1, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/JCR-248
		id = "248";
		vector = createExpectedVector(0, 1, 1,
				0, 1, 1, 1, 0,
				1, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		//https://issues.apache.org/jira/browse/JCR-316
		id = "316";
		vector = createExpectedVector(0, 1, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				1, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/JCR-481
		id = "481";
		vector = createExpectedVector(0, 1, 1,
				1, 0, 1, 0,
				0, 0, 0, 1,
				0, 0, 1, 0,
				0, 0, 0, 1,
				0, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/JCR-533
		id = "533";
		vector = createExpectedVector(1, 1, 1,
				1, 0, 0, 1,
				0, 0, 0, 1,
				0, 1, 1, 0,
				0, 0, 0, 0,
				1, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/JCR-695
		id = "695";
		vector = createExpectedVector(0, 1, 0,
				0, 0, 0, 1,
				0, 0, 0, 1,
				1, 1, 1, 0,
				0, 0, 0, 1,
				0, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/JCR-814
		id = "814";
		vector = createExpectedVector(0, 1, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/JCR-1047
		id = "1047";
		vector = createExpectedVector(0, 0, 0,
				1, 0, 0, 0,
				0, 0, 0, 1,
				0, 0, 1, 0,
				0, 0, 0, 0,
				0, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/JCR-1128
		id = "1128";
		vector = createExpectedVector(1, 1, 0,
				0, 0, 0, 0,
				0, 1, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 0,
				1, 1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/JCR-1268
		id = "1268";
		vector = createExpectedVector(0, 1, 0,
				0, 0, 0, 0,
				1, 1, 1, 0,
				0, 0, 1, 0,
				0, 0, 0, 0,
				0, 1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		project = "LUCENE";

		// https://issues.apache.org/jira/browse/LUCENE-252
		id = "252";
		vector = createExpectedVector(1, 1, 1,
				1, 1, 1, 1,
				0, 1, 1,
				0, 1, 0,
				1, 0, 0,
				0, 0, 0, 1,
				1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-317
		id = "317";
		vector = createExpectedVector(1, 1, 1,
				0, 0, 0, 0,
				0, 0, 0,
				0, 1, 1,
				0, 0, 0,
				0, 0, 0, 0,
				1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-454
		id = "454";
		vector = createExpectedVector(0, 1, 0,
				1, 1, 0, 0,
				0, 0, 0,
				0, 1, 0,
				1, 0, 0,
				0, 0, 0, 0,
				0, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-565
		id = "565";
		vector = createExpectedVector(1, 1, 1,
				1, 1, 1, 1,
				1, 1, 1,
				1, 1, 1,
				1, 0, 0,
				1, 0, 1, 0,
				1, 1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-598
		id = "598";
		vector = createExpectedVector(0, 1, 0,
				1, 0, 1, 0,
				1, 0, 0,
				0, 1, 0,
				0, 0, 0,
				0, 0, 1, 0,
				1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-667
		id = "667";
		vector = createExpectedVector(1, 1, 0,
				0, 0, 0, 0,
				1, 0, 0,
				0, 1, 0,
				0, 0, 0,
				0, 0, 0, 0,
				1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-991
		id = "991";
		vector = createExpectedVector(1, 1,
				1, 1, 0, 0,
				0, 0, 0, 0,
				0, 1, 0,
				0, 0, 0,0,
				0, 0, 1,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-1153
		id = "1153";
		vector = createExpectedVector(0, 1,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 0,
				0, 0, 0,0,
				0, 0, 0,0,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-1425
		id = "1425";
		vector = createExpectedVector(0, 1,
				1, 1, 1, 1,
				1, 1, 0, 1,
				0, 1, 0,
				0, 0, 0,0,
				0, 0, 0,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-1564
		id = "1564";
		vector = createExpectedVector(1, 1,
				0, 1, 0, 0,
				0, 0, 0, 0,
				1, 1, 0,
				0, 0, 0,0,
				0, 0, 1,0,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://issues.apache.org/jira/browse/LUCENE-1812
		id = "1812";
		vector = createExpectedVector(0, 1,
				0, 1, 1, 1,
				1, 1, 1, 1,
				1, 1, 0,
				1, 0, 0,0,
				0, 1, 0,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		project = "RHINO";

		// https://bugzilla.mozilla.org/show_bug.cgi?id=132217
		id = "132217";
		vector = createExpectedVector(0, 1,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 1,
				0, 0, 0,1,
				0, 1, 0,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=185165
		id = "185165";
		vector = createExpectedVector(1, 1,
				1, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 1,
				0, 1, 0,1,
				1, 1, 0,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=190685
		id = "190685";
		vector = createExpectedVector(1, 1, 1,
				1, 0, 1, 0,
				0, 0, 0, 1,
				1, 1, 0, 1,
				0, 1, 1, 1,
				0, 1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=219055
		id = "219055";
		vector = createExpectedVector(0, 1,
				0, 0, 0, 0,
				1, 1, 1, 0,
				0, 1, 0,
				0, 0, 0,0,
				0, 0, 0,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=334900
		id = "334900";
		vector = createExpectedVector(0, 1,
				1, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 1,
				0, 1, 0,1,
				1, 0, 0,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=367385
		id = "367385";
		vector = createExpectedVector(0, 1,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 1,
				0, 0, 0,0,
				0, 0, 0,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=399958
		id = "399958";
		vector = createExpectedVector(1, 1,
				1, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 1,
				0, 0, 0,0,
				0, 0, 0,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=433878
		id = "433878";
		vector = createExpectedVector(0, 1,
				1, 0, 0, 1,
				0, 0, 0, 0,
				1, 1, 1,
				0, 0, 0,0,
				0, 0, 0,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=508527
		id = "508527";
		vector = createExpectedVector(1, 1,
				1, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 1,
				0, 0, 0,1,
				1, 0, 0,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=540724
		id = "540724";
		vector = createExpectedVector(0, 1,
				0, 0, 1, 1,
				0, 0, 1, 1,
				1, 1, 0,
				0, 0, 0,0,
				0, 0, 1,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://bugzilla.mozilla.org/show_bug.cgi?id=686797
		id = "686797";
		vector = createExpectedVector(1, 1,
				0, 0, 0, 0,
				0, 0, 0, 0,
				1, 0, 1,
				0, 1, 0,1,
				1, 1, 1,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		project = "TOMCAT";

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=16113
		id = "16113";
		vector = createExpectedVector(1, 1, 1,
				0, 0, 0, 1,
				1, 0, 0, 0,
				1, 0, 0, 1,
				0, 0, 0, 1,
				1, 1, 1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=17492
		id = "17492";
		vector = createExpectedVector(0, 0,
				0, 1, 0, 0,
				0, 0, 0, 0,
				0, 0, 0,
				1, 0, 0,1,
				0, 0, 1,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=20029
		id = "20029";
		vector = createExpectedVector(0, 1,
				1, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 1,
				0, 0, 0,0,
				0, 0, 1,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=28875
		id = "28875";
		vector = createExpectedVector(1, 1,
				1, 0, 0, 0,
				1, 0, 0, 0,
				0, 1, 0,
				1, 0, 1,1,
				0, 1, 1,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=30028
		id = "30028";
		vector = createExpectedVector(1, 1,
				1, 0, 1, 1,
				1, 0, 0, 0,
				0, 0, 0,
				0, 0, 0,0,
				0, 0, 1,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=31592
		id = "31592";
		vector = createExpectedVector(0, 1,
				0, 1, 1, 0,
				0, 0, 0, 0,
				0, 0, 0,
				0, 0, 0,0,
				0, 0, 1,1,
				1, 1);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=32431
		id = "32431";
		vector = createExpectedVector(0, 1,
				1, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 1,
				1, 0, 0,0,
				0, 0, 1,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=33810
		id = "33810";
		vector = createExpectedVector(1, 1,
				1, 0, 0, 1,
				0, 0, 0, 0,
				1, 0, 1,
				1, 0, 0,0,
				0, 0, 1,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=39433
		id = "39433";
		vector = createExpectedVector(0, 1,
				1, 1, 0, 0,
				0, 0, 0, 0,
				0, 0, 0,
				1, 0, 0,0,
				0, 0, 1,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=41661
		id = "41661";
		vector = createExpectedVector(0, 1,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 1, 0,
				1, 1, 0,0,
				0, 0, 1,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=45255
		id = "45255";
		vector = createExpectedVector(0, 1,
				0, 1, 0, 1,
				1, 1, 0, 1,
				1, 1, 1,
				1, 0, 0,0,
				0, 0, 1,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);

		// https://bz.apache.org/bugzilla/show_bug.cgi?id=51042
		id = "51042";
		vector = createExpectedVector(0, 1,
				0, 0, 0, 0,
				0, 0, 0, 0,
				0, 0, 0,
				1, 0, 0,0,
				0, 0, 1,1,
				1, 0);
		archive.put(new IssueKey(project, id), vector);
	}


	public static int[] getVector(String project, String id) {
		IssueKey key = new IssueKey(project, id);
		return archive.get(key);
	}

	public static Collection<int[]> getAll() {
		return archive.values();
	}

	public static Map<IssueKey, int[]> getArchive() {
		return archive;
	}

	private static int[] createExpectedVector(int errorElements, int operationalElements, int codeSnippetElements,
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

	public static class IssueKey {
		String project;
		String id;

		IssueKey(String project, String id) {
			this.project = project;
			this.id = id;
		}

		public String getProject() {
			return project;
		}

		public String getId() {
			return id;
		}

		@Override public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			IssueKey issueKey = (IssueKey) o;
			return Objects.equals(project, issueKey.project) &&
					Objects.equals(id, issueKey.id);
		}

		@Override public int hashCode() {
			return Objects.hash(project, id);
		}
	}
}
