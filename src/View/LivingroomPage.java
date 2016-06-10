package View;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JToolBar;

import Controller.Controller;
import Model.Animal;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

public class LivingroomPage extends Place
{
	
	protected BufferedImage panelImg = null;
	protected BufferedImage arrowToBathroomImg = null;
	protected BufferedImage arrowToYardImg = null;
	protected BufferedImage arrowToShopImg = null;
	protected BufferedImage fridgeImg = null;
	protected BufferedImage bedImg = null;

	protected JButton btnGoShop;
	protected JButton btnGoBathroom;
	protected JButton btnGoYard;
	protected JButton fridgeBtn;
	protected JButton bedBtn;
	protected JButton[] food;
	protected JButton btnPotion;
	
	protected JLabel labelEmpty;

	protected JPanel foodItemInfo;
	protected JLabel UsersFoodItem;
	
	protected JPopupMenu menu;
	protected JMenuItem []items=new JMenuItem[5];
	public JLabel simpleUserInfo;

	/**
	 * Create the panel.
	 */
	public LivingroomPage(Controller c)
	{
		super(c);
		
        super.setPlaceName("Livingroom");

		this.setBounds(100, 100, 900, 540);
		setLayout(null);
		
		try
		{
			this.panelImg = ImageIO.read(new File("Img\\place\\livingroom.png"));
			this.arrowToBathroomImg = ImageIO.read(new File("Img\\arrow\\arrow1.png"));
			this.arrowToYardImg = ImageIO.read(new File("Img\\arrow\\arrow2.png"));
			this.arrowToShopImg = ImageIO.read(new File("Img\\arrow\\shop.png"));
			this.fridgeImg = ImageIO.read(new File("Img\\furniture\\fridge.png"));
			this.bedImg = ImageIO.read(new File("Img\\furniture\\bed.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}

		btnGoShop = new JButton(new ImageIcon(this.arrowToShopImg));
		btnGoShop.setBounds(815, 5, 70, 65);
		//버튼 투명화
		btnGoShop.setContentAreaFilled(false);
		btnGoShop.setBorderPainted(false);
		btnGoShop.setFocusPainted(false);
		add(btnGoShop);

		btnGoBathroom = new JButton(new ImageIcon(this.arrowToBathroomImg));
		btnGoBathroom.setBounds(5, 430, 70, 71);
		//버튼 투명화
		btnGoBathroom.setContentAreaFilled(false);
		btnGoBathroom.setBorderPainted(false);
		btnGoBathroom.setFocusPainted(false);
		add(btnGoBathroom);
		JLabel labelGoBathroom = new JLabel("화장실");
		labelGoBathroom.setFont(new Font("고딕", Font.BOLD, 25));
		labelGoBathroom.setForeground(Color.white);
		labelGoBathroom.setBounds(btnGoBathroom.getX(), btnGoBathroom.getY()-30, 80, 30);
		add(labelGoBathroom);

		btnGoYard = new JButton(new ImageIcon(this.arrowToYardImg));
		btnGoYard.setBounds(810, 430, 70, 71);
		//버튼 투명화
		btnGoYard.setContentAreaFilled(false);
		btnGoYard.setBorderPainted(false);
		btnGoYard.setFocusPainted(false);
		add(btnGoYard);
		JLabel labelGoYard = new JLabel("마당");
		labelGoYard.setFont(new Font("고딕", Font.BOLD, 25));
		labelGoYard.setForeground(Color.white);
		labelGoYard.setBounds(btnGoYard.getX(), btnGoYard.getY()-30, 80, 30);
		add(labelGoYard);

		simpleUserInfo = new JLabel();
		simpleUserInfo.setBounds(550, 15, 300, 30);
		simpleUserInfo.setBackground(Color.lightGray);
		simpleUserInfo.setOpaque(true);
		add(simpleUserInfo);

		bedBtn = new JButton(new ImageIcon(this.bedImg));
		bedBtn.setBounds(100, 400, 150, 56);
		//버튼 투명화
		bedBtn.setContentAreaFilled(false);
		bedBtn.setBorderPainted(false);
		bedBtn.setFocusPainted(false);
		add(bedBtn);

		//JLabel foodBtn = new JLabel("Food");
		//foodBtn.setBounds(73, 290, 100, 100);
		//add(foodBtn);

		fridgeBtn = new JButton(new ImageIcon(this.fridgeImg));
		fridgeBtn.setBounds(620, 300, 88, 150);
		//버튼 투명화
		fridgeBtn.setContentAreaFilled(false);
		fridgeBtn.setBorderPainted(false);
		fridgeBtn.setFocusPainted(false);
		add(fridgeBtn);
		/*
		 * JButton petIcon = new JButton("Pet"); petIcon.setBounds(336, 342, 100,
		 * 100); add(petIcon);
		 */
		// 연결
		foodItemInfo = new JPanel();
		foodItemInfo.setBounds(621, 105, 229, 184);
		add(foodItemInfo);
		foodItemInfo.setLayout(null);

		// 연결
		UsersFoodItem = new JLabel("User's food item");
		UsersFoodItem.setBounds(0, 0, 113, 15);
		foodItemInfo.add(UsersFoodItem);
		
		food=new JButton[3];
		food[0] = new JButton("0");
		food[0].setBounds(71, 25, 97, 23);
		foodItemInfo.add(food[0]);
		food[0].setVisible(false);
		
		food[1]= new JButton("1");
		food[1].setBounds(71, 73, 97, 23);
		foodItemInfo.add(food[1]);
		food[1].setVisible(false);
		
		food[2] = new JButton("2");
		food[2].setBounds(71, 116, 97, 23);
		foodItemInfo.add(food[2]);
		food[2].setVisible(false);
		
		labelEmpty = new JLabel("Empty!");
		labelEmpty.setFont(new Font("굴림", Font.BOLD, 24));
		labelEmpty.setForeground(Color.RED);
		labelEmpty.setBounds(82, 52, 92, 43);
		foodItemInfo.add(labelEmpty);
		
		btnPotion = new JButton("potion");
		btnPotion.setBounds(77, 151, 97, 23);
		foodItemInfo.add(btnPotion);
		btnPotion.setVisible(false);
		
		foodItemInfo.setVisible(false);
		
		
	}
	public JButton getbtnPotion() {
		return this.btnPotion;
	}
	public JPanel getfoodItemInfo() {
		return this.foodItemInfo;
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(panelImg, 0, 0, null);
	}
	
}
