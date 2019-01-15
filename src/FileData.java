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
	
	FileData(String fileName) {
		this.numShapes = 0;
		this.numCircles = 0;
		this.numSquares = 0;
		this.numRectangles = 0;
		this.numTriangles = 0;
		
		findNumShapes(fileName);
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
	
	private void findNumShapes(String fileName) {
		int lineNumber = 1;
		String currentDirectory = System.getProperty("user.dir");
		
		try(FileInputStream is = new FileInputStream(currentDirectory + "/" + fileName)) {
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
                	
                	if(parts[0] == "Circle") {
                		numCircles++;
                	} else if (parts[0] == "Square") {
                		numSquares++;
                	} else if (parts[0] == "Rectangle") {
                		numRectangles++;
                	} else if (parts[0] == "Triangle") {
                		numTriangles++;
                	}
                	
                	numShapes++;
                    System.out.println();
                }
                line = rdr.readLine();
                lineTracker++;
            }
        }
        catch (Exception ex) { System.out.printf("Failed for %s\n", "shapes.csv"); }
	}
}