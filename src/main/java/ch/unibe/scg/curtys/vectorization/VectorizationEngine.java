package ch.unibe.scg.curtys.vectorization;

import ch.unibe.scg.curtys.vectorization.components.*;
import ch.unibe.scg.curtys.vectorization.io.CSVWriter;
import ch.unibe.scg.curtys.vectorization.issue.Issue;
import ch.unibe.scg.curtys.vectorization.label.LabelMapper;
import ch.unibe.scg.curtys.vectorization.preprocessors.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author curtys
 */
public class VectorizationEngine {
	private List<VectorComponent> components;
	private List<Issue> issues;
	private boolean verbose = false;
	private static final Logger LOG = LoggerFactory.getLogger(VectorizationEngine.class);
	private boolean integrateLabels = false;
	private Preprocessor preprocessor;
	private boolean isPreprocessed = false;
	private LabelMapper labelMapper;

	VectorizationEngine() {}

	public static VectorizationEngineBuilder builder() {
		return new VectorizationEngineBuilder();
	}

	void initDefaults() {
		components = new ArrayList<>();
		// 0
		ErrorElements errorElements = new ErrorElements(
				"exception", "failure");
		// 1
		OperationalElements operationalElements = new OperationalElements();
		// 2
		CodeSnippetElements codeSnippetElements = new CodeSnippetElements();
		// 3
		KeywordVectorComponent docKeywords = new KeywordVectorComponent(
				"doc","document", "documentation", "logo", "image", "link", "javadoc");
		// 4
		KeywordVectorComponent enhanceKeywords = new KeywordVectorComponent(
				"improvement", "improve", "optimization", "optimize", "performance",
				"overhead", "logging", "speedup", "easier");
		// 5
		KeywordVectorComponent requestKeywords = new KeywordVectorComponent(
				"feature", "features", "support", "implement");
		// 6
		KeywordVectorComponent visibilityKeywords = new KeywordVectorComponent(
				"visibility", "private", "public", "protected", "package private");
		// 7
		KeywordVectorComponent actionKeywords = new KeywordVectorComponent(
				"refactor", "refactoring", "rename", "renaming", "extract", "extracting", "move");
		// 8
		KeywordVectorComponent namingKeywords = new KeywordVectorComponent(
				"name", "naming", "naming convention", "simple name");
		// 9
		KeywordVectorComponent implementationKeywords = new KeywordVectorComponent(
				"subclass", "subclassing", "extend", "extends", "overload", "overloading", "overloaded");
		// 10
		LinkElements linkElementsComponent = new LinkElements();
		// 11
		PatchElements patchElementsComponent = new PatchElements();
		// 12
		SystemSpecificationsElements sysSpecElement = new SystemSpecificationsElements(
				"windows", "win10", "win7", "xp", "linux", "ubuntu", "debian", "fedora", "mac",
				"nvidia", "amd", "ati", "intel", "os", "operating system");
		// 13
		HighPriorityElements priorityElement = new HighPriorityElements();
		// 14
		ReproductionElements reproductionElements = new ReproductionElements(
				"steps to reproduce", "how to reproduce", "reproduce");
		// 15
		ScreenshotElements screenshotElements = new ScreenshotElements();
		// 16
		KeywordVectorComponent expectedBehaviorComponent = new KeywordVectorComponent(
				"expected", "expected behavior", "expected behaviour");
		// 17
		KeywordVectorComponent observedBehaviorComponent = new KeywordVectorComponent(
				"observed", "observed behavior", "observed behaviour", "actual behaviour", "actual behavior");
		// 18
		KeywordVectorComponent testCasesComponent = new KeywordVectorComponent(
				"test case", "test cases", "@Test");
		// 19
		VersionElements versionElements = new VersionElements();
		// 20
		ComponentElements componentElements = new ComponentElements();
		// 21
		ProductElements productElements = new ProductElements();

		components.addAll(Arrays.asList(errorElements, operationalElements, codeSnippetElements,
				docKeywords, enhanceKeywords,
				requestKeywords, visibilityKeywords, actionKeywords, namingKeywords,
				implementationKeywords, linkElementsComponent, patchElementsComponent,
				sysSpecElement, priorityElement, reproductionElements, screenshotElements,
				expectedBehaviorComponent, observedBehaviorComponent, testCasesComponent,
				versionElements, componentElements, productElements));
	}

