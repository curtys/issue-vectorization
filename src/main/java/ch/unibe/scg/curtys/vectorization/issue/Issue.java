package ch.unibe.scg.curtys.vectorization.issue;

import java.util.List;

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
	private List<Comment> comments;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
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

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Issue issue = (Issue) o;

		if (hasPatch != issue.hasPatch)
			return false;
		if (hasScreenshot != issue.hasScreenshot)
			return false;
		if (systemSpecification != issue.systemSpecification)
			return false;
		if (id != null ? !id.equals(issue.id) : issue.id != null)
			return false;
		if (project != null ? !project.equals(issue.project) : issue.project != null)
			return false;
		if (summary != null ? !summary.equals(issue.summary) : issue.summary != null)
			return false;
		if (description != null ? !description.equals(issue.description) : issue.description != null)
			return false;
		if (comments != null ? !comments.equals(issue.comments) : issue.comments != null)
			return false;
		if (issuetypeClassified != null ? !issuetypeClassified.equals(issue.issuetypeClassified) : issue.issuetypeClassified != null)
			return false;
		if (issuetypeTracker != null ? !issuetypeTracker.equals(issue.issuetypeTracker) : issue.issuetypeTracker != null)
			return false;
		if (priority != null ? !priority.equals(issue.priority) : issue.priority != null)
			return false;
		if (trueLabel != null ? !trueLabel.equals(issue.trueLabel) : issue.trueLabel != null)
			return false;
		if (version != null ? !version.equals(issue.version) : issue.version != null)
			return false;
		if (component != null ? !component.equals(issue.component) : issue.component != null)
			return false;
		return product != null ? product.equals(issue.product) : issue.product == null;
	}

	@Override public int hashCode() {
		int result = (hasPatch ? 1 : 0);
		result = 31 * result + (hasScreenshot ? 1 : 0);
		result = 31 * result + (systemSpecification ? 1 : 0);
		result = 31 * result + (id != null ? id.hashCode() : 0);
		result = 31 * result + (project != null ? project.hashCode() : 0);
		result = 31 * result + (summary != null ? summary.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (comments != null ? comments.hashCode() : 0);
		result = 31 * result + (issuetypeClassified != null ? issuetypeClassified.hashCode() : 0);
		result = 31 * result + (issuetypeTracker != null ? issuetypeTracker.hashCode() : 0);
		result = 31 * result + (priority != null ? priority.hashCode() : 0);
		result = 31 * result + (trueLabel != null ? trueLabel.hashCode() : 0);
		result = 31 * result + (version != null ? version.hashCode() : 0);
		result = 31 * result + (component != null ? component.hashCode() : 0);
		result = 31 * result + (product != null ? product.hashCode() : 0);
		return result;
	}
}
