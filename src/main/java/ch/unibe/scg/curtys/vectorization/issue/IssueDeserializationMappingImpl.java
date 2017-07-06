package ch.unibe.scg.curtys.vectorization.issue;

import java.util.Date;

/**
 * @author curtys
 */
public class IssueDeserializationMappingImpl
		implements IssueDeserializationMapping {

	private String project_id;
	/* name of the reporter */
	private String name;
	private String bug_id;
	private String bug_severity;
	private String priority;
	private String product_name;
	private String component_name;
	private String op_sys;
	private String short_desc;
	private String thetext;
	private int vote;
	private Date creation_ts;

	@Override public Issue toIssue() {
		Issue issue = new Issue();
		issue.setComponent(component_name);
		issue.setId(bug_id);
		issue.setSystemSpecification(op_sys);
		issue.setPriority(bug_severity);
		issue.setProduct(product_name);
		issue.setSummary(short_desc);
		issue.setDescription(thetext);
		issue.setProject(project_id);
		return issue;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBug_id() {
		return bug_id;
	}

	public void setBug_id(String bug_id) {
		this.bug_id = bug_id;
	}

	public String getBug_severity() {
		return bug_severity;
	}

	public void setBug_severity(String bug_severity) {
		this.bug_severity = bug_severity;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getComponent_name() {
		return component_name;
	}

	public void setComponent_name(String component_name) {
		this.component_name = component_name;
	}

	public String getOp_sys() {
		return op_sys;
	}

	public void setOp_sys(String op_sys) {
		this.op_sys = op_sys;
	}

	public String getShort_desc() {
		return short_desc;
	}

	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}

	public String getThetext() {
		return thetext;
	}

	public void setThetext(String thetext) {
		this.thetext = thetext;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public Date getCreation_ts() {
		return creation_ts;
	}

	public void setCreation_ts(Date creation_ts) {
		this.creation_ts = creation_ts;
	}
}
