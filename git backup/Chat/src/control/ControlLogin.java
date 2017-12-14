package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Persona;
import view.Login;

public class ControlLogin implements ActionListener {

	private Login f;
	private Persona p;
	private boolean flag=true;
	
	public ControlLogin(Login f, Persona p){
		this.f=f;
		this.p=p;
		f.getLogin().addActionListener(this);
		f.getExit().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==f.getLogin()){
			if(f.getTextField().getText().trim().equals("")){
				JOptionPane.showMessageDialog(null, "Errore", "Digitare un nickname", 0);
			}
			else{
				p.setPersona(f.getTextField().getText().trim());
				flag=false;
				f.setVisible(flag);
			}
		}
		
	}


	public Login getF() {
		return f;
	}


	public void setF(Login f) {
		this.f = f;
	}


	public Persona getP() {
		return p;
	}


	public void setP(Persona p) {
		this.p = p;
	}


	public boolean isFlag() {
		return flag;
	}

}
