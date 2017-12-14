package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class pRoom extends JFrame {

	private Room p2;

	public pRoom(Room p2) {
		setTitle("ChatPlanck\u00AE");
		setBounds(100, 100, 896, 666);
		this.p2=p2;
		p2.setBorder(new EmptyBorder(5, 5, 5, 5));
		p2.setLayout(new BorderLayout(0, 0));
		setContentPane(p2);
		this.setVisible(true);
	}

}