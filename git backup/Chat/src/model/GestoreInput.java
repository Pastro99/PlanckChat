package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.DefaultListModel;

import view.PrivateWindow;

public class GestoreInput implements Runnable {

	private PrivateWindow stanza;
	private Thread t;
	private Socket socket;
	
	public GestoreInput(PrivateWindow stanza, Socket socket) {
		this.stanza=stanza;
		this.socket=socket;
		t=new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while(true) {
			BufferedReader in=null;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String s=null;
			try {
				s = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(s!=null) {
				if(s.equals("chatcloseprivate")) {
					break;
				}
				else if(!s.contains("chattitleNAME")){
					((DefaultListModel<String>)stanza.getList().getModel()).addElement("("+stanza.getTitle()+")  "+s); 
				}
				else {
					stanza.setTitle(s.split("\\|")[1]);
				}
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		stanza.dispose();
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.stop();
	}
}
