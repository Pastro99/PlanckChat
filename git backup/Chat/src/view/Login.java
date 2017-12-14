package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JPanel {
	private JLabel lblTris;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnExit;
	private JLabel lblAkkaCorporation;


	public Login() {
		setBackground(new Color(169, 169, 169));
		setLayout(null);
		
		lblTris = new JLabel("PlanckChat");
		lblTris.setForeground(new Color(128, 0, 0));
		lblTris.setFont(new Font("BankGothic Md BT", Font.PLAIN, 41));
		lblTris.setBounds(160, 11, 271, 124);
		add(lblTris);
		
		textField = new JTextField();
		textField.setBounds(165, 218, 252, 20);
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(244, 193, 100, 14);
		add(lblNewLabel);
		
		btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(165, 264, 89, 23);
		add(btnNewButton);
		
		btnExit = new JButton("EXIT");
		btnExit.setBounds(328, 264, 89, 23);
		add(btnExit);
		
		lblAkkaCorporation = new JLabel("AKKA Corporation\u00AE Via nonlaricordo 0 Planck (it) Copyright about Pastrolin&Rizzato\u00AE");
		lblAkkaCorporation.setBounds(10, 405, 551, 14);
		add(lblAkkaCorporation);

	}


	public JLabel getLblTris() {
		return lblTris;
	}


	public JTextField getTextField() {
		return textField;
	}


	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}


	public JButton getLogin() {
		return btnNewButton;
	}


	public JButton getExit() {
		return btnExit;
	}


	public JLabel getLblAkkaCorporation() {
		return lblAkkaCorporation;
	}
}
