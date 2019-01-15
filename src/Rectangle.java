import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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
	
	public void readFile(int lineNumber) {
		String currentDirectory = System.getProperty("user.dir");
		
		try(FileInputStream is = new FileInputStream(currentDirectory + "/shapes.csv")) {
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
        catch (Exception ex) { System.out.printf("Failed for %s\n", "shapes.csv"); }
	}
	
	private void setAll() {
		shapeKind = parts[0];
		rectangleID = Integer.parseInt(parts[1]);
		length = parts[2];
		width = parts[3];
		color = parts[4];
    }
}