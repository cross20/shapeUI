interface Shape {
	/**
	 * @return The kind and ID of a shape in a {@code String} format.
	 */
	String toString();
	
	/**
	 * @return The kind of shape in a {@code String} format.
	 */
	String getKind();
	
	/**
	 * @return A formatted {@code String} that displays all of the shape properties.
	 */
	String getDetailString();
	
	/**
	 * @return The ID of a shape in {@code int} format.
	 */
	int getID();
	
	/**
	 * Open a CSV file and read in {@code Shape} data from the specified line in the file.
	 * @param lineNumber
	 */
	void readFile(int lineNumber);
}