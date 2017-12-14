package model;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Pulse implements Runnable {
	
	private static DatagramSocket socket;
	private Persona p;
	
	public Pulse(DatagramSocket socket, Persona p) throws SocketException{
		this.socket=socket;
		this.p=p;
		socket.setBroadcast(true);
		Thread t=new Thread(this);
		t.start();	
	}
	
	
	
	@Override
	public void run() {
		String mes=null;
		mes = "chatpulse|"+p.getPersona()+"|"+p.getIp();
		while(true){
			DatagramPacket packet=null;
			try {
				packet = new DatagramPacket(mes.getBytes(), mes.getBytes().length,InetAddress.getByName("255.255.255.255"),9000);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}