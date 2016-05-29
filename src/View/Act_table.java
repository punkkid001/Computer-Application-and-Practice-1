package View;

import Model.Animal;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Act_table extends JPanel implements ActionListener {
	//private JPanel mainpanel;
	
	private JButton button_shop;
	private JButton button_bathroom;
	private JButton button_livingroom;
	private JButton button_yard;
	
	public Act_table() {
		/*
		//test
		setTitle("이동하기");
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		this.setBounds(0, 0, 200, 180);
		//this.setBorder();
		this.setLayout(null);
		button_shop = new JButton("상점");
		button_bathroom = new JButton("화장실");
		button_livingroom = new JButton("거실");
		button_yard = new JButton("마당");
		button_shop.addActionListener(this);
		button_bathroom.addActionListener(this);
		button_livingroom.addActionListener(this);
		button_yard.addActionListener(this);
		
		this.add(button_shop);
		this.add(button_bathroom);
		this.add(button_livingroom);
		this.add(button_yard);
		
		/*
		mainpanel = new JPanel();
		mainpanel.setBounds(50, 50, 50, 250);
		mainpanel.add(button_bathroom);
		mainpanel.add(button_livingroom);
		mainpanel.add(button_shop);
		mainpanel.add(button_yard);
		add(mainpanel);
		*/
		
		this.button_bathroom.setBounds(150, 150, 50, 50);
		//add(panel1);
		this.button_livingroom.setBounds(150, 200, 50, 50);
		//add(panel2);
		this.button_shop.setBounds(150, 250, 50, 50);
		//add(panel3);
		this.button_yard.setBounds(150, 300, 50, 50);
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
