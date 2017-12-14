package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class pLogin extends JFrame {

	private Login p1;

	public pLogin(Login p1) {
		setTitle("PlanckChat\u00AE Chatta durante le verifiche con Planckchat!!!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 476);
		this.p1=p1;
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		p1.setLayout(new BorderLayout(0, 0));
		setContentPane(p1);
		this.setVisible(true);
	}

}

