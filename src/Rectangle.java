import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// This is a test.

class Rectangle implements Shape {
	private String shapeKind;
	private Integer rectangleID;
	private String length;
	private String width;
	private String color;
	private String[] parts;
	
	Rectangle() {
		
	}
	
	public String toString() {
		return shapeKind + " (" + rectangleID.toString() + ")";
	}
	
	public String getKind() {
		return shapeKind;
	}
	
	public String getDetailString() {
		int lengthInt = Integer.parseInt(length);
		int widthInt = Integer.parseInt(width);
		double area = lengthInt * widthInt;
		
		String circleString = "<html>";
		circleString += shapeKind + " (ID# " + rectangleID + ")<br>";
		circleString += "Length: " + length + "<br>";
		circleString += "Width: " + width + "<br>";
		circleString += "Area: " + area + "<br>";
		circleString += "Color: " + color;
		circleString += "</html>";
		return circleString;
	}
	
	public int getID() {
		return rectangleID;
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
        catch (Exception ex) { System.out.printf("Failed for %s in Rectangle \n", "shapes.csv"); }
	}
	
	private void setAll() {
		shapeKind = parts[0];
		rectangleID = Integer.parseInt(parts[1]);
		length = parts[2];
		width = parts[3];
		String tempColor = parts[4];
		color = "";
		for(int i = 0; i < tempColor.length(); i++) {
			if(tempColor.charAt(i) == '\"' || tempColor.charAt(i) == ' ') {
				
			} else {
				color += tempColor.charAt(i);
			}
		}
    }
}