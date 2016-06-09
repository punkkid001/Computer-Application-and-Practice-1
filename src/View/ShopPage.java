package View;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Animal;
import Model.BabyCat;
import Model.BabyMonkey;
import Model.Cloth;
import Model.Food;
import Model.Pet;
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
	
	protected JButton btnGoYard;
	protected JButton btnGoBathroom;
	protected JButton btnGoLivingroom;
	
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
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
		
		btnGoYard = new JButton("Go Yard");
		btnGoYard.setBounds(0, 0, 300, 50);
		add(btnGoYard);
		
		btnGoBathroom = new JButton("Go Bathroom");
		btnGoBathroom.setBounds(300, 0, 300, 50);
		add(btnGoBathroom);
		
		btnGoLivingroom = new JButton("Go Livingroom");
		btnGoLivingroom.setBounds(600, 0, 300, 50);
		add(btnGoLivingroom);
		
		simpleUserInfo = new JLabel();
		simpleUserInfo.setBounds(600, 50, 300, 30);
		simpleUserInfo.setBackground(Color.lightGray);
		simpleUserInfo.setOpaque(true);
		add(simpleUserInfo);
		
		JPanel buyPanel = new JPanel();
		buyPanel.setBounds(54, 130, 246, 341);
		buyPanel.setLayout(null);
		add(buyPanel);
		
		JLabel buyLabel = new JLabel("Buy");
		buyLabel.setBounds(110, 0, 57, 15);
		buyPanel.add(buyLabel);
		
		//btnFood=new JButton[3];
		btnFood[0] = new JButton("Preminum");
		btnFood[0].setBounds(74, 25, 97, 23);
		btnFood[0].setToolTipText(getTooltipText(foodList[0]));
		buyPanel.add(btnFood[0]);
		
		btnFood[1]= new JButton("Cake");
		btnFood[1].setBounds(74, 58, 97, 23);
		btnFood[1].setToolTipText(getTooltipText(foodList[1]));
		buyPanel.add(btnFood[1]);
		
		btnFood[2] = new JButton("Parfait");
		btnFood[2].setBounds(74, 91, 97, 23);
		btnFood[2].setToolTipText(getTooltipText(foodList[2]));
		buyPanel.add(btnFood[2]);
		
		//btnCloth=new JButton[3];
		btnCloth[0] = new JButton("Hat");
		btnCloth[0].setBounds(74, 130, 97, 23);
		btnCloth[0].setToolTipText(getTooltipText(clothList[0]));
		buyPanel.add(btnCloth[0]);
		
		btnCloth[1] = new JButton("Shoes");
		btnCloth[1].setBounds(74, 163, 97, 23);
		btnCloth[1].setToolTipText(getTooltipText(clothList[1]));
		buyPanel.add(btnCloth[1]);
		
		btnCloth[2] = new JButton("Ribbon");
		btnCloth[2].setBounds(74, 196, 97, 23);
		btnCloth[2].setToolTipText(getTooltipText(clothList[2]));
		buyPanel.add(btnCloth[2]);
		
		//btnPet=new JButton[2];
		btnPet[0] = new JButton("Baby Cat");
		btnPet[0].setBounds(74, 233, 97, 23);
		btnPet[0].setToolTipText(getTooltipText(animalList[0]));
		buyPanel.add(btnPet[0]);
		
		btnPet[1] = new JButton("Baby Monkey");
		btnPet[1].setBounds(67, 266, 111, 23);
		btnPet[1].setToolTipText(getTooltipText(animalList[1]));
		buyPanel.add(btnPet[1]);
		
		btnPotion = new JButton("???");
		btnPotion.setBounds(74, 308, 97, 23);
		btnPotion.setToolTipText(getTooltipText(potion));
		buyPanel.add(btnPotion);
		
		buyPanel.setVisible(true);
		
		JPanel sellPanel = new JPanel();
		sellPanel.setBounds(600, 130, 246, 341);
		sellPanel.setLayout(null);
		add(sellPanel);
		
		JLabel sellLabel = new JLabel("Sell");
		sellLabel.setBounds(111, 0, 57, 15);
		sellPanel.add(sellLabel);
		
		btnUserFood[0] = new JButton("food1");
		btnUserFood[0].setBounds(82, 40, 97, 23);
		sellPanel.add(btnUserFood[0]);
		btnUserFood[0].setVisible(false);
		
		btnUserFood[1] = new JButton("food2");
		btnUserFood[1].setBounds(82, 70, 97, 23);
		sellPanel.add(btnUserFood[1]);
		btnUserFood[1].setVisible(false);
		
		btnUserFood[2] = new JButton("food3");
		btnUserFood[2].setBounds(82, 103, 97, 23);
		sellPanel.add(btnUserFood[2]);
		btnUserFood[2].setVisible(false);
		
		btnUserCloth[0] = new JButton("cloth1");
		btnUserCloth[0].setBounds(82, 136, 97, 23);
		sellPanel.add(btnUserCloth[0]);
		btnUserCloth[0].setVisible(false);
		
		btnUserCloth[1] = new JButton("cloth2");
		btnUserCloth[1].setBounds(82, 169, 97, 23);
		sellPanel.add(btnUserCloth[1]);
		btnUserCloth[1].setVisible(false);
		
		btnUserCloth[2] = new JButton("cloth3");
		btnUserCloth[2].setBounds(82, 202, 97, 23);
		sellPanel.add(btnUserCloth[2]);
		btnUserCloth[2].setVisible(false);
		
		/*
		btnUserPet[0] = new JButton("pet1");
		btnUserPet[0].setBounds(82, 235, 97, 23);
		sellPanel.add(btnUserPet[0]);
		btnUserPet[0].setVisible(false);
		
		btnUserPet[1] = new JButton("pet2");
		btnUserPet[1].setBounds(82, 268, 97, 23);
		sellPanel.add(btnUserPet[1]);
		btnUserPet[1].setVisible(false);
		*/
		
		btnUserPotion = new JButton("potion");
		btnUserPotion.setBounds(82, 301, 97, 23);
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
	
	@Override
	public void deleteIcon(Animal pet) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void createPetIcon(Animal pet) {
		// TODO Auto-generated method stub
		
	}
}