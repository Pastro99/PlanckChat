package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import model.Persona;
import view.Room;
public class ControlRoom implements ActionListener{

	private Persona io;
	private ArrayList<Persona> utenti;
	private Room stanza;
	private DatagramSocket socket;
	
	public ControlRoom(Room stanza, Persona io, ArrayList<Persona> utenti, DatagramSocket socket) {
		this.stanza=stanza;
		this.io=io;
		this.utenti=utenti;
		this.socket=socket;
		
		stanza.getBtnSend().addActionListener(this);
		stanza.getBtnNewButton_1().addActionListener(this);
		System.out.println("costruttore");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==stanza.getBtnSend()) {
			if(!stanza.getTextMessagge().getText().trim().equals("")) { //invio messaggio
				String s="chatmessagge|"+io.getPersona()+"|"+stanza.getTextMessagge().getText().trim();
				DatagramPacket packet=null;
				try {
					packet = new DatagramPacket(s.getBytes(),s.getBytes().length,InetAddress.getByName("255.255.255.255"),9000);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					socket.send(packet);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stanza.getTextMessagge().setText("");
				stanza.getTextMessagge().requestFocus();
			}
		}
		else if(e.getSource()==stanza.getBtnNewButton_1()) {
			int index;
			index=stanza.getLobbyList().getSelectedIndex();
			if(index!=-1) {
				try {
					io.collegati(utenti.get(index));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

}
