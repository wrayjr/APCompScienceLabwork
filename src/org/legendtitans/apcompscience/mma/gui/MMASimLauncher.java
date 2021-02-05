package org.legendtitans.apcompscience.mma.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.legendtitans.apcompscience.mma.Fighter;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MMASimLauncher extends JFrame {

	private JPanel contentPane;
	Fighter player = new Fighter("Player", "Ruler of the game", 100, 100, 10, 40, null);
	Fighter opponent1 = new Fighter("Bad Man", "The Bad Guy", 100, 100, 6, 30, null);
	Fighter opponent2 = new Fighter("The Even Worse Man", "He's worst then the last guy", 100, 100, 15, 35, null);
	Fighter opponent3 = new Fighter("The Nice Guy", "He won't hurt", 100, 100, 4, 20, null);
	JLabel lblPlayerHealth = new JLabel("100");
	JLabel lblOpHealth = new JLabel("100");
	JLabel lblFightStatus = new JLabel("Let's get it on");
	JLabel lblFightStatus2 = new JLabel(opponent1.getName()+ ": "+ opponent1.getDescription());
	public boolean fight = true;
	public int sc = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MMASimLauncher frame = new MMASimLauncher();
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
	public MMASimLauncher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MMA Fighter");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(246, 16, 187, 65);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Attack");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(player.isAlive()== true) {
				initiateAttack();
				opponentAttack();
				fight = true;
				}
			}
		});
		btnNewButton.setBounds(55, 318, 115, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Defend");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(player.isAlive()== true) {
				opponentAttack();	
				initiateDefence();
				fight = true;
				}
			}
		});
		btnNewButton_1.setBounds(283, 318, 115, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Special");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(player.isAlive()== true ) {
				initiateSpecial();
				opponentAttack();
				fight = true;
				}
			}
		});
		btnNewButton_2.setBounds(528, 318, 115, 29);
		contentPane.add(btnNewButton_2);
		
		
		lblPlayerHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerHealth.setBounds(142, 259, 90, 29);
		contentPane.add(lblPlayerHealth);
		
		
		lblOpHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpHealth.setBounds(474, 263, 69, 20);
		contentPane.add(lblOpHealth);
		
		
		lblFightStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblFightStatus.setBounds(55, 78, 588, 20);
		contentPane.add(lblFightStatus);
		
		
		lblFightStatus2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFightStatus2.setBounds(55, 97, 588, 20);
		contentPane.add(lblFightStatus2);
	}

	public void initiateAttack() {
		
		if(player.isAlive()== true && opponent3.isAlive()== true && opponent2.isAlive()== false && opponent1.isAlive()== false) {
			int as = player.attack();
			opponent3.setCurrentHitPoints(as);		
			lblFightStatus.setText("You hit him with a strength of " + as);
			lblPlayerHealth.setText("" + player.getCurrentHitPoints());
			lblOpHealth.setText("" + opponent3.getCurrentHitPoints());
			if(opponent3.isAlive() == false) {
				lblFightStatus.setText("Player Wins");
				lblFightStatus2.setText("Game Over");
				fight = false;
				}
		}
		
		if(player.isAlive()== true && opponent2.isAlive()== true && opponent1.isAlive()== false) {
			int as = player.attack();
			opponent2.setCurrentHitPoints(as);		
			lblFightStatus.setText("You hit him with a strength of " + as);
			lblPlayerHealth.setText("" + player.getCurrentHitPoints());
			lblOpHealth.setText("" + opponent2.getCurrentHitPoints());
			if(opponent2.isAlive() == false) {
				lblFightStatus.setText("Player Wins");
				lblFightStatus2.setText(opponent3.getName()+ ": "+ opponent3.getDescription());
				player.heal();
				lblPlayerHealth.setText("" + player.getCurrentHitPoints());
				lblOpHealth.setText("" + opponent3.getCurrentHitPoints());
				fight = false;
				}
		}
				
		if(player.isAlive()== true && opponent1.isAlive()== true) {

			int as = player.attack();
			opponent1.setCurrentHitPoints(as);		
			lblFightStatus.setText("You hit him with a strength of " + as);
			lblPlayerHealth.setText("" + player.getCurrentHitPoints());
			lblOpHealth.setText("" + opponent1.getCurrentHitPoints());
			if(opponent1.isAlive() == false) {
				lblFightStatus.setText("Player Wins");
				lblFightStatus2.setText(opponent2.getName()+ ": "+ opponent2.getDescription());
				player.heal();
				lblPlayerHealth.setText("" + player.getCurrentHitPoints());
				lblOpHealth.setText("" + opponent2.getCurrentHitPoints());
				fight = false;
				}
			}
	}
	
	public void opponentAttack() {
		int oas = 0;
		if (fight == true) {
			
		if(opponent1.isAlive()==true) {                 
		oas = opponent1.attack();
		player.setCurrentHitPoints(oas);
		lblFightStatus2.setText("He hit you with a strength of " + oas);
		lblPlayerHealth.setText("" + player.getCurrentHitPoints());
		lblOpHealth.setText("" + opponent1.getCurrentHitPoints());
		if(player.isAlive() == false) {
			lblFightStatus.setText("Opponent Wins");
			lblFightStatus2.setText("");
			
		}
		}
		if(opponent2.isAlive()==true && opponent1.isAlive()== false) {                 
			oas = opponent1.attack();
			player.setCurrentHitPoints(oas);
			lblFightStatus2.setText("He hit you with a strength of " + oas);
			lblPlayerHealth.setText("" + player.getCurrentHitPoints());
			lblOpHealth.setText("" + opponent2.getCurrentHitPoints());
			if(player.isAlive() == false) {
				lblFightStatus.setText("Opponent Wins");
				lblFightStatus2.setText("");
				
			}
		}
	
		if(opponent3.isAlive()==true && opponent2.isAlive() == false) {                 
			oas = opponent3.attack();
			player.setCurrentHitPoints(oas);
			lblFightStatus2.setText("He hit you with a strength of " + oas);
			lblPlayerHealth.setText("" + player.getCurrentHitPoints());
			lblOpHealth.setText("" + opponent3.getCurrentHitPoints());
			if(player.isAlive() == false) {
				lblFightStatus.setText("Opponent Wins");
				lblFightStatus2.setText("");
				
			}
			}
		}}
	
	
	
	public void initiateDefence() {
		player.defend(); 
		lblFightStatus.setText("You now have " + player.getCurrentHitPoints() + " hit points.");
		lblPlayerHealth.setText("" + player.getCurrentHitPoints());
	}
	
	public void initiateSpecial() {
		if (sc >= 3) {
			lblFightStatus.setText("You are out of specials");
		}
		if(sc <3) {
			sc = sc + 1;
		if(player.isAlive()== true && opponent3.isAlive()== true && opponent2.isAlive()== false) {
			int as = player.special();
			opponent3.setCurrentHitPoints(as);		
			lblFightStatus.setText("You hit him with a strength of " + as);
			lblPlayerHealth.setText("" + player.getCurrentHitPoints());
			lblOpHealth.setText("" + opponent3.getCurrentHitPoints());
			if(opponent3.isAlive() == false) {
				lblFightStatus.setText("Player Wins");
				lblFightStatus2.setText("Game Over");
				fight = false;
				}
		}
		
		if(player.isAlive()== true && opponent2.isAlive()== true && opponent1.isAlive()== false) {
			int as = player.special();
			opponent2.setCurrentHitPoints(as);		
			lblFightStatus.setText("You hit him with a strength of " + as);
			lblPlayerHealth.setText("" + player.getCurrentHitPoints());
			lblOpHealth.setText("" + opponent2.getCurrentHitPoints());
			if(opponent2.isAlive() == false) {
				lblFightStatus.setText("Player Wins");
				lblFightStatus2.setText(opponent3.getName()+ ": "+ opponent3.getDescription());
				player.heal();
				lblPlayerHealth.setText("" + player.getCurrentHitPoints());
				lblOpHealth.setText("" + opponent3.getCurrentHitPoints());
				fight = false;
				}
		}
				
		if(player.isAlive()== true && opponent1.isAlive()== true) {

			int as = player.special();
			opponent1.setCurrentHitPoints(as);		
			lblFightStatus.setText("You hit him with a strength of " + as);
			lblPlayerHealth.setText("" + player.getCurrentHitPoints());
			lblOpHealth.setText("" + opponent1.getCurrentHitPoints());
			if(opponent1.isAlive() == false) {
				lblFightStatus.setText("Player Wins");
				lblFightStatus2.setText(opponent2.getName()+ ": "+ opponent2.getDescription());
				player.heal();
				lblPlayerHealth.setText("" + player.getCurrentHitPoints());
				lblOpHealth.setText("" + opponent2.getCurrentHitPoints());
				fight = false;
				}
			}}
	}
}
