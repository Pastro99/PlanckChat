package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class Room extends JPanel {
	private JScrollPane scrollPane_1;
	private JList<String> list_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblRoomChatplanck;
	private JButton btnNewButton_1;
	private JLabel lblUsers;
	private JScrollPane scrollPane;
	private JList<String> list;

	public JList getList_1() {
		return list_1;
	}

	public JList getList() {
		return list;
	}

	/**
	 * Create the panel.
	 */
	public Room() {
		setBackground(new Color(169, 169, 169));
		setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(305, 77, 539, 454);
		add(scrollPane_1);
		
		list_1 = new JList<String>(new DefaultListModel<String>());
		scrollPane_1.setViewportView(list_1);
		
		textField = new JTextField();
		textField.setBounds(305, 539, 451, 20);
		add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Send");
		btnNewButton.setBounds(755, 538, 89, 23);
		add(btnNewButton);
		
		lblRoomChatplanck = new JLabel("Room ChatPlanck");
		lblRoomChatplanck.setForeground(new Color(128, 0, 0));
		lblRoomChatplanck.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblRoomChatplanck.setBounds(303, 43, 192, 23);
		add(lblRoomChatplanck);
		
		btnNewButton_1 = new JButton("Go Private");
		btnNewButton_1.setBounds(83, 540, 101, 23);
		add(btnNewButton_1);
		
		lblUsers = new JLabel("USERS:");
		lblUsers.setForeground(new Color(128, 0, 0));
		lblUsers.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUsers.setBounds(34, 43, 192, 23);
		add(lblUsers);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 77, 223, 454);
		add(scrollPane);
		
		list = new JList<String>(new DefaultListModel<String>());
		scrollPane.setViewportView(list);

	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public void setScrollPane_1(JScrollPane scrollPane_1) {
		this.scrollPane_1 = scrollPane_1;
	}

	public JList<String> getRoomList() {
		return list_1;
	}

	public void setList_1(JList list_1) {
		this.list_1 = list_1;
	}

	public JTextField getTextMessagge() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JButton getBtnSend() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JLabel getLblRoomChatplanck() {
		return lblRoomChatplanck;
	}

	public void setLblRoomChatplanck(JLabel lblRoomChatplanck) {
		this.lblRoomChatplanck = lblRoomChatplanck;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	public JLabel getLblUsers() {
		return lblUsers;
	}

	public void setLblUsers(JLabel lblUsers) {
		this.lblUsers = lblUsers;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JList<String> getLobbyList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}
	
	
}
