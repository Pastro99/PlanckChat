import model.*;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import control.*;
import view.*;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		Room room=new Room();
		Login login=new Login();
		Persona person = new Persona("");
		ArrayList<Persona> utenti = new ArrayList<Persona>();
		pLogin pl=new pLogin(login);
		ControlLogin cl = new ControlLogin(login,person);
		while(cl.isFlag()) {
			Thread.sleep(200);
		}
		pl.dispose();
		pRoom pr = new pRoom(room);
		pr.setTitle(person.getPersona());
		DatagramSocket datasocket= new DatagramSocket();
		Pulse pulse= new Pulse(datasocket,person);
		Master master= new Master(person, utenti, room);
		ControlRoom controlroom = new ControlRoom(room,person,utenti,datasocket);
		GestoreRichieste richiestegestione = new GestoreRichieste(person);
		ControlWindow cw = new ControlWindow(datasocket,pr,person);
	}
}
