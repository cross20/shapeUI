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
	
	@Override
	public String toString() {
		String circleString = shapeKind + " (" + circleID.toString() + ")";
		return circleString;
	}
	
	@Override
	public String getKind() {
		return shapeKind;
	}
	
	@Override
	public String getDetailString() {
		// Calculate the area of a Circle using the formula PI * radius * radius = Area.
		int radiusInt = Integer.parseInt(radius);
		double area = 3.14 * radiusInt * radiusInt;
		
		// Format the detail string with HTML for easy formatting abilities.
		String circleString = "<html>";
		circleString += shapeKind + " (ID# " + circleID + ")<br>";
		circleString += "Radius: " + radius + "<br>";
		circleString += "Area: " + String.format("%2f", area) + "<br>";
		circleString += "Color: " + color;
		circleString += "</html>";
		return circleString;
	}
	
	@Override
	public int getID() {
		return circleID;
	}
	
	@Override
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
                	break;
                }
                
                line = rdr.readLine();
                lineTracker++;
            }
        }
        catch (Exception ex) { System.out.printf("Failed for %s in Circle.\n", "shapes.csv"); }
	}
	
	private void setAll() {
		shapeKind = parts[0];
		circleID = Integer.parseInt(parts[1]);
		radius = parts[2];
		String tempColor = parts[3];
		color = "";
		for(int i = 0; i < tempColor.length(); i++) {
			if(tempColor.charAt(i) == '\"' || tempColor.charAt(i) == ' ') {
				
			} else {
				color += tempColor.charAt(i);
			}
		}
		
    }
}