	public void vectorize(String outPath) {
		if (!isPreprocessed)
			prepareIssues();
		final int[] completed = { 1 };

		Path path = Paths.get(outPath);
		File f = path.toFile();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(Files.newOutputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		final PrintWriter finalWriter = writer;
		assert finalWriter != null;
		issues.forEach(i -> {
			Vector vec = integrateLabels ? createVector(i, getLabel(i)) : createVector(i);
			String csvData = CSVWriter.arrayToCSV(vec.elements);
			finalWriter.println(csvData);
			if (verbose && completed[0] % 100 == 0)
				LOG.info("Progress: " +
						completed[0] + " / " + issues.size());
			completed[0]++;
		});
		finalWriter.close();
	}

	public Vector vectorize(Issue issue) {
		if (!isPreprocessed)
			prepareIssues();
		return createVector(issue);
	}

	public List<Vector> vectorize() {
		if (!isPreprocessed)
			prepareIssues();
		List<Vector> vecs = Collections.synchronizedList(new ArrayList<Vector>());
		issues.parallelStream().forEach(i -> vecs.add(
				integrateLabels ? createVector(i, getLabel(i)) : createVector(i)
		));
		return vecs;
	}

	Vector createVector(Issue issue) {
		Vector vec = new Vector(components.size(), issue.getProject(),
				issue.getId(), issue.getTrueLabel());
		for (int i = 0; i < components.size(); i++) {
			vec.elements[i] = components.get(i).value(issue);
		}
		return vec;
	}

	private Vector createVector(Issue issue, int label) {
		Vector vec = new Vector(components.size()+1, issue.getProject(),
				issue.getId(), issue.getTrueLabel());
		for (int i = 0; i < components.size(); i++) {
			vec.elements[i] = components.get(i).value(issue);
		}
		vec.elements[vec.elements.length-1] = label;
		return vec;
	}

	private Set<String> collectLabels() {
		if (!isPreprocessed && preprocessor != null) LOG.warn("Issues have not been preprocessed yet!");
		Set<String> labels = issues.stream().map(Issue::getTrueLabel).collect(Collectors.toSet());
		return labels;
	}

	public void prepareIssues() {
		if (preprocessor != null) {
			preprocessor.preprocess(issues);
			isPreprocessed = true;
		} else {
			if(verbose) LOG.info("no preprocessor registered");
		}
	}

	private int getLabel(Issue issue) {
		return labelMapper.get(issue.getTrueLabel());
	}

	public boolean validate() {
		String[] labels = collectLabels().toArray(new String[]{});
		return labelMapper.validateLabels(labels);
	}

	public static class VectorizationEngineBuilder {
		private final VectorizationEngine engine = new VectorizationEngine();

		public VectorizationEngineBuilder verbose(boolean verbose) {
			this.engine.verbose = verbose;
			return this;
		}
		public VectorizationEngineBuilder verbose() {
			return verbose(true);
		}

		public VectorizationEngineBuilder integrateLabels(boolean b) {
			this.engine.integrateLabels = b;
			return this;
		}
		public VectorizationEngineBuilder integrateLabels() {
			return integrateLabels(true);
		}

		public VectorizationEngineBuilder preprocessor(Preprocessor p) {
			this.engine.preprocessor = p;
			return this;
		}

		public VectorizationEngineBuilder useDefaults() {
			this.engine.initDefaults();
			return this;
		}

		public VectorizationEngineBuilder issues(List<Issue> issues) {
			this.engine.issues = issues;
			return this;
		}

		public VectorizationEngineBuilder labelMapper(LabelMapper labelMapper) {
			this.engine.labelMapper = labelMapper;
			return this;
		}

		public VectorizationEngine build() {
			return this.engine;
		}
	}

}
