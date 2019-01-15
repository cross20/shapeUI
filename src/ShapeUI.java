import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class ShapeUI {

	private JFrame frame;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane objectScrollPane = new JScrollPane();
		objectScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		objectScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		objectScrollPane.setBounds(6, 6, 132, 516);
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
		objectInfoPanel.setBounds(137, 6, 307, 516);
		frame.getContentPane().add(objectInfoPanel);
		objectInfoPanel.setLayout(null);
		
		JLabel shapeImageLabel = new JLabel("");
		shapeImageLabel.setBounds(6, 129, 116, 116);
		objectInfoPanel.add(shapeImageLabel);
		
		JLabel shapeInfoLabel = new JLabel("No Info found");
		shapeInfoLabel.setBounds(134, 129, 167, 116);
		objectInfoPanel.add(shapeInfoLabel);
	}
}
