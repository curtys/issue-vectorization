package ch.unibe.scg.curtys.vectorization.issue;

import java.util.ArrayList;

/**
 * Created by scurty
 */
public class Issue {

	private boolean hasPatch;
	private boolean hasScreenshot;
	private boolean systemSpecification;
	private String id;
	private String project;
	private String summary;
	private String description;
	private ArrayList<Comment> comments;
	private String issuetypeClassified;
	private String issuetypeTracker;
	private String priority;
	private String trueLabel;
	private String version;
	private String component;
	private String product;

	public final static int LABEL_SOURCE_CLASSIFIED = 0;
	public final static int LABEL_SOURCE_TRACKER = 1;

	public Issue() {
		this.trueLabel = getIssuetypeClassified();
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean hasScreenshot() {
		return hasScreenshot;
	}

	public void setHasScreenshot(boolean hasScreenshot) {
		this.hasScreenshot = hasScreenshot;
	}

	public boolean hasPatch() {
		return hasPatch;
	}

	public void setHasPatch(boolean hasPatch) {
		this.hasPatch = hasPatch;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIssuetypeClassified() {
		return issuetypeClassified;
	}

	public void setIssuetypeClassified(String issuetypeClassified) {
		this.issuetypeClassified = issuetypeClassified;
	}

	public String getIssuetypeTracker() {
		return issuetypeTracker;
	}

	public void setIssuetypeTracker(String issuetypeTracker) {
		this.issuetypeTracker = issuetypeTracker;
	}

	public String textRepresentation() {
		String comments = "";
		for(Comment comment : getComments()) {
			comments += comment.getBody() + "\n";
		}
		comments.trim();
		return summary+"\n"+description+"\n"+comments;
	}

	public boolean hasSystemspecification() {
		return systemSpecification;
	}

	public void setSystemSpecification(boolean systemSpecification) {
		this.systemSpecification = systemSpecification;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTrueLabel() {
		return trueLabel;
	}

	public void setTrueLabel(String trueLabel) {
		this.trueLabel = trueLabel;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
}
