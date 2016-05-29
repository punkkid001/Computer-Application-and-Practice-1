package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import Model.Animal;

public class PetLabel extends JLabel implements Runnable {
	private Animal pet;
	private JPanel menu;
	private JPanel place;
	
	public PetLabel() {
	}
	public PetLabel(Animal pet, JPanel place) {
		this.pet = pet;
		this.place = place;
		
		this.setIcon(new ImageIcon("Img\babycat.jpg"));
		this.setVisible(true);
		
	}
	@Override
	public void run() {
		int x = 0;
		int y = 0;
		
		// TODO Auto-generated method stub
		this.setBounds(250, 250, 100, 100);
	}
	
}
