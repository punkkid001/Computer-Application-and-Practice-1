package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import Model.Animal;

public class PetLabel extends JLabel implements Runnable, MouseListener {
	private Animal pet;
	private Place place;
	private JPopupMenu menu;
	private JPopupMenu placeMenu;
	
	public PetLabel() {
	}
	public PetLabel(Animal pet, Place place) {
		this.pet = pet;
		this.place = place;
		this.menu = new JPopupMenu();
		
		JMenuItem item1 = new JMenuItem("move");
		JMenu item2 = new JMenu("talk");
		JMenu item3 = new JMenu("change map");
		JMenu item4 = new JMenu("map behavior");
		JMenu item5 = new JMenu("pet behavior");
		
		menu.add(item1);
		menu.add(item2);
		JMenuItem talkItem1 = new JMenuItem("인사하기");
		JMenuItem talkItem2 = new JMenuItem("다정하게 말하기");
		JMenuItem talkItem3 = new JMenuItem("설교하기");
		item2.add(talkItem1);
		item2.add(talkItem2);
		item2.add(talkItem3);
		
		menu.add(item3);
		menu.add(item4);
		menu.add(item5);
		
		this.addMouseListener(this);
		
		this.setVisible(true);
		
	}
	@Override
	public void run() {
		int x = 0;
		int y = 0;
		
		// TODO Auto-generated method stub
		this.setBounds(250, 250, 100, 100);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this) {
			menu.show(this, this.getWidth(), 0);
			
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		/*
		if(e.isPopupTrigger()) {
			menu.show(e.getComponent(), e.getX(), e.getY());
		}*/
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	/*	// TODO Auto-generated method stub
		if(e.isPopupTrigger()) {
			menu.show(e.getComponent(), e.getX(), e.getY());
		}*/
	}
	
}
