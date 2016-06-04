package View;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;
import Model.Animal;
import Model.BabyCat;
import Model.Waste;

public class YardPage extends Place
{
	protected BufferedImage panelImg = null;
	protected BufferedImage arrowToLivingroomImg = null;
	protected BufferedImage arrowToBathroomImg = null;
	protected BufferedImage arrowToShopImg = null;
	protected BufferedImage playImg = null;
	protected BufferedImage fightImg = null;
	
	protected JButton btnGoShop;	
	protected JButton btnGoBathroom;
	protected JButton btnGoLivingroom;
	protected JButton playBtn;
	protected JButton fightBtn; 
	protected PetLabel petIcon[];
	
	public JLabel simpleUserInfo;
	/**
	 * Create the panel.
	 */
	public YardPage(Controller c)
	{
		super(c);
		waste=new Waste[5];
        super.setPlaceName("Yard");
        
        petIcon = new PetLabel[5];
		for (int i = 0; i < petIcon.length; i++)
			petIcon[i] = null;

		this.setBounds(100, 100, 900, 540);
		setLayout(null);
		
		try{
			this.panelImg = ImageIO.read(new File("Img\\place\\yard.png"));
			this.arrowToLivingroomImg = ImageIO.read(new File("Img\\arrow\\arrow1.png"));
			this.arrowToBathroomImg = ImageIO.read(new File("Img\\arrow\\arrow2.png"));
			this.arrowToShopImg = ImageIO.read(new File("Img\\arrow\\shop.png"));
			this.playImg = ImageIO.read(new File("Img\\furniture\\play.png"));
			this.fightImg = ImageIO.read(new File("Img\\furniture\\fight.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
		
		btnGoShop = new JButton(new ImageIcon(this.arrowToShopImg));
		btnGoShop.setBounds(810, 5, 70, 65);
		//버튼 투명화
		btnGoShop.setContentAreaFilled(false);
		btnGoShop.setBorderPainted(false);
		btnGoShop.setFocusPainted(false);
		add(btnGoShop);
		
		btnGoLivingroom = new JButton(new ImageIcon(this.arrowToLivingroomImg));
		btnGoLivingroom.setBounds(5, 430, 70, 71);
		//버튼 투명화
		btnGoLivingroom.setContentAreaFilled(false);
		btnGoLivingroom.setBorderPainted(false);
		btnGoLivingroom.setFocusPainted(false);
		add(btnGoLivingroom);
		JLabel labelGoLivingroom = new JLabel("거실");
		labelGoLivingroom.setFont(new Font("돋움", Font.BOLD, 25));
		labelGoLivingroom.setBounds(btnGoLivingroom.getX(), btnGoLivingroom.getY()-30, 100, 30);
		add(labelGoLivingroom);
	
		btnGoBathroom = new JButton(new ImageIcon(this.arrowToBathroomImg));
		btnGoBathroom.setBounds(810, 430, 70, 71);
		//버튼 투명화
		btnGoBathroom.setContentAreaFilled(false);
		btnGoBathroom.setBorderPainted(false);
		btnGoBathroom.setFocusPainted(false);
		add(btnGoBathroom);
		JLabel labelGoBathroom = new JLabel("화장실");
		labelGoBathroom.setFont(new Font("돋움", Font.BOLD, 25));
		labelGoBathroom.setBounds(btnGoBathroom.getX(), btnGoBathroom.getY()-30, 100, 30);
		add(labelGoBathroom);
		
		simpleUserInfo = new JLabel();
		simpleUserInfo.setBounds(621, 60, 247, 43);
		add(simpleUserInfo);
		
		playBtn = new JButton(new ImageIcon(this.playImg));
		playBtn.setBounds(100, 350, 119, 120);
		//버튼 투명화
		playBtn.setContentAreaFilled(false);
		playBtn.setBorderPainted(false);	
		playBtn.setFocusPainted(false);
		add(playBtn);
		
		fightBtn = new JButton(new ImageIcon(this.fightImg));
		fightBtn.setBounds(632, 250, 197, 200);
		//버튼 투명화
		fightBtn.setContentAreaFilled(false);
		fightBtn.setBorderPainted(false);
		fightBtn.setFocusPainted(false);
		add(fightBtn);
		
		/*
		JButton petBtn = new JButton("Pet");
		petBtn.setBounds(336, 342, 100, 100);
		add(petBtn);
		*/
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(panelImg, 0, 0, null);
	}
	
}