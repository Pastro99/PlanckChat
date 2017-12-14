package model;

import java.io.IOException;
import java.net.Socket;

import control.ControlPrivate;

public class GestoreRichieste implements Runnable {

	private Persona p;
	private Socket socket;
	
	public GestoreRichieste(Persona p) {
		this.p=p;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while(true) {
			try {
				socket=p.getReceive().accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				new ControlPrivate(p,socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
