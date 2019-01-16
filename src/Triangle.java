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
		int sideOneInt = Integer.parseInt(sideOne);
		int sideTwoInt = Integer.parseInt(sideTwo);
		double area = 0.5 * sideOneInt * sideTwoInt;
		
		String circleString = "<html>";
		circleString += shapeKind + " (ID# " + triangleID + ")<br>";
		circleString += "Side One Length: " + sideOne + "<br>";
		circleString += "Side Two Length: " + sideTwo + "<br>";
		circleString += "Side Three Length: " + sideThree + "<br>";
		circleString +=  "Area: " + area + "<br>";
		circleString += "Color: " + color;
		circleString += "</html>";
		return circleString;
	}
	
	public int getID() {
		return triangleID;
	}
	
	public void readFile(int lineNumber) {
		// Open the file "shapes.csv" to read the shape data from it. It is up to the
		// user of readFile(int lineNumber) to determine which shapes are at which line numbers.
		String currentDirectory = System.getProperty("user.dir");
		
		try(FileInputStream is = new FileInputStream(currentDirectory + "/src/shapes.csv")) {
        	InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            int lineTracker = 1;
            
            // Read in data until the end of the file.
            while(line != null) {
				parts = line.split(",");
                
				// If the desired shape is found, set the shape data to "this".
                if(lineTracker == lineNumber) {
                	setAll();
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
		String tempColor = parts[5];
		color = "";
		for(int i = 0; i < tempColor.length(); i++) {
			if(tempColor.charAt(i) == '\"' || tempColor.charAt(i) == ' ') {
				
			} else {
				color += tempColor.charAt(i);
			}
		}
    }
}