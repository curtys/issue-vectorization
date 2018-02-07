package ch.unibe.scg.curtys.vectorization;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author curtys
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

	@Override
	public String toString() {
		return "Vector{" +
				"elements=" + Arrays.toString(elements) +
				", project='" + project + '\'' +
				", id='" + id + '\'' +
				", label='" + label + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Vector)) return false;
		Vector vector = (Vector) o;
		return Arrays.equals(elements, vector.elements) &&
				Objects.equals(project, vector.project) &&
				Objects.equals(id, vector.id) &&
				Objects.equals(label, vector.label);
	}

	@Override
	public int hashCode() {

		int result = Objects.hash(project, id, label);
		result = 31 * result + Arrays.hashCode(elements);
		return result;
	}
}
