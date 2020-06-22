import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.SwingConstants;

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
		
		// set pane attributes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		// create pane features
		JTextArea textArea = new JTextArea();
		JButton btnNewGame = new JButton("New Game");
		JButton btnPiece1 = new JButton("Piece 1");
		JButton btnPiece2 = new JButton("Piece 2");
		JButton btnPiece3 = new JButton("Piece 3");
		JButton btnPass = new JButton("Pass");
		
		// set text area attributes
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 6;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.anchor = GridBagConstraints.NORTHWEST;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		textArea.setText(game.getStatus());
		contentPane.add(textArea, gbc_textArea);
		
		// set new game button attributes
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewGame.gridx = 1;
		gbc_btnNewGame.gridy = 0;
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.newGame();
				textArea.setText(game.getStatus());
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
		gbc_btnPiece1.insets = new Insets(0, 0, 5, 0);
		gbc_btnPiece1.gridx = 1;
		gbc_btnPiece1.gridy = 1;
		btnPiece1.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.buy(0);
				if(game.isInProgress()) {
					textArea.setText(game.getStatus());
				} else {
					textArea.setText("Game over.\n\n" + game.getStatus());
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
		gbc_btnPiece2.insets = new Insets(0, 0, 5, 0);
		gbc_btnPiece2.gridx = 1;
		gbc_btnPiece2.gridy = 2;
		btnPiece2.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.buy(1);
				if(game.isInProgress()) {
					textArea.setText(game.getStatus());
				} else {
					textArea.setText("Game over.\n\n" + game.getStatus());
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
		gbc_btnPiece3.gridx = 1;
		gbc_btnPiece3.gridy = 3;
		btnPiece3.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.buy(2);
				if(game.isInProgress()) {
					textArea.setText(game.getStatus());
				} else {
					textArea.setText("Game over.\n\n" + game.getStatus());
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
		gbc_btnPass.insets = new Insets(0, 0, 5, 0);
		gbc_btnPass.ipadx = 30;
		gbc_btnPass.gridx = 1;
		gbc_btnPass.gridy = 4;
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				game.advance();
				if(game.isInProgress()) {
					textArea.setText(game.getStatus());
				} else {
					textArea.setText("Game over.\n\n" + game.getStatus());
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
