import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Circle implements Shape {
	private String shapeKind;
	private Integer circleID;
	private String radius;
	private String color;
	private String[] parts;
	
	Circle() {
		
	}
	
	public String toString() {
		String circleString = shapeKind + " (" + circleID.toString() + ")";
		return circleString;
	}
	
	public String getKind() {
		return shapeKind;
	}
	
	public String getDetailString() {
		String circleString = "<html>";
		circleString += shapeKind + " (ID# " + circleID + ")<br>";
		circleString += "Radius: " + radius + "<br>";
		circleString += "Color: " + color;
		circleString += "</html>";
		return circleString;
	}
	
	public int getID() {
		return circleID;
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
        catch (Exception ex) { System.out.printf("Failed for %s in Circle\n", "shapes.csv"); }
	}
	
	private void setAll() {
		shapeKind = parts[0];
		circleID = Integer.parseInt(parts[1]);
		radius = parts[2];
		color = parts[3];
    }
}