class Triangle implements Shape {
	private String shapeKind;
	private Integer triangleID;
	private String sideOne;
	private String sideTwo;
	private String sideThree;
	private String color;
	
	Triangle() {
		// TODO: Read in from CSV file.
	}
	
	public String toString() {
		String squareString = "<html>";
		squareString += shapeKind + "(ID#" + triangleID.toString() + ")<br>";
		squareString += "</html>";
		return squareString;
	}
	
	public String getKind() {
		return shapeKind;
	}
	
	public String getDetailString() {
		String circleString = "<html>";
		circleString += "Side One Length: " + sideOne + "<br>";
		circleString += "Side Two Length: " + sideTwo + "<br>";
		circleString += "Side Three Length: " + sideThree + "<br>";
		circleString += "Color: " + color;
		circleString += "</html>";
		return circleString;
	}
	
	public int getID() {
		return triangleID;
	}
}