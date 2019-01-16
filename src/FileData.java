import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class FileData {
	private int numShapes;
	private int numCircles;
	private int numSquares;
	private int numRectangles;
	private int numTriangles;
	private String[] parts;
	
	FileData() {
		this.numShapes = 0;
		this.numCircles = 0;
		this.numSquares = 0;
		this.numRectangles = 0;
		this.numTriangles = 0;
		
		findNumShapes();
	}
	
	public int getNumShapes() {
		return this.numShapes;
	}
	
	public int getNumCircles() {
		return numCircles;
	}
	
	public int getNumSquares() {
		return numSquares;
	}
	
	public int getNumRectangles() {
		return numRectangles;
	}
	
	public int getNumTriangles() {
		return numTriangles;
	}
	
	public String getShapeType(int lineNumber) {
		// Open the file "shapes.csv" to read the shape data from it. It is up to the
		// user of readFile(int lineNumber) to determine which shapes are at which line numbers.
		String currentDirectory = System.getProperty("user.dir");
		
		try(FileInputStream is = new FileInputStream(currentDirectory + "/src/shapes.csv")) {
        	InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            int lineTracker = 0;
            
            // Read in data until the end of the file.
            while(line != null) {
				parts = line.split(",");
                
				// If the desired shape is found, set the shape data to "this".
                if(lineTracker == lineNumber) {
                	return parts[0];
                }
            	
                line = rdr.readLine();
                lineTracker++;
            }
        }
        catch (Exception ex) { System.out.printf("Failed for %s in FileData.java\n", "shapes.csv"); }
		
		return "Error finding shape.";
	}
	
	private void findNumShapes() {
		// Open the file "shapes.csv" to read the shape data from it.
		String currentDirectory = System.getProperty("user.dir");
		
		try(FileInputStream is = new FileInputStream(currentDirectory + "/src/shapes.csv")) {
        	InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            
            // Read in data until the end of the file.
            while(line != null) {
				parts = line.split(",");
                
				// Whenever a certain type of shape is found, increment the applicable variable.
                switch(parts[0]) {
                case "circle":
                	numCircles++;
                	break;
                case "square":
                	numSquares++;
                	break;
                case "rectangle":
                	numRectangles++;
                	break;
                case "triangle":
                	numTriangles++;
                	break;
                }
            	
            	numShapes++;
            	
                line = rdr.readLine();
            }
        }
        catch (Exception ex) { System.out.printf("Failed for %s in FileData.java\n", "shapes.csv"); }
	}
}