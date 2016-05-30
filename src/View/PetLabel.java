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
	private int flag;
	public PetLabel() {
		setText("hihih");
	}
	public PetLabel(Animal pet, Place place) {
		this.pet = pet;
		this.place = place;
		this.menu = new JPopupMenu();
		this.setText(pet.getName());
		
		this.flag = 0;
		JMenuItem item1 = new JMenuItem("move");
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				// TODO Auto-generated method stub
				place.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(flag == 1) {
							System.out.println(e.getX() + " " + e.getY());
							flag = 0;
						}
					}
				});
			}
			
		});
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
		JMenuItem mapItem1 = new JMenuItem("Livingroom");
		JMenuItem mapItem2 = new JMenuItem("Bathroom");
		JMenuItem mapItem3 = new JMenuItem("Yard");
		
		menu.add(item4);
		JMenuItem behaviorItem1 = new JMenuItem("잠자기");
		JMenuItem behaviorItem2 = new JMenuItem("먹이주기");
		
		JMenuItem behaviorItem3 = new JMenuItem("놀아주기");
		JMenuItem behaviorItem4 = new JMenuItem("대전하기");
		
		JMenuItem behaviorItem5 = new JMenuItem("똥치우기");
		JMenuItem behaviorItem6 = new JMenuItem("옷벗기");
		JMenuItem behaviorItem7 = new JMenuItem("스탯확인");
		if(this.place instanceof LivingroomPage) {
			item3.add(mapItem2);
			item3.add(mapItem3);
			item4.add(behaviorItem1);
			item4.add(behaviorItem2);
		} else if(this.place instanceof BathroomPage) {
			item3.add(mapItem1);
			item3.add(mapItem3);
			item4.add(behaviorItem5);
			item4.add(behaviorItem6);
			item4.add(behaviorItem7);
		} else if(this.place instanceof YardPage) {
			item3.add(mapItem1);
			item3.add(mapItem2);
			item4.add(behaviorItem3);
			item4.add(behaviorItem4);
		}
			
		
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
