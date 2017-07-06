package ch.unibe.scg.curtys.vectorization.label;

/**
 * @author curtys
 */
public interface LabelMapper {

	/**
	 * Validates the given Array with the labels known by this source.
	 * The validation is successful, if all labels in the array are registered and
	 * all registered labels occur in the array.
	 * @param labels the array with the labels to validate
	 * @return true, if the validation was successful, false otherwise.
	 */
	boolean validateLabels(String... labels);

	/**
	 * Checks if the given label is known.
	 * @param label
	 * @return true, if the label is known, false otherwise.
	 */
	boolean has(String label);

	/**
	 * Returns the value to which the specified label is mapped.
	 * @param label
	 * @return the integer key to which the label is mapped or null, if the label
	 * is not known
	 */
	int get(String label);

	/**
	 * Returns the unique String value to which the integer key of the label is mapped.
	 * @param classLabel
	 * @return the unique String value or null, if the label is not known.
	 */
	String getNaturalLabel(int classLabel);

	/**
	 * Returns how many labels are known.
	 * @return amount of known labels.
	 */
	int size();

}
