package ch.unibe.scg.curtys.vectorization.example;

import ch.unibe.scg.curtys.vectorization.Vector;
import ch.unibe.scg.curtys.vectorization.VectorizationEngine;
import ch.unibe.scg.curtys.vectorization.io.JsonIO;
import ch.unibe.scg.curtys.vectorization.issue.Issue;
import ch.unibe.scg.curtys.vectorization.label.LabelMapper;
import ch.unibe.scg.curtys.vectorization.label.SimpleLabels;
import ch.unibe.scg.curtys.vectorization.preprocessors.ChainPreprocessor;
import ch.unibe.scg.curtys.vectorization.preprocessors.MatchingLabelFilter;
import ch.unibe.scg.curtys.vectorization.preprocessors.TrueLabelPreprocessor;

import java.net.URI;
import java.util.List;

public class VectorizationExample {

    public static void main(String[] args) throws Exception {

        // Load issues from file
        URI inPath = VectorizationExample.class.getResource("/example").toURI();
        List<Issue> issues = JsonIO.readJsons(inPath);

        // Setup preprocessors
        // Set the label to use as ground truth
        ChainPreprocessor preprocessor = new TrueLabelPreprocessor(Issue.LABEL_SOURCE_TRACKER);
        // Remove all issues with non-matching labels
        preprocessor.addNext(new MatchingLabelFilter());
        LabelMapper labelMapper = new SimpleLabels();

        // Configure engine
        VectorizationEngine engine = VectorizationEngine.builder()
                .verbose()
                .integrateLabels(true)
                .preprocessor(preprocessor)
                .issues(issues)
                .useDefaults()
                .labelMapper(labelMapper)
                .build();

        // Pre-process issues
        engine.prepareIssues();

        // Create vectors
        List<Vector> vectors = engine.vectorize();
        System.out.println(vectors);
    }
}
