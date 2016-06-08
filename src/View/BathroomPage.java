package View;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;
import Model.Animal;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JTextPane;
import java.awt.Color;

public class BathroomPage extends Place
{	
	protected BufferedImage panelImg = null;
	protected BufferedImage arrowToYardImg = null;
	protected BufferedImage arrowToLivingroomImg = null;
	protected BufferedImage arrowToShopImg = null;
	protected BufferedImage closetImg = null;
	protected BufferedImage toiletImg = null;
	
	protected JButton btnGoShop;
	protected JButton btnGoYard;
	protected JButton btnGoLivingroom;
	protected JButton closetBtn;
	protected JButton toiletBtn;
	protected JLabel UsersClothItem;
	protected JPanel clothItemInfo;
	protected JPanel petInfo;
	
	protected JTextArea petItemList;
	protected JTextArea statArea;
	

	public JLabel simpleUserInfo;
	protected JLabel petStat;
	
	protected JButton []cloth;
	protected JLabel emptyLabel;
	/**
	 * Create the panel.
	 */
	public BathroomPage(Controller c)
	{
		super(c);
		
        super.setPlaceName("Bathroom");

		this.setBounds(100, 100, 900, 540);
		setLayout(null);
		
		try
		{
			this.panelImg = ImageIO.read(new File("Img\\place\\bathroom.png"));
			this.arrowToYardImg = ImageIO.read(new File("Img\\arrow\\arrow1.png"));
			this.arrowToLivingroomImg = ImageIO.read(new File("Img\\arrow\\arrow2.png"));
			this.arrowToShopImg = ImageIO.read(new File("Img\\arrow\\shop.png"));
			this.closetImg = ImageIO.read(new File("Img\\furniture\\closet.png"));
			this.toiletImg = ImageIO.read(new File("Img\\furniture\\toilet.png"));
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
		
		btnGoYard = new JButton(new ImageIcon(this.arrowToYardImg));
		btnGoYard.setBounds(5, 430, 70, 71);
		//버튼 투명화
		btnGoYard.setContentAreaFilled(false);
		btnGoYard.setBorderPainted(false);
		btnGoYard.setFocusPainted(false);
		add(btnGoYard);
		JLabel labelGoYard = new JLabel("마당");
		labelGoYard.setFont(new Font("고딕", Font.BOLD, 25));
		labelGoYard.setBounds(btnGoYard.getX(), btnGoYard.getY()-30, 80, 30);
		add(labelGoYard);
		
		btnGoLivingroom = new JButton(new ImageIcon(this.arrowToLivingroomImg));
		btnGoLivingroom.setBounds(810, 430, 70, 71);
		//버튼 투명화
		btnGoLivingroom.setContentAreaFilled(false);
		btnGoLivingroom.setBorderPainted(false);
		btnGoLivingroom.setFocusPainted(false);
		add(btnGoLivingroom);
		JLabel labelGoLivingroom = new JLabel("거실");
		labelGoLivingroom.setFont(new Font("고딕", Font.BOLD, 25));
		labelGoLivingroom.setBounds(btnGoLivingroom.getX(), btnGoLivingroom.getY()-30, 80, 30);
		add(labelGoLivingroom);
		
		simpleUserInfo = new JLabel();
		simpleUserInfo.setBounds(550, 15, 300, 30);
		simpleUserInfo.setBackground(Color.lightGray);
		simpleUserInfo.setOpaque(true);
		add(simpleUserInfo);
		
		closetBtn = new JButton(new ImageIcon(this.closetImg));
		closetBtn.setBounds(73, 350, 118, 124);
		//버튼 투명화
		closetBtn.setContentAreaFilled(false);
		closetBtn.setBorderPainted(false);
		closetBtn.setFocusPainted(false);
		add(closetBtn);
		
		toiletBtn = new JButton(new ImageIcon(this.toiletImg));
		toiletBtn.setBounds(700, 350, 111, 120);
		//버튼 투명화
		toiletBtn.setContentAreaFilled(false);
		toiletBtn.setBorderPainted(false);
		toiletBtn.setFocusPainted(false);
		add(toiletBtn);

		//연결
		clothItemInfo = new JPanel();
		clothItemInfo.setBounds(41, 100, 192, 230);
		add(clothItemInfo);
		clothItemInfo.setLayout(null);
		
		//연결
		UsersClothItem = new JLabel("User's cloth item");
		UsersClothItem.setFont(new Font("굴림", Font.BOLD, 20));
		UsersClothItem.setBounds(12, 10, 192, 15);
		clothItemInfo.add(UsersClothItem);
		
		cloth=new JButton[3];
		
		cloth[0] = new JButton("0");
		cloth[0].setBounds(48, 56, 97, 23);
		cloth[0].setVisible(false);
		clothItemInfo.add(cloth[0]);
		
		cloth[1] = new JButton("1");
		cloth[1].setBounds(48, 115, 97, 23);
		cloth[1].setVisible(false);
		clothItemInfo.add(cloth[1]);
		
		cloth[2] = new JButton("2");
		cloth[2].setBounds(48, 179, 97, 23);
		cloth[2].setVisible(false);
		clothItemInfo.add(cloth[2]);
		
		emptyLabel = new JLabel("Empty!");
		emptyLabel.setForeground(Color.RED);
		emptyLabel.setFont(new Font("굴림", Font.BOLD, 29));
		emptyLabel.setBounds(39, 71, 129, 53);
		emptyLabel.setVisible(false);
		clothItemInfo.add(emptyLabel);
		
		clothItemInfo.setVisible(false);
		
		//연결2
		petInfo = new JPanel();
		petInfo.setBounds(673, 100, 195, 230);
		add(petInfo);
		petInfo.setLayout(null);
		
		petInfo.setVisible(false);
		
		//연결2
		petStat = new JLabel("Pet stat");
		petStat.setFont(new Font("굴림", Font.BOLD, 20));
		petStat.setBounds(61, 10, 134, 25);
		petStat.setVisible(false);
		petInfo.add(petStat);
		
		statArea = new JTextArea();
		statArea.setBounds(12, 37, 171, 183);
		statArea.setEditable(false);
		statArea.setVisible(false);
		petInfo.add(statArea);
		
		/*
		//연결3
		JPanel petClick = new JPanel();
		petClick.setBounds(500, 243, 113, 119);
		add(petClick);
		
		//연결3
		JButton changePetPlaceBtn = new JButton("Change pet place");
		petClick.add(changePetPlaceBtn);
		
		//연결3
		JButton ridDrappingsBtn = new JButton("Rid drappings");
		petClick.add(ridDrappingsBtn);
		
		//연결3
		JButton undressBtn = new JButton("Undress");
		petClick.add(undressBtn);
		
		//연결3
		JButton checkPetStatBtn = new JButton("Check Pet Stat");
		petClick.add(checkPetStatBtn);
		
		petClick.setVisible(false);
		*/
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(panelImg, 0, 0, null);
	}
	
	
}