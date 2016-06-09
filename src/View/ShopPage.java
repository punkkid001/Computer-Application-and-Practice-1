package View;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Animal;
import Model.BabyCat;
import Model.BabyMonkey;
import Model.Cloth;
import Model.Food;
import Model.Potion;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class ShopPage extends Place
{
	public Food[] foodList;
	public Potion potion;
	public Cloth[] clothList;
	public Animal[] animalList;
	public Waste[] waste;
	
	protected BufferedImage panelImg = null;
	protected BufferedImage livingroomImg = null;
	protected BufferedImage bathroomImg = null;
	protected BufferedImage yardImg = null;
	protected BufferedImage tableImg = null;
	protected BufferedImage premiumImg = null;
	protected BufferedImage cakeImg = null;
	protected BufferedImage parfaitImg = null;
	protected BufferedImage hatImg = null;
	protected BufferedImage shoesImg = null;
	protected BufferedImage ribbonImg = null;
	protected BufferedImage babyCatImg = null;
	protected BufferedImage babyMonkeyImg = null;
	protected BufferedImage potionImg= null;
	
	protected JButton btnGoYard;
	protected JButton btnGoBathroom;
	protected JButton btnGoLivingroom;
	
	protected JButton btnBuy;
	protected JButton btnFood[]=new JButton[3];
	/*
	protected JButton btnPreminumFood;
	protected JButton btnCake;
	protected JButton btnParpait;
	*/
	protected JButton btnCloth[]=new JButton[3];
	protected JButton btnPet[]=new JButton[2];
	protected JButton btnPotion;
	
	/*
	protected JButton btnHat;
	protected JButton btnShoes;
	protected JButton btnRibbon;
	*/
	protected JButton btnSell;
	protected JButton[] btnUserFood=new JButton[3];
	protected JButton[] btnUserCloth=new JButton[3];
	//protected JButton[] btnUserPet=new JButton[2];
	protected JButton btnUserPotion;	
	
	protected JButton btnOk;
	protected JLabel labelInputPetName;
	protected JTextField textField;
	
	public JLabel simpleUserInfo;

	/**
	 * Create the panel.
	 */
	
	public ShopPage()
	{
		foodList = new Food[3];
		clothList = new Cloth[3];
		animalList = new Animal[2];
		//~~
		super.setPlaceName("Shop");
        waste=new Waste[5];
        
        foodList[0]=new Food("Premium", 5, 5, 5, 50);
        foodList[1]=new Food("Cake", 10, 5, 10, 200);
        foodList[2]=new Food("Parfait", 10, 5, 0, 80);
        
        potion=new Potion("???", 10, 5, 0, 100);
        
        clothList[0]=new Cloth("Hat", 5, 10, 50, 100);
        clothList[1]=new Cloth("Shoes", 15, 5, 50, 100);
        clothList[2]=new Cloth("Ribbon", 10, 10, 30, 50);

        animalList[0]=new BabyCat("Baby Cat", 200, false);
        animalList[1]=new BabyMonkey("Baby Monkey", 200, false);
                
        this.setBounds(100, 100, 900, 540);
		setLayout(null);
		
		try{
			this.panelImg = ImageIO.read(new File("Img\\place\\shop.png"));
			this.livingroomImg = ImageIO.read(new File("Img\\place\\mini\\livingroom.png"));
			this.bathroomImg = ImageIO.read(new File("Img\\place\\mini\\bathroom.png"));
			this.yardImg = ImageIO.read(new File("Img\\place\\mini\\yard.png"));
			this.tableImg = ImageIO.read(new File("Img\\item\\table.png"));
			this.premiumImg = ImageIO.read(new File("Img\\item\\premium.png"));
			this.cakeImg = ImageIO.read(new File("Img\\item\\cake.png"));
			this.parfaitImg = ImageIO.read(new File("Img\\item\\parfait.png"));
			this.hatImg = ImageIO.read(new File("Img\\item\\hat.png"));
			this.shoesImg = ImageIO.read(new File("Img\\item\\shoes.png"));
			this.ribbonImg = ImageIO.read(new File("Img\\item\\ribbon.png"));
			this.babyCatImg = ImageIO.read(new File("Img\\item\\cat.png"));
			this.babyMonkeyImg = ImageIO.read(new File("Img\\item\\monkey.png"));
			this.potionImg = ImageIO.read(new File("Img\\item\\potion.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
		btnGoLivingroom = new JButton(new ImageIcon(this.livingroomImg));
		btnGoLivingroom.setBounds(300, 440, 300, 100);
		add(btnGoLivingroom);
		
		btnGoBathroom = new JButton(new ImageIcon(this.bathroomImg));
		btnGoBathroom.setBounds(0, 440, 300, 100);
		add(btnGoBathroom);
		
		btnGoYard = new JButton(new ImageIcon(this.yardImg));
		btnGoYard.setBounds(600, 440, 300, 100);
		add(btnGoYard);
		
		simpleUserInfo = new JLabel();
		simpleUserInfo.setBounds(550, 15, 300, 30);
		simpleUserInfo.setBackground(Color.lightGray);
		simpleUserInfo.setOpaque(true);
		add(simpleUserInfo);
		
		JPanel buyPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				setOpaque(false);
				g.drawImage(tableImg, 0, 0, null);
			}
		};
		buyPanel.setBounds(50, 110, 250, 300);
		buyPanel.setLayout(null);
		add(buyPanel);
		
		/*JLabel buyLabel = new JLabel("BUY");
		buyLabel.setBounds(110, 0, 57, 15);
		buyPanel.add(buyLabel);*/
		btnBuy = new JButton("»ç±â");
		btnBuy.setBounds(80, 5, 90, 40);
		btnBuy.setFont(new Font("°íµñ", Font.BOLD, 20));
		btnBuy.setForeground(Color.white);
		btnBuy.setContentAreaFilled(false);
		btnBuy.setBorderPainted(false);
		btnBuy.setFocusPainted(false);
		buyPanel.add(btnBuy);
		
		//btnFood=new JButton[3];
		btnFood[0] = new JButton(new ImageIcon(this.premiumImg));
		btnFood[0].setBounds(10, 60, 70, 70);
		btnFood[0].setToolTipText(getTooltipText(foodList[0]));
		btnFood[0].setContentAreaFilled(false);
		btnFood[0].setBorderPainted(false);
		btnFood[0].setFocusPainted(false);
		buyPanel.add(btnFood[0]);
		
		btnFood[1]= new JButton(new ImageIcon(this.cakeImg));
		btnFood[1].setBounds(90, 60, 70, 70);
		btnFood[1].setToolTipText(getTooltipText(foodList[1]));
		btnFood[1].setContentAreaFilled(false);
		btnFood[1].setBorderPainted(false);
		btnFood[1].setFocusPainted(false);
		buyPanel.add(btnFood[1]);
		
		btnFood[2] = new JButton(new ImageIcon(this.parfaitImg));
		btnFood[2].setBounds(170, 60, 70, 70);
		btnFood[2].setToolTipText(getTooltipText(foodList[2]));
		btnFood[2].setContentAreaFilled(false);
		btnFood[2].setBorderPainted(false);
		btnFood[2].setFocusPainted(false);
		buyPanel.add(btnFood[2]);
		
		//btnCloth=new JButton[3];
		btnCloth[0] = new JButton(new ImageIcon(this.hatImg));
		btnCloth[0].setBounds(10, 140, 70, 70);
		btnCloth[0].setToolTipText(getTooltipText(clothList[0]));
		btnCloth[0].setContentAreaFilled(false);
		btnCloth[0].setBorderPainted(false);
		btnCloth[0].setFocusPainted(false);
		buyPanel.add(btnCloth[0]);
		
		btnCloth[1] = new JButton(new ImageIcon(this.shoesImg));
		btnCloth[1].setBounds(90, 140, 70, 70);
		btnCloth[1].setToolTipText(getTooltipText(clothList[1]));
		btnCloth[1].setContentAreaFilled(false);
		btnCloth[1].setBorderPainted(false);
		btnCloth[1].setFocusPainted(false);
		buyPanel.add(btnCloth[1]);
		
		btnCloth[2] = new JButton(new ImageIcon(this.ribbonImg));
		btnCloth[2].setBounds(170, 140, 70, 70);
		btnCloth[2].setToolTipText(getTooltipText(clothList[2]));
		btnCloth[2].setContentAreaFilled(false);
		btnCloth[2].setBorderPainted(false);
		btnCloth[2].setFocusPainted(false);
		buyPanel.add(btnCloth[2]);
		
		//btnPet=new JButton[2];
		btnPet[0] = new JButton(new ImageIcon(this.babyCatImg));
		btnPet[0].setBounds(10, 220, 70, 70);
		btnPet[0].setToolTipText(getTooltipText(animalList[0]));
		btnPet[0].setContentAreaFilled(false);
		btnPet[0].setBorderPainted(false);
		btnPet[0].setFocusPainted(false);
		buyPanel.add(btnPet[0]);
		
		btnPet[1] = new JButton(new ImageIcon(this.babyMonkeyImg));
		btnPet[1].setBounds(90, 220, 70, 70);
		btnPet[1].setToolTipText(getTooltipText(animalList[1]));
		btnPet[1].setContentAreaFilled(false);
		btnPet[1].setBorderPainted(false);
		btnPet[1].setFocusPainted(false);
		buyPanel.add(btnPet[1]);
		
		btnPotion = new JButton(new ImageIcon(this.potionImg));
		btnPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPotion.setBounds(170, 220, 70, 70);
		btnPotion.setToolTipText(getTooltipText(potion));
		btnPotion.setContentAreaFilled(false);
		btnPotion.setBorderPainted(false);
		btnPotion.setFocusPainted(false);
		buyPanel.add(btnPotion);
		
		buyPanel.setVisible(true);
		
		JPanel sellPanel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				setOpaque(true);
				g.drawImage(tableImg, 0, 0, null);
			}
		};
		sellPanel.setBounds(600, 110, 250, 300);
		sellPanel.setLayout(null);
		add(sellPanel);
		
		/*JLabel sellLabel = new JLabel("SELL");
		sellLabel.setBounds(111, 0, 57, 15);
		sellPanel.add(sellLabel);*/
		
		btnSell = new JButton("ÆÈ±â");
		btnSell.setBounds(80, 5, 90, 40);
		btnSell.setFont(new Font("°íµñ", Font.BOLD, 20));
		btnSell.setForeground(Color.white);
		btnSell.setContentAreaFilled(false);
		btnSell.setBorderPainted(false);
		btnSell.setFocusPainted(false);
		sellPanel.add(btnSell);
		
		btnUserFood[0] = new JButton("food1");
		btnUserFood[0].setBounds(10, 60, 70, 70);
		sellPanel.add(btnUserFood[0]);
		btnUserFood[0].setVisible(false);
		
		btnUserFood[1] = new JButton("food2");
		btnUserFood[1].setBounds(90, 60, 70, 70);
		sellPanel.add(btnUserFood[1]);
		btnUserFood[1].setVisible(false);
		
		btnUserFood[2] = new JButton("food3");
		btnUserFood[2].setBounds(170, 60, 70, 70);
		sellPanel.add(btnUserFood[2]);
		btnUserFood[2].setVisible(false);
		
		btnUserCloth[0] = new JButton("cloth1");
		btnUserCloth[0].setBounds(10, 140, 70, 70);
		sellPanel.add(btnUserCloth[0]);
		btnUserCloth[0].setVisible(false);
		
		btnUserCloth[1] = new JButton("cloth2");
		btnUserCloth[1].setBounds(90, 140, 70, 70);
		sellPanel.add(btnUserCloth[1]);
		btnUserCloth[1].setVisible(false);
		
		btnUserCloth[2] = new JButton("cloth3");
		btnUserCloth[2].setBounds(90, 140, 70, 70);
		sellPanel.add(btnUserCloth[2]);
		btnUserCloth[2].setVisible(false);
		
		/*
		btnUserPet[0] = new JButton("pet1");
		btnUserPet[0].setBounds(10, 220, 70, 70);
		sellPanel.add(btnUserPet[0]);
		btnUserPet[0].setVisible(false);
		
		btnUserPet[1] = new JButton("pet2");
		btnUserPet[1].setBounds(90, 220, 70, 70);
		sellPanel.add(btnUserPet[1]);
		btnUserPet[1].setVisible(false);
		*/
		
		btnUserPotion = new JButton(new ImageIcon(this.potionImg));
		btnUserPotion.setBounds(170, 220, 70, 70);
		sellPanel.add(btnUserPotion);
		btnUserPotion.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(353, 399, 116, 21);
		add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(478, 398, 66, 23);
		add(btnOk);
		btnOk.setVisible(false);
		
		labelInputPetName = new JLabel("Input Pet Name");
		labelInputPetName.setFont(new Font("±¼¸²", Font.BOLD, 14));
		labelInputPetName.setBounds(339, 381, 121, 15);
		add(labelInputPetName);
		labelInputPetName.setVisible(false);
		
		
	}
	
	public String getTooltipText(Food i)
	{
		String list[]=new String[5];
		String mergeList="";
	
		list[0]="Name : "+i.getName();
		list[1]="Fatigablity : "+Integer.toString(i.getFatigability());
		list[2]="Happiness : "+Integer.toString(i.getHappiness());
		list[3]="Satiety : "+Integer.toString(i.getSatiety());
		list[4]="Price : "+Integer.toString(i.getPrice());
		
		for(int j=0;j<list.length;j++)
			mergeList+=(list[j]+"/ ");
		
		return mergeList;
	}
	
	public String getTooltipText(Cloth i)
	{
		String list[]=new String[5];
		String mergeList="";
		
		list[0]="Name : "+i.getName();
		list[1]="Power : "+Integer.toString(i.getPower());
		list[2]="Defense : "+Integer.toString(i.getDefense());
		list[3]="Stemina : "+Integer.toString(i.getStemina());
		list[4]="Price : "+Integer.toString(i.getPrice());
		
		for(int j=0;j<list.length;j++)
			mergeList+=(list[j]+"/ ");
		
		return mergeList;
	}
	
	public String getTooltipText(Animal i)
	{
		String list[]=new String[2];
		String mergeList="";
		
		list[0]="Name : "+i.getName();
		list[1]="Price : "+Integer.toString(i.getPrice());
		
		for(int j=0;j<list.length;j++)
			mergeList+=(list[j]+"/ ");
		
		return mergeList;
	}
	
	public String getTooltipText(Potion i)
	{
		String list[]=new String[2];
		String mergeList="";
		
		list[0]="Name : "+i.getName();
		list[1]="Price : "+Integer.toString(i.getPrice());
		
		for(int j=0;j<list.length;j++)
			mergeList+=(list[j]+"/ ");
		
		return mergeList;
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(panelImg, 0, 0, null);
	}
	
	
}