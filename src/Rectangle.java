class Rectangle implements Shape {
	private String shapeKind;
	private Integer rectangleID;
	private String length;
	private String width;
	private String color;
	
	Rectangle() {
		// TODO: Read in from CSV file.
	}
	
	public String toString() {
		String squareString = "<html>";
		squareString += shapeKind + "(ID#" + rectangleID.toString() + ")<br>";
		squareString += "</html>";
		return squareString;
	}
	
	public String getKind() {
		return shapeKind;
	}
	
	public String getDetailString() {
		String circleString = "<html>";
		circleString += "Length: " + length + "<br>";
		circleString += "Width: " + width + "<br>";
		circleString += "Color: " + color;
		circleString += "</html>";
		return circleString;
	}
	
	public int getID() {
		return rectangleID;
	}
}