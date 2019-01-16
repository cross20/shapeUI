import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Triangle implements Shape {
	private String shapeKind;
	private Integer triangleID;
	private String sideOne;
	private String sideTwo;
	private String sideThree;
	private String color;
	private String[] parts;
	
	Triangle() {
		
	}
	
	public String toString() {
		return shapeKind + " (" + triangleID.toString() + ")";
	}
	
	public String getKind() {
		return shapeKind;
	}
	
	public String getDetailString() {
		String circleString = "<html>";
		circleString += shapeKind + " (ID# " + triangleID + ")<br>";
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
	
	public void readFile(int lineNumber) {
		String currentDirectory = System.getProperty("user.dir");
		
		try(FileInputStream is = new FileInputStream("/Users/Chad/Documents/Whitworth/2018-19/Jan_Term/ShapeUI/src/shapes.csv")) {
        	InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            int lineTracker = 1;
            
            while(line != null) {
				parts = line.split(",");
                
                if(lineTracker == lineNumber) {
                	for(String p : parts) {
                        if(!p.isBlank()) {
                            System.out.printf("%s, ", p);
                        }
                    }
                	setAll();
                    System.out.println();
                }
                line = rdr.readLine();
                lineTracker++;
            }
        }
        catch (Exception ex) { System.out.printf("Failed for %s in Triangle\n", "shapes.csv"); }
	}
	
	private void setAll() {
		shapeKind = parts[0];
		triangleID = Integer.parseInt(parts[1]);
		sideOne = parts[2];
		sideTwo = parts[3];
		sideThree = parts[4];
		color = parts[5];
    }
}