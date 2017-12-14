package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.DefaultListModel;

import model.GestoreInput;
import model.Persona;
import view.PrivateWindow;

public class ControlPrivate implements ActionListener {

	private PrivateWindow stanza;
	private Persona io;
	private Socket socket;
	private PrintWriter out;
	
	
	public ControlPrivate(Persona io,Socket socket,String title) throws IOException{
		stanza=new PrivateWindow();
		new GestoreInput(stanza,socket);
		this.io=io;
		this.socket=socket;
		stanza.setTitle(title);
		stanza.getSend().addActionListener(this);
		out=new PrintWriter(socket.getOutputStream(),true);
		
		System.out.println("prova controlprivate");
	}
	
	public ControlPrivate(Persona io,Socket socket) throws IOException{
		stanza=new PrivateWindow();
		new GestoreInput(stanza,socket);
		this.io=io;
		this.socket=socket;
		stanza.getSend().addActionListener(this);
		out=new PrintWriter(socket.getOutputStream(),true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==stanza.getSend() ){
			if(!stanza.getTextField().getText().trim().equals("")) {
				String s=stanza.getTextField().getText().trim();
				out.println(s);
				((DefaultListModel<String>)stanza.getList().getModel()).addElement("(io)  "+s);
				stanza.getTextField().setText("");
				stanza.getTextField().requestFocus();
			}
		}
	}


	public PrivateWindow getStanza() {
		return stanza;
	}


	public void setStanza(PrivateWindow stanza) {
		this.stanza = stanza;
	}


	public Persona getIo() {
		return io;
	}


	public void setIo(Persona io) {
		this.io = io;
	}


	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
