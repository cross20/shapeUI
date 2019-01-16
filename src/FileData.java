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
String currentDirectory = System.getProperty("user.dir");
		
		try(FileInputStream is = new FileInputStream("/Users/Chad/Documents/Whitworth/2018-19/Jan_Term/ShapeUI/src/shapes.csv")) {
        	InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            int lineTracker = 0;
            
            while(line != null) {
				parts = line.split(",");
                
                if(lineTracker == lineNumber) {
                	for(String p : parts) {
                        if(!p.isBlank()) {
                            System.out.printf("%s, ", p);  
                        }
                    }
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
		int lineNumber = 1;
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
                    System.out.println();
                }
                
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
                lineTracker++;
            }
        }
        catch (Exception ex) { System.out.printf("Failed for %s in FileData.java\n", "shapes.csv"); }
	}
}