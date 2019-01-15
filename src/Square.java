class Square implements Shape {
	private String shapeKind;
	private Integer squareID;
	private String sideLength;
	private String color;
	
	Square() {
		// TODO: Read in from CSV file.
	}
	
	public String toString() {
		String squareString = "<html>";
		squareString += shapeKind + "(ID#" + squareID.toString() + ")<br>";
		squareString += "</html>";
		return squareString;
	}
	
	public String getKind() {
		return shapeKind;
	}
	
	public String getDetailString() {
		String circleString = "<html>";
		circleString += "Side Length: " + sideLength + "<br>";
		circleString += "Color: " + color;
		circleString += "</html>";
		return circleString;
	}
	
	public int getID() {
		return squareID;
	}
}