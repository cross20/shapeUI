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
		// Add one to the lineIndex to get the current line number;
		shapes = new ArrayList<Shape>();
		
		shapesFile = new FileData();
		numOfShapes = shapesFile.getNumShapes();
		numOfCircles = shapesFile.getNumCircles();
		numOfSquares = shapesFile.getNumSquares();
		numOfRectangles = shapesFile.getNumRectangles();
		numOfTriangles = shapesFile.getNumTriangles();
		
		String typeAtLine;
		
		for(int i = 0; i < numOfShapes; i++) {
			typeAtLine = shapesFile.getShapeType(i);
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
		
		/*for(int i = 0; i < numOfCircles; i++) {
			shapes.add(new Circle());
			((Circle)shapes.get(lineIndex)).readFile(++lineIndex);
		}
		
		for(int i = 0; i < numOfSquares; i++) {
			shapes.add(new Square());
			((Square)shapes.get(lineIndex)).readFile(++lineIndex);
		}
		
		for(int i = 0; i < numOfRectangles; i++) {
			shapes.add(new Rectangle());
			((Rectangle)shapes.get(lineIndex)).readFile(++lineIndex);
		}
		
		for(int i = 0; i < numOfTriangles; i++) {
			shapes.add(new Triangle());
			((Triangle)shapes.get(lineIndex)).readFile(++lineIndex);
		}*/
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(6, 6, 157, 395);
		frame.getContentPane().add(scrollPane);
		
		JLabel shapeListHeader = new JLabel("Shape Selection");
		shapeListHeader.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		shapeListHeader.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(shapeListHeader);
		
		listModel = new DefaultListModel<>();
		
		Shape thisButtonText;
		
		/*for(int i = 0; i < numOfCircles; i++) {
			thisButtonText = ((Circle)shapes.get(lineIndex++));
			listModel.addElement(thisButtonText);
		}
		
		for(int i = 0; i < numOfSquares; i++) {
			thisButtonText = ((Square)shapes.get(lineIndex++));
			listModel.addElement(thisButtonText);
		}
		
		for(int i = 0; i < numOfRectangles; i++) {
			thisButtonText = ((Rectangle)shapes.get(lineIndex++));
			listModel.addElement(thisButtonText);
		}
		
		for(int i = 0; i < numOfTriangles; i++) {
			thisButtonText = ((Triangle)shapes.get(lineIndex++));
			listModel.addElement(thisButtonText);
		}*/
		for(int i = 0; i < numOfShapes; i++) {
			thisButtonText = shapes.get(i);
			listModel.addElement(thisButtonText);
		}
		
		shapeList = new JList<>(listModel);
		scrollPane.setViewportView(shapeList);
		shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shapeList.addMouseListener(this);
		
		infoImageLabel = new JLabel("");
		infoImageLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		infoImageLabel.setIcon(new ImageIcon("/Users/Chad/Documents/Whitworth/2018-19/Jan_Term/ShapeUI/resources/allShapes.png"));
		infoImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoImageLabel.setBounds(175, 6, 340, 180);
		frame.getContentPane().add(infoImageLabel);
		
		infoTextLabel = new JLabel("No data found.");
		infoTextLabel.setVerticalAlignment(SwingConstants.TOP);
		infoTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoTextLabel.setBounds(175, 198, 340, 203);
		frame.getContentPane().add(infoTextLabel);
	}

	// START: Implement MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		int index = shapeList.getSelectedIndex();
		System.out.println("The selected index is: " + index);
		
		Shape selectedItem = shapeList.getSelectedValue();
		Shape selectedShape = shapes.get(index);
		System.out.println("Selected item is " + selectedItem);
		System.out.println("Selected shape is " + selectedShape);
		
		infoTextLabel.setText(listModel.get(index).getDetailString());
		
		String typeAtLine = listModel.get(index).getKind();
		switch(typeAtLine) {
		case "circle":
			infoImageLabel.setIcon(new ImageIcon("/Users/Chad/Documents/Whitworth/2018-19/Jan_Term/ShapeUI/resources/circle.png"));
			break;
		case "square":
			infoImageLabel.setIcon(new ImageIcon("/Users/Chad/Documents/Whitworth/2018-19/Jan_Term/ShapeUI/resources/square.png"));
			break;
		case "rectangle":
			infoImageLabel.setIcon(new ImageIcon("/Users/Chad/Documents/Whitworth/2018-19/Jan_Term/ShapeUI/resources/rectangle.png"));
			break;
		case "triangle":
			infoImageLabel.setIcon(new ImageIcon("/Users/Chad/Documents/Whitworth/2018-19/Jan_Term/ShapeUI/resources/triangle.png"));
			break;
		}
		/*for(int i = 0; i < numOfShapes; i++) {
			selectedShape = shapes.get(i);
			if(selectedItem.getKind() == selectedShape.getKind() && selectedItem.getID() == selectedShape.getID()) {
				infoTextLabel.setText(selectedShape.getDetailString());
			}
		}*/
		
		//infoTextLabel.setText(shapeList.getSelectedValue().getDetailString());
		/*switch(selectedItem.charAt(0)) {
		case 'c':
			infoTextLabel.setText(selectedShape.getDetailString());
			break;
		case 's':
			infoTextLabel.setText(((Square)selectedShape).getDetailString());
			break;
		case 'r':
			infoTextLabel.setText(((Rectangle)selectedShape).getDetailString());
			break;
		case 't':
			infoTextLabel.setText(((Triangle)selectedShape).getDetailString());
			break;
		}
		
		/*System.out.println("Selected index is: " + shapeList.getSelectedIndex());
		System.out.println("Selected shape is: " + shapes.get(shapeList.getSelectedIndex()));
		String testMe = shapes.get(shapeList.getSelectedIndex()).toString();
		System.out.println("Test string is: " + testMe);
		//for(int i = 0; i < numOfShapes; i++) {
			if(shapes.get(shapeList.getSelectedIndex())instanceof Circle) {
				System.out.println("Circle selected.");
			} else if(shapes.get(shapeList.getSelectedIndex()) instanceof Square) {
				System.out.println("Square selected.");
			} else if(shapes.get(shapeList.getSelectedIndex()) instanceof Rectangle) {
				System.out.println("Rectangle selected.");
			} else if(shapes.get(shapeList.getSelectedIndex()) instanceof Triangle) {
				System.out.println("Triangle selected.");
			} else {
				System.out.println("Error getting shape types.");
			}
		//}*/
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
