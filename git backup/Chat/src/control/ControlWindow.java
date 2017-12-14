package control;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import model.Persona;
import view.pRoom;

public class ControlWindow implements WindowListener {

	private DatagramSocket socket;
	private pRoom stanza;
	private Persona io;
	
	public ControlWindow(DatagramSocket socket,pRoom stanza, Persona io) {
		this.socket=socket;
		this.stanza=stanza;
		this.io=io;
		
		stanza.addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		String s="chaterase|"+io.getPersona()+"|"+io.getIp();
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
		
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
