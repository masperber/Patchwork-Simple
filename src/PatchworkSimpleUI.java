import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;

public class PatchworkSimpleUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatchworkSimpleUI frame = new PatchworkSimpleUI();
					frame.pack();
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
	public PatchworkSimpleUI() {
		Game game = new Game();
		int[] next3 = game.getNextThree();
		
		// set pane attributes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{260, 260, 260};
		gbl_contentPane.rowHeights = new int[]{0, 0, 210, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		// create pane features
		JButton btnNewGame = new JButton("New Game");
		JTextArea textP1;
		JTextArea textP2;
		JLabel board = new JLabel();
		JLabel piece1 = new JLabel();
		JLabel piece2 = new JLabel();
		JLabel piece3 = new JLabel();
		JButton btnPiece1 = new JButton("Piece 1");
		JButton btnPiece2 = new JButton("Piece 2");
		JButton btnPiece3 = new JButton("Piece 3");
		JButton btnPass = new JButton("Pass");
		
		// set table attributes
		textP1 = new JTextArea(game.getP1Status());
		textP1.setEditable(false);
		GridBagConstraints gbc_textP1 = new GridBagConstraints();
		gbc_textP1.insets = new Insets(0, 0, 5, 5);
		gbc_textP1.gridx = 0;
		gbc_textP1.gridy = 1;
		contentPane.add(textP1, gbc_textP1);
		
		textP2 = new JTextArea(game.getP2Status());
		textP2.setEditable(false);
		GridBagConstraints gbc_textP2 = new GridBagConstraints();
		gbc_textP2.insets = new Insets(0, 0, 5, 0);
		gbc_textP2.gridx = 2;
		gbc_textP2.gridy = 1;
		contentPane.add(textP2, gbc_textP2);
		
		// add the board
		GridBagConstraints gbc_board = new GridBagConstraints();
		gbc_board.insets = new Insets(0, 0, 5, 5);
		gbc_board.gridx = 1;
		gbc_board.gridy = 1;
		board.setIcon(new ImageIcon("img/board-app.png"));
		contentPane.add(board,gbc_board);
		
		// add the 3 piece images
		GridBagConstraints gbc_piece1 = new GridBagConstraints();
		gbc_piece1.insets = new Insets(0, 0, 5, 5);
		gbc_piece1.gridx = 0;
		gbc_piece1.gridy = 2;
		piece1.setSize(250, 200);
		piece1.setIcon(new ImageIcon("img/" + next3[0] + ".gif"));
		contentPane.add(piece1,gbc_piece1);
		
		GridBagConstraints gbc_piece2 = new GridBagConstraints();
		gbc_piece2.insets = new Insets(0, 0, 5, 5);
		gbc_piece2.gridx = 1;
		gbc_piece2.gridy = 2;
		piece2.setSize(250, 200);
		piece2.setIcon(new ImageIcon("img/" + next3[1] + ".gif"));
		contentPane.add(piece2,gbc_piece2);
		
		GridBagConstraints gbc_piece3 = new GridBagConstraints();
		gbc_piece3.insets = new Insets(0, 0, 5, 0);
		gbc_piece3.gridx = 2;
		gbc_piece3.gridy = 2;
		piece3.setSize(250, 200);
		piece3.setIcon(new ImageIcon("img/" + next3[2] + ".gif"));
		contentPane.add(piece3,gbc_piece3);
		
		// set new game button attributes
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewGame.gridx = 0;
		gbc_btnNewGame.gridy = 0;
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.newGame();
				textP1.setText(game.getP1Status());
				textP2.setText(game.getP2Status());
				
				int[] next3 = game.getNextThree();
				piece1.setIcon(new ImageIcon("img/" + next3[0] + ".gif"));
				piece2.setIcon(new ImageIcon("img/" + next3[1] + ".gif"));
				piece3.setIcon(new ImageIcon("img/" + next3[2] + ".gif"));
				
				btnPiece1.setEnabled(true);
				btnPiece2.setEnabled(true);
				btnPiece3.setEnabled(true);
				btnPass.setEnabled(true);
			}
		});
		contentPane.add(btnNewGame, gbc_btnNewGame);
		
		// set button 1 attributes
		GridBagConstraints gbc_btnPiece1 = new GridBagConstraints();
		gbc_btnPiece1.ipadx = 18;
		gbc_btnPiece1.insets = new Insets(0, 0, 5, 5);
		gbc_btnPiece1.gridx = 0;
		gbc_btnPiece1.gridy = 3;
		btnPiece1.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.buy(0);
				textP1.setText(game.getP1Status());
				textP2.setText(game.getP2Status());
				
				int[] next3 = game.getNextThree();
				piece1.setIcon(new ImageIcon("img/" + next3[0] + ".gif"));
				piece2.setIcon(new ImageIcon("img/" + next3[1] + ".gif"));
				piece3.setIcon(new ImageIcon("img/" + next3[2] + ".gif"));
				if(!game.isInProgress()) {
					btnPiece1.setEnabled(false);
					btnPiece2.setEnabled(false);
					btnPiece3.setEnabled(false);
					btnPass.setEnabled(false);
				}
			}
		});
		contentPane.add(btnPiece1, gbc_btnPiece1);
		
		// set button 2 attributes
		GridBagConstraints gbc_btnPiece2 = new GridBagConstraints();
		gbc_btnPiece2.ipadx = 18;
		gbc_btnPiece2.insets = new Insets(0, 0, 5, 5);
		gbc_btnPiece2.gridx = 1;
		gbc_btnPiece2.gridy = 3;
		btnPiece2.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.buy(1);
				textP1.setText(game.getP1Status());
				textP2.setText(game.getP2Status());
				
				int[] next3 = game.getNextThree();
				piece1.setIcon(new ImageIcon("img/" + next3[0] + ".gif"));
				piece2.setIcon(new ImageIcon("img/" + next3[1] + ".gif"));
				piece3.setIcon(new ImageIcon("img/" + next3[2] + ".gif"));
				if(!game.isInProgress()) {
					btnPiece1.setEnabled(false);
					btnPiece2.setEnabled(false);
					btnPiece3.setEnabled(false);
					btnPass.setEnabled(false);
				}
			}
		});
		contentPane.add(btnPiece2, gbc_btnPiece2);

		// set button 3 attributes
		GridBagConstraints gbc_btnPiece3 = new GridBagConstraints();
		gbc_btnPiece3.ipadx = 18;
		gbc_btnPiece3.insets = new Insets(0, 0, 5, 0);
		gbc_btnPiece3.gridx = 2;
		gbc_btnPiece3.gridy = 3;
		btnPiece3.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.buy(2);
				textP1.setText(game.getP1Status());
				textP2.setText(game.getP2Status());
				
				int[] next3 = game.getNextThree();
				piece1.setIcon(new ImageIcon("img/" + next3[0] + ".gif"));
				piece2.setIcon(new ImageIcon("img/" + next3[1] + ".gif"));
				piece3.setIcon(new ImageIcon("img/" + next3[2] + ".gif"));
				if(!game.isInProgress()) {
					btnPiece1.setEnabled(false);
					btnPiece2.setEnabled(false);
					btnPiece3.setEnabled(false);
					btnPass.setEnabled(false);
				}
			}
		});
		contentPane.add(btnPiece3, gbc_btnPiece3);
		
		// set pass button attributes
		GridBagConstraints gbc_btnPass = new GridBagConstraints();
		gbc_btnPass.insets = new Insets(0, 0, 0, 5);
		gbc_btnPass.ipadx = 30;
		gbc_btnPass.gridx = 1;
		gbc_btnPass.gridy = 4;
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.advance();
				textP1.setText(game.getP1Status());
				textP2.setText(game.getP2Status());
				
				if(!game.isInProgress()) {
					btnPiece1.setEnabled(false);
					btnPiece2.setEnabled(false);
					btnPiece3.setEnabled(false);
					btnPass.setEnabled(false);
				}
			}
		});
		contentPane.add(btnPass, gbc_btnPass);
	}

}
