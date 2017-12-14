package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import control.ControlPrivate;

public class Persona {

	private String persona;
	private String ip;
	private final int PORT=8888;
	private ServerSocket receive;
	
	public Persona(String persona) throws IOException {
		this.persona=persona;
		ip=InetAddress.getLocalHost().getHostAddress();
		receive= new ServerSocket(PORT);
		
	}
	
	public Persona(String persona, String ip) throws IOException {
		this.persona=persona;
		this.ip=ip;
		receive=null;
	}
	
	public void collegati(Persona p) throws UnknownHostException, IOException, InterruptedException {
		Socket temp=new Socket(p.getIp(),8888);
		ControlPrivate cp=new ControlPrivate(this,temp,p.getPersona());
		Thread.sleep(600);
		PrintWriter out = new PrintWriter(temp.getOutputStream(),true);
		out.println("chattitleNAME|"+persona);
	}
	
	public ServerSocket getReceive() {
		return receive;
	}

	@Override
	public String toString() {
		return persona + " | "+ip;
	}
	
	public boolean uguale(Persona p){
		return ip.equals(p.getIp());
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPORT() {
		return PORT;
	}
	

}
