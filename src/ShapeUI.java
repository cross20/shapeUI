// SOURCES
// DefaultListModel: http://www.seasite.niu.edu/cs580java/JList_Basics.htm
// MouseListener: http://www.stackoverflow.com/questions/14085757/mouselistener-keyistener-not-working-jpanel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import javax.swing.JList;

public class ShapeUI implements MouseListener {

	private JFrame frame;
	private JLabel infoTextLabel, infoImageLabel;
	private int numOfShapes, numOfCircles, numOfSquares, numOfRectangles, numOfTriangles;
	private ArrayList<Shape> shapes;
	private JList<Shape> shapeList;
	private FileData shapesFile;
	private DefaultListModel<Shape> listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapeUI window = new ShapeUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShapeUI() {
		initializeShapes();
		initializeFrame();
	}

	/**
	 * Initialize the shapes from the CSV file.
	 */
	private void initializeShapes() {
		// Setup all of the Shape objects
		shapes = new ArrayList<Shape>();
		
		shapesFile = new FileData();
		numOfShapes = shapesFile.getNumShapes();
		numOfCircles = shapesFile.getNumCircles();
		numOfSquares = shapesFile.getNumSquares();
		numOfRectangles = shapesFile.getNumRectangles();
		numOfTriangles = shapesFile.getNumTriangles();
		
		String typeAtLine; // A temporary string to determine which shapes are at which lines.
		
		for(int i = 0; i < numOfShapes; i++) {
			typeAtLine = shapesFile.getShapeType(i);
			// Create new Shape objects in the "shapes" ArrayList in the same order as they are in the CSV file. Also, 
			// read the data from that location in the CSV file to save the data of each type of shape to its object.
			switch(typeAtLine) {
			case "circle":
				shapes.add(new Circle());
				((Circle)shapes.get(i)).readFile(i+1);
            	break;
            case "square":
            	shapes.add(new Square());
    			((Square)shapes.get(i)).readFile(i+1);
            	break;
            case "rectangle":
            	shapes.add(new Rectangle());
    			((Rectangle)shapes.get(i)).readFile(i+1);
            	break;
            case "triangle":
            	shapes.add(new Triangle());
    			((Triangle)shapes.get(i)).readFile(i+1);
            	break;
			}
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeFrame() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 521, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Add a scroll pane to see all of the list items on the left side of the frame.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(6, 6, 157, 395);
		frame.getContentPane().add(scrollPane);
		
		// Give a title to the list of shapes.
		JLabel shapeListHeader = new JLabel("Shape Selection");
		shapeListHeader.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		shapeListHeader.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(shapeListHeader);
		
		// Add shapes to a list model to pass the shapes into a JList.
		listModel = new DefaultListModel<>();
		Shape thisButtonText;
		for(int i = 0; i < numOfShapes; i++) {
			thisButtonText = shapes.get(i);
			listModel.addElement(thisButtonText);
		}
		
		shapeList = new JList<>(listModel);
		scrollPane.setViewportView(shapeList);
		shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shapeList.addMouseListener(this);
		
		// An image to display the type of shape.
		infoImageLabel = new JLabel("");
		infoImageLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		infoImageLabel.setIcon(new ImageIcon("/Users/Chad/Documents/Whitworth/2018-19/Jan_Term/ShapeUI/resources/allShapes.png"));
		infoImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoImageLabel.setBounds(175, 6, 340, 180);
		frame.getContentPane().add(infoImageLabel);
		
		// Text to display the shape properties.
		infoTextLabel = new JLabel("Select a shape on the left to see its properties.");
		infoTextLabel.setVerticalAlignment(SwingConstants.TOP);
		infoTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoTextLabel.setBounds(175, 198, 340, 203);
		frame.getContentPane().add(infoTextLabel);
	}

	// START: Implement MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse release detected. Click count: " + e.getClickCount());
		Shape selectedItem = shapeList.getSelectedValue();
		System.out.println("Selected shape is " + selectedItem + ".");
		
		// Find the shape that was clicked and display its properties.
		int index = shapeList.getSelectedIndex();
		infoTextLabel.setText(listModel.get(index).getDetailString());
		
		String currentDirectory = System.getProperty("user.dir");
		System.out.println(currentDirectory);
		
		// Determine which image to show based upon the shape selected.
		String typeAtLine = listModel.get(index).getKind();
		switch(typeAtLine) {
		case "circle":
			infoImageLabel.setIcon(new ImageIcon(currentDirectory + "/resources/circle.png"));
			break;
		case "square":
			infoImageLabel.setIcon(new ImageIcon(currentDirectory + "/resources/square.png"));
			break;
		case "rectangle":
			infoImageLabel.setIcon(new ImageIcon(currentDirectory + "/resources/rectangle.png"));
			break;
		case "triangle":
			infoImageLabel.setIcon(new ImageIcon(currentDirectory + "/resources/triangle.png"));
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
