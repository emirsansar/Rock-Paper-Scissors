import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class rock_paper_scissors extends JFrame {

	private JPanel contentPane;
	private JTextField txtRockPaperScssors, txtPlayersScore, txtComputersScore;
	private JTextField textWin, textScorePlayer, textScoreComp;
	private JButton btnRock, btnPaper, btnScissors;
	private JButton btnRestart, btnExit, btnPlayAgain;
	
	private ImageIcon UserIcon = new ImageIcon(rock_paper_scissors.class.getResource("/images/user.png"));
	private ImageIcon ComputerIcon = new ImageIcon(rock_paper_scissors.class.getResource("/images/computer.png"));
	private JLabel labelPlayer = new JLabel(UserIcon);
	private JLabel labelComputer = new JLabel(ComputerIcon);

	private int playerScore=0, computerScore=0;
	private boolean isPlayed = false;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rock_paper_scissors frame = new rock_paper_scissors();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	private String computerMove() {
		String[] moves = {"ROCK", "PAPER", "SCISSORS"};
        Random random = new Random();
        return moves[random.nextInt(3)];
	}
	
	private void play( String playerMove ) {
		String compMove = computerMove();
		ImageIcon playerIcon, compIcon;
		
		try {
			if( playerMove.equals("ROCK") ) {
				 playerIcon = new ImageIcon(rock_paper_scissors.class.getResource("/images/playerIcons/playerRock.png"));
			} 
			else if ( playerMove.equals("PAPER") ) {
				 playerIcon = new ImageIcon(rock_paper_scissors.class.getResource("/images/playerIcons/playerPaper.png"));
			} else {
				 playerIcon = new ImageIcon(rock_paper_scissors.class.getResource("/images/playerIcons/playerScissors.png"));
			}
			
			if( compMove.equals("ROCK") ) {
				 compIcon = new ImageIcon(rock_paper_scissors.class.getResource("/images/computerIcons/compRock.png"));
			} 
			else if ( compMove.equals("PAPER") ) {
				 compIcon = new ImageIcon(rock_paper_scissors.class.getResource("/images/computerIcons/compPaper.png"));
			} else {
				 compIcon = new ImageIcon(rock_paper_scissors.class.getResource("/images/computerIcons/compScissors.png"));
			}
			changeImages(playerIcon, compIcon);
			
			checkWin(playerMove, compMove);
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void changeImages(ImageIcon PlayerIcon, ImageIcon CompIcon) {
		labelPlayer.setIcon(PlayerIcon);
		labelComputer.setIcon(CompIcon);
	}
	
	private void checkWin (String playerMove, String computerMove) { 

		if (playerMove.equals(computerMove)) {
	        textWin.setText("It's a draw!");
	    } 
		else if ( (playerMove.equals("ROCK") && computerMove.equals("SCISSORS")) ||
	              (playerMove.equals("PAPER") && computerMove.equals("ROCK")) ||
	              (playerMove.equals("SCISSORS") && computerMove.equals("PAPER")) ) {
	        textWin.setText("Player wins!");
	        playerScore++;
	    } 
		else {
	        textWin.setText("Computer wins!");
	        computerScore++;
	    }
		
		updateScores( playerScore, computerScore );
	}
	
	private void updateScores ( int playerScore, int compScore ) {
		textScorePlayer.setText(Integer.toString(playerScore));
	    textScoreComp.setText(Integer.toString(computerScore));
	}
	
	private void setVisibility () { 
		if ( !isPlayed ) {
			btnRock.setVisible(true); btnPaper.setVisible(true); btnScissors.setVisible(true); 
			btnPlayAgain.setVisible(false);
		} else {
			btnRock.setVisible(false); btnPaper.setVisible(false); btnScissors.setVisible(false); 
			btnPlayAgain.setVisible(true);
		}
	}


	public rock_paper_scissors() { 
		setTitle("Rock Paper Scissors - github.com/emirsansar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon appIcon = new ImageIcon(rock_paper_scissors.class.getResource("/images/appIcon.png"));
	    setIconImage(appIcon.getImage());
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBackground(new Color(222, 220, 220));
		panelStatus.setForeground(Color.LIGHT_GRAY);
		panelStatus.setBounds(10, 60, 528, 169);
		panelStatus.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		contentPane.add(panelStatus);
		panelStatus.setLayout(null);
		
		txtPlayersScore = new JTextField();
		txtPlayersScore.setBackground(new Color(222, 220, 220));
		txtPlayersScore.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPlayersScore.setText("Player's score:");
		txtPlayersScore.setEditable(false);
		txtPlayersScore.setBounds(161, 22, 156, 37);
		txtPlayersScore.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelStatus.add(txtPlayersScore);
		txtPlayersScore.setColumns(10);
		
		txtComputersScore = new JTextField();
		txtComputersScore.setBackground(new Color(222, 220, 220));
		txtComputersScore.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtComputersScore.setText("Computer's score:");
		txtComputersScore.setEditable(false);
		txtComputersScore.setColumns(10);
		txtComputersScore.setBounds(161, 70, 156, 37);
		txtComputersScore.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelStatus.add(txtComputersScore);
		
		textWin = new JTextField();
		textWin.setBackground(new Color(222, 220, 220));
		textWin.setFont(new Font("Tahoma", Font.ITALIC, 18));
		textWin.setHorizontalAlignment(SwingConstants.CENTER);
		textWin.setEditable(false);
		textWin.setColumns(10);
		textWin.setBounds(161, 118, 206, 37);
		textWin.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelStatus.add(textWin);
		
		textScorePlayer = new JTextField();
		textScorePlayer.setBackground(new Color(222, 220, 220));
		textScorePlayer.setHorizontalAlignment(SwingConstants.CENTER);
		textScorePlayer.setText("0");
		textScorePlayer.setEditable(false);
		textScorePlayer.setFont(new Font("Tahoma", Font.BOLD, 16));
		textScorePlayer.setBounds(321, 22, 33, 37);
		textScorePlayer.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelStatus.add(textScorePlayer);
		textScorePlayer.setColumns(10);
		
		textScoreComp = new JTextField();
		textScoreComp.setBackground(new Color(222, 220, 220));
		textScoreComp.setHorizontalAlignment(SwingConstants.CENTER);
		textScoreComp.setText("0");
		textScoreComp.setEditable(false);
		textScoreComp.setFont(new Font("Tahoma", Font.BOLD, 16));
		textScoreComp.setColumns(10);
		textScoreComp.setBounds(321, 70, 33, 37);
		textScoreComp.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelStatus.add(textScoreComp);
		
		labelPlayer.setBounds(10, 14, 141, 141);
		labelComputer.setBounds(377, 10, 141, 142);
		panelStatus.add(labelPlayer);
		panelStatus.add(labelComputer);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(new Color(222, 220, 220));
		panelButtons.setForeground(Color.LIGHT_GRAY);
		panelButtons.setBounds(10, 240, 528, 174);
		panelButtons.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		contentPane.add(panelButtons);
		panelButtons.setLayout(null);


		
		btnRock = new JButton();
		btnRock.setIcon(new ImageIcon(rock_paper_scissors.class.getResource("/images/buttonIcons/btnRock.png")));
		btnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isPlayed = true;
				setVisibility();
				play( "ROCK" );
			}
		});
		btnRock.setBounds(66, 11, 100, 100);
		btnRock.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		panelButtons.add(btnRock);
		

		btnPaper = new JButton();
		btnPaper.setIcon(new ImageIcon(rock_paper_scissors.class.getResource("/images/buttonIcons/btnPaper.png")));
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isPlayed = true;
				setVisibility();
				play( "PAPER" );
			}
		});
		btnPaper.setBounds(212, 11, 100, 100);
		btnPaper.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		panelButtons.add(btnPaper);
		
		btnScissors = new JButton();
		btnScissors.setIcon( new ImageIcon(rock_paper_scissors.class.getResource("/images/buttonIcons/btnScissors.png")));
		btnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isPlayed = true;
				setVisibility();
				play( "SCISSORS" );
			}
		});
		btnScissors.setBounds(358, 11, 100, 100);
		btnScissors.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		panelButtons.add(btnScissors);
		
		btnRestart = new JButton("RESTART");
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRestart.setBackground(Color.LIGHT_GRAY);
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isPlayed = false;
				setVisibility();
				textWin.setText("");
				playerScore=0; computerScore=0;
				updateScores( playerScore, computerScore );
				changeImages(UserIcon, ComputerIcon);
			}
		});
		btnRestart.setBounds(114, 125, 131, 40);
		panelButtons.add(btnRestart);
		
		btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(280, 125, 130, 40);
		panelButtons.add(btnExit);
		
		btnPlayAgain = new JButton("PLAY AGAIN");
		btnPlayAgain.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlayAgain.setBackground(Color.LIGHT_GRAY);
		btnPlayAgain.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				isPlayed = false;
				textWin.setText("");
				setVisibility();
				changeImages(UserIcon, ComputerIcon);
			}
		});
		btnPlayAgain.setBounds(190, 35, 150, 55);
		panelButtons.add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
		
		
		txtRockPaperScssors = new JTextField();
		txtRockPaperScssors.setBackground(Color.LIGHT_GRAY);
		txtRockPaperScssors.setFont(new Font("Tahoma", Font.BOLD, 21));
		txtRockPaperScssors.setText("ROCK PAPER SCISSORS");
		txtRockPaperScssors.setEditable(false);
		txtRockPaperScssors.setHorizontalAlignment(SwingConstants.CENTER);
		txtRockPaperScssors.setBounds(116, 11, 333, 38);
		txtRockPaperScssors.setBorder(new EmptyBorder(0, 0, 0, 0)); 
		contentPane.add(txtRockPaperScssors);
		txtRockPaperScssors.setColumns(10);
	}
}
