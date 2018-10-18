import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	
	private static final int COLUMNS = 5;
	private static final int ROWS = 5;
	
	private JButton buttonGrid[][] = new JButton[ROWS][COLUMNS];
	
	private int tarzanRow = 0;
	private int tarzanColumn = 0;
	
	private Icon tarzanIcon = new ImageIcon("image/tarzan.jpg");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmMoreInfo = new JMenuItem("More Info");
		mnAbout.add(mntmMoreInfo);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnCenter = new JButton("CENTER");
		btnCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tarzanRow = (ROWS-1)/2;
				tarzanColumn = (COLUMNS-1)/2;
				refreshGrid();
			}
		});
		buttonPanel.add(btnCenter, BorderLayout.CENTER);
		
		JButton btnUp = new JButton("^");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Move object up
				if(tarzanRow>0) {
					tarzanRow--;
				}
				refreshGrid();
			}
		});
		buttonPanel.add(btnUp, BorderLayout.NORTH);
		
		JButton btnDown = new JButton("v");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tarzanRow<ROWS-1) {
					tarzanRow++;
				}
				refreshGrid();
			}
		});
		buttonPanel.add(btnDown, BorderLayout.SOUTH);
		
		JButton btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tarzanColumn>0) {
					tarzanColumn--;
				}
				refreshGrid();
			}
		});
		buttonPanel.add(btnLeft, BorderLayout.WEST);
		
		JButton btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tarzanColumn<COLUMNS-1) {
					tarzanColumn++;
				}
				refreshGrid();
			}
		});
		buttonPanel.add(btnRight, BorderLayout.EAST);
		
		JPanel gridPanel = new JPanel();
		contentPane.add(gridPanel, BorderLayout.CENTER);
		gridPanel.setLayout(new GridLayout(ROWS, COLUMNS, 0, 0));
		
		JButton btnRandom = new JButton("Random");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				tarzanRow = rand.nextInt(ROWS);
				tarzanColumn = rand.nextInt(COLUMNS);
				refreshGrid();
			}
		});
		contentPane.add(btnRandom, BorderLayout.NORTH);
		
		for(int row = 0; row < ROWS; row++) {
			for(int column = 0; column < COLUMNS; column++) {
				JButton nextButton = new JButton("");
				buttonGrid[row][column] = nextButton;
				gridPanel.add(nextButton);
			}
		}
		refreshGrid();
	}
	public void refreshGrid() {
		for(int row = 0; row < ROWS; row++) {
			for(int column = 0; column < COLUMNS; column++) {
				if(row==tarzanRow&&column==tarzanColumn) {
					buttonGrid[row][column].setIcon(tarzanIcon);
				}
				else {
					buttonGrid[row][column].setIcon(null);
				}
			}
		}
	}

}
