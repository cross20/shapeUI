class Circle implements Shape {
	private String shapeKind;
	private Integer circleID;
	private String radius;
	private String color;
	
	Circle() {
		// TODO: Read in from the CSV file.
	}
	
	public String toString() {
		String circleString = "<html>";
		circleString += shapeKind + "(ID#" + circleID.toString() + ")<br>";
		circleString += "</html>";
		return circleString;
	}
	
	public String getKind() {
		return shapeKind;
	}
	
	public String getDetailString() {
		String circleString = "<html>";
		circleString += "Radius: " + radius + "<br>";
		circleString += "Color: " + color;
		circleString += "</html>";
		return circleString;
	}
	
	public int getID() {
		return circleID;
	}
}