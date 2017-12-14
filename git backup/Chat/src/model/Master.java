package model;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import view.Room;

public class Master implements Runnable{
	
	private Persona io;
	private ArrayList<Persona> utenti;
	private Room stanza;
	private Thread t;
	private static DatagramSocket socket;
	private boolean state;

	public Master(Persona io, ArrayList<Persona> utenti, Room stanza) throws SocketException {
		this.io=io;
		this.utenti=utenti;
		this.stanza=stanza;
		socket= new DatagramSocket(9000);
		state=true;
		
		t=new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		byte[] mesbuff = new byte[2048];
		DatagramPacket packet = new DatagramPacket(mesbuff,mesbuff.length);
		
		while(true) {
			try {
				socket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] s= new String(packet.getData(),0,packet.getLength()).split("\\|");
			if(s[0].equals("chatpulse")) { //add persona
				try {
					Persona temp=new Persona(s[1],s[2]);
					boolean flag=true;
					if(!io.uguale(temp)){
						for(int i=0;i<utenti.size() && flag;i++){
							if(utenti.get(i).uguale(temp)){
								flag=false;
							}
						}
						if(flag){
							utenti.add(temp);
							((DefaultListModel<String>)stanza.getLobbyList().getModel()).addElement(temp.toString());
						}
					}
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(s[0].equals("chatmessagge")) {
				((DefaultListModel<String>)stanza.getRoomList().getModel()).addElement("("+s[1]+")  "+s[2]);
			}
			else if(s[0].equals("chaterase")) {
				for(int i=0;i<utenti.size();i++){ //elimina utente
					Persona temp=null;
					try {
						temp = new Persona(s[1],s[2]);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(utenti.get(i).uguale(temp)) {
						utenti.remove(i);
					}
				}
				stampaUtenti(); //ristampa lista
			}
			
		}
	}
	
	private void stampaUtenti() {
		DefaultListModel<String> temp= new DefaultListModel<String>();
		for(int i=0;i<utenti.size();i++) {
			temp.addElement(utenti.get(i).toString());
		}
		stanza.getLobbyList().setModel(temp);
	}

}
