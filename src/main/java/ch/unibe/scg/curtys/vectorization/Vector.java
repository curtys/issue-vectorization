package ch.unibe.scg.curtys.vectorization;

/**
 * Created by scurty.
 */
public class Vector {

	final int[] elements;
	private final String project;
	private final String id;
	private final String label;

	Vector(int size, String project, String id, String label) {
		this.elements = new int[size];
		this.project = project;
		this.id = id;
		this.label = label;
	}

	public int[] getElements() {
		return elements;
	}

	public String getId() {
		return id;
	}

	public String getProject() {
		return project;
	}
}
