package View;

import Model.Animal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class Act_table extends JPanel implements ActionListener {
	//private JPanel mainpanel;
	
	private JButton button_shop;
	private JButton button_bathroom;
	private JButton button_livingroom;
	private JButton button_yard;
	
	public Act_table(int x, int y) {
		setBackground(Color.PINK);
		this.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		/*
		//test
		setTitle("이동하기");
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		this.setBounds(x, y, 85, 152);
		button_yard = new JButton("마당");
		button_yard.setBounds(38, 45, 73, 27);
		button_yard.addActionListener(this);
		button_livingroom = new JButton("거실");
		button_livingroom.setBounds(37, 12, 73, 27);
		button_livingroom.setBackground(Color.WHITE);
		button_livingroom.addActionListener(this);
		setLayout(null);
		this.add(button_livingroom);
		this.add(button_yard);
		button_bathroom = new JButton("\uC7A5\uC2E4");
		button_bathroom.setBounds(37, 79, 73, 27);
		button_bathroom.addActionListener(this);
		this.add(button_bathroom);
		button_shop = new JButton("상점");
		button_shop.setBounds(37, 113, 73, 27);
		button_shop.addActionListener(this);
		
		this.add(button_shop);
		//add(panel4);
		
		//setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Place move = new Place();

		if ("button_shop".equals(e.getActionCommand()))
			move.goShop(null);
		else if("button_bathroom".equals(e.getActionCommand()))
			move.goBathroom(null);
		else if("button_livingroom".equals(e.getActionCommand()))
			move.goLivingroom(null);
		else if("button_yard".equals(e.getActionCommand()))
			move.goYard(null);
		
		
	}
	

}
