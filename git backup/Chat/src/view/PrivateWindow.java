package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PrivateWindow extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList<String> list;
	private JTextField textField;
	private JButton btnNewButton;


	public PrivateWindow() {
		setBounds(100, 100, 371, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 335, 331);
		contentPane.add(scrollPane);
		
		list = new JList<String>();
		list.setModel(new DefaultListModel<String>());
		scrollPane.setViewportView(list);
		
		textField = new JTextField();
		textField.setBounds(10, 362, 272, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Send");
		btnNewButton.setBounds(282, 361, 63, 23);
		contentPane.add(btnNewButton);
		setVisible(true);
	}

	public String getTitleWindow() {
		return getTitle();
	}
	
	public JList getList() {
		return list;
	}


	public void setList(JList list) {
		this.list = list;
	}


	public JTextField getTextField() {
		return textField;
	}


	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	public JButton getSend() {
		return btnNewButton;
	}


	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
	
	public void setTitleWindow(String t) {
		setTitle(t);
	}
}
