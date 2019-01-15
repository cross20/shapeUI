import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class ShapeUI {

	private JFrame frame;
	private int numOfShapes;
	private int numOfCircles;
	private int numOfSquares;
	private int numOfRectangles;
	private int numOfTriangles;
	private int lineIndex;
	ArrayList<Shape> shapes = new ArrayList<Shape>();

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
		lineIndex = 0;
		
		FileData shapesFile = new FileData("shapes.csv");
		numOfCircles = shapesFile.getNumCircles();
		numOfSquares = shapesFile.getNumSquares();
		numOfRectangles = shapesFile.getNumRectangles();
		numOfTriangles = shapesFile.getNumTriangles();
		
		for(int i = 0; i < numOfCircles; i++) {
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
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeFrame() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 249);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane objectScrollPane = new JScrollPane();
		objectScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		objectScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		objectScrollPane.setBounds(6, 6, 132, 215);
		frame.getContentPane().add(objectScrollPane);
		
			JLabel shapeSelectionLabel = new JLabel("No shapes found");
			shapeSelectionLabel.setVerticalAlignment(SwingConstants.TOP);
			shapeSelectionLabel.setHorizontalAlignment(SwingConstants.LEFT);
			objectScrollPane.setViewportView(shapeSelectionLabel);
		
			JLabel shapeSelectionHeaderLabel = new JLabel("Shape Selection");
			shapeSelectionHeaderLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
			shapeSelectionHeaderLabel.setForeground(Color.BLACK);
			shapeSelectionHeaderLabel.setBackground(Color.DARK_GRAY);
			shapeSelectionHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
			objectScrollPane.setColumnHeaderView(shapeSelectionHeaderLabel);
		
		JPanel objectInfoPanel = new JPanel();
		objectInfoPanel.setBounds(137, 6, 307, 215);
		frame.getContentPane().add(objectInfoPanel);
		objectInfoPanel.setLayout(null);
		
			JLabel shapeImageLabel = new JLabel("");
			shapeImageLabel.setBounds(6, 6, 116, 203);
			objectInfoPanel.add(shapeImageLabel);
		
			JLabel shapeInfoLabel = new JLabel("No shape data.");
			shapeInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
			shapeInfoLabel.setBounds(134, 6, 167, 203);
			objectInfoPanel.add(shapeInfoLabel);
	}
}
