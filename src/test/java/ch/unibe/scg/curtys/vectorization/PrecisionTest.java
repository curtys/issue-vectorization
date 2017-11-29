package ch.unibe.scg.curtys.vectorization;

import ch.unibe.scg.curtys.vectorization.components.ErrorElementsTest;
import ch.unibe.scg.curtys.vectorization.io.JsonIO;
import ch.unibe.scg.curtys.vectorization.issue.Issue;
import ch.unibe.scg.curtys.vectorization.testutils.VectorArchive;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author curtys
 */
public class PrecisionTest {

	@Test
	public void precisionTest() throws Exception {

		for (int i = 0; i < 23; i++) {
			eval(i);
		}
	}

	private void eval(int index) {
		final int[] match = { 0 };
		VectorizationEngine engine = VectorizationEngine.builder()
				.useDefaults().build();

		VectorArchive.getArchive().forEach((k, v) -> {
			String filename = k.getProject()+"-"+k.getId()+"."+"json";
			Path p = Paths.get(PrecisionTest.class.getResource("/testdata/"+filename).getPath());
			Issue issue = null;
			try {
				issue = JsonIO.mapIssue(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
			int[] actual = engine.vectorize(issue).getElements();
			if (actual[index] == v[index]) match[0]++;
		});

		double precision = (double) match[0] / (double) VectorArchive.getAll().size();
		System.out.println(index+" Precision: " + precision);
	}
}
