# Issue Vectorization

The Issue Vectorization module provides functionality to create a vector representation of issue reports.

## Usage
Create a vector representation of a single or multiple issue reports using the default configuration:
```java
VectorizationEngine engine = VectorizationEngine.builder()
        .useDefaults()
        .build();
				
// Create a vector from a single issue report
Vector vector = engine.vectorize(issue);

// Batch processing is supported as well
List<Vector> vectors = engine.vectorize(listOfIssues);
```
In the above code example the vectorization will be done using the default vector components. However, it is possible to provide custom vector components:
```java
VectorizationEngine.builder()
        .useComponents(listOfComponents)
        .build();
```
Sometimes it is necessary to prepare the issues before vectorization. This can be done using preprocessors and is especially useful for batch processing:
```java
// Preprocessor to eliminate duplicate issues
ChainPreprocessor firstPreprocessor = new DuplicateFilter();
firstPreprocessor.addNext(secondPreprocessor);

VectorizationEngine.builder()
        .useDefaults()
        .preprocessor(firstPreprocessor)
        .build();
```
It can be useful to integrate the label, that is, the issue type (as integer value), into the resulting vector as well. For example, when exporting the results to CSV. In such a case, a label mapper must be provided, taking the responsibility to assign a integer value to label:
```java
LabelMapper labelMapper = new DefaultLabels();

// add a label mapper and configure the engine 
// to integrate the label into the vector 
VectorizationEngine.builder()
        .useDefaults()
        .labelMapper(labelMapper)
        .integrateLabels(true)
        .build();
```
Full example (see also the package ```example```): Issues in JSON format are loaded from the classpath. In this example, we want to use the issue type from the issue tracking system as ground truth. The first preprocessor does this. The second preprocessor removes all loaded issues which have non-matching labels (e.g. issue type from on the tracker is "improvement", but the issue was classified as "bug").
```java
// Load issues from file
URI inPath = VectorizationExample.class
		.getResource("/example").toURI();
List<Issue> issues = JsonIO.readJsons(inPath);
        
// Setup preprocessors
// Set the label to use as ground truth
ChainPreprocessor preprocessor = 
        new TrueLabelPreprocessor(Issue.LABEL_SOURCE_TRACKER\cite{Herzig13});
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
```

## License
MIT