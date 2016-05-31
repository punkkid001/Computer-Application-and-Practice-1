package View;

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
import Model.Waste;

public class YardPage extends Place
{
	protected BufferedImage panelImg = null;
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
			this.playImg = ImageIO.read(new File("Img\\furniture\\play.png"));
			this.fightImg = ImageIO.read(new File("Img\\furniture\\fight.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
		
		btnGoShop = new JButton("Go Shop");
		btnGoShop.setBounds(0, 0, 300, 50);
		add(btnGoShop);
		
		btnGoBathroom = new JButton("Go Bathroom");
		btnGoBathroom.setBounds(300, 0, 300, 50);
		add(btnGoBathroom);
		
		btnGoLivingroom = new JButton("Go Livingroom");
		btnGoLivingroom.setBounds(600, 0, 300, 50);
		add(btnGoLivingroom);
		
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
	
	public void createPetIcon(Animal pet)
	{
		for (int i = 0; i < petIcon.length; i++)
		{
			if (petIcon[i] == null)
			{
				petIcon[i] = new PetLabel(pet, this);
				
				try {
					petIcon[i].setIcon(new ImageIcon(ImageIO.read(new File("Img\\Baby_cat\\ordinary.png"))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				petIcon[i].setBounds(336, 342, 100, 100);
				//petIcon[i].addMouseListener(this);
				this.add(petIcon[i]);
				petIcon[i].setVisible(true);
				
				break;
			}

			if (i == petIcon.length - 1)
				System.out.println("팻을 더 추가할 수 없습니다.");
		}
	}


	@Override
	public void delectIcon(Animal pet)
	{
		for(int i = 0; i < petIcon.length; i++)
		{
			if(petIcon[i] != null)
			{
				if(petIcon[i].pet == pet)
				{
					System.out.println(i + "??");
					petIcon[i].setVisible(false);
					petIcon[i] = null;
				}
			}
		}
	}
}