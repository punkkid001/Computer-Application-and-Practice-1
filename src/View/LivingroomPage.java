package View;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Graphics;
import javax.swing.JToolBar;

import Controller.Controller;
import Model.Animal;
import Model.Waste;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

public class LivingroomPage extends Place implements MouseListener {
	
	protected BufferedImage panelImg = null;
	protected BufferedImage fridgeImg = null;
	protected BufferedImage bedImg = null;

	protected JButton btnGoShop;
	protected JButton btnGoBathroom;
	protected JButton btnGoYard;
	protected PetLabel petIcon[];
	protected JButton fridgeBtn;
	protected JButton bedBtn;

	protected JPanel foodItemInfo;
	protected JLabel UsersFoodItem;
	protected JTextArea foodItemList;

	public JLabel simpleUserInfo;

	/**
	 * Create the panel.
	 */
	public LivingroomPage(Controller c) {
		super(c);
		waste=new Waste[5];
        super.setPlaceName("Livingroom");
		
		petIcon = new PetLabel[5];
		for (int i = 0; i < petIcon.length; i++)
			petIcon[i] = null;

		this.setBounds(100, 100, 900, 540);
		setLayout(null);
		
		try{
			this.panelImg = ImageIO.read(new File("Img\\place\\livingroom.png"));
			this.fridgeImg = ImageIO.read(new File("Img\\furniture\\fridge.png"));
			this.bedImg = ImageIO.read(new File("Img\\furniture\\bed.png"));
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

		btnGoYard = new JButton("Go Yard");
		btnGoYard.setBounds(600, 0, 300, 50);
		add(btnGoYard);

		simpleUserInfo = new JLabel();
		simpleUserInfo.setBounds(621, 60, 247, 43);
		add(simpleUserInfo);

		bedBtn = new JButton(new ImageIcon(this.bedImg));
		bedBtn.setBounds(100, 400, 150, 56);
		//버튼 투명화
		bedBtn.setContentAreaFilled(false);
		bedBtn.setBorderPainted(false);
		bedBtn.setFocusPainted(false);
		add(bedBtn);

		JLabel foodBtn = new JLabel("Food");
		foodBtn.setBounds(73, 290, 100, 100);
		add(foodBtn);

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
		foodItemInfo.setBounds(621, 140, 229, 149);
		add(foodItemInfo);
		foodItemInfo.setLayout(null);

		// 연결
		UsersFoodItem = new JLabel("user's food item");
		UsersFoodItem.setBounds(0, 0, 92, 15);
		foodItemInfo.add(UsersFoodItem);

		foodItemList = new JTextArea();
		foodItemList.setBounds(10, 25, 207, 114);
		foodItemInfo.add(foodItemList);

		foodItemInfo.setVisible(false);
		
		/*
		// 연결3
		JPanel petClick = new JPanel();
		petClick.setBounds(479, 333, 153, 119);
		add(petClick);

		// 연결3
		JButton changePetPlaceBtn = new JButton("Change pet place");
		petClick.add(changePetPlaceBtn);

		JLabel label = new JLabel("");
		petClick.add(label);

		// 연결3
		JButton talkBtn = new JButton("Talk");
		petClick.add(talkBtn);

		// 연결3
		JButton sleepBtn = new JButton("Sleep");
		petClick.add(sleepBtn);

		// 연결3
		JButton feedBtn = new JButton("Feed");
		petClick.add(feedBtn);

		JLabel label_1 = new JLabel("");
		petClick.add(label_1);

		petClick.setVisible(false);
		*/
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(panelImg, 0, 0, null);
	}

	public void createPetIcon(Animal pet) {
		for (int i = 0; i < petIcon.length; i++) {
			if (petIcon[i] == null) {
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
	
	public void delectIcon(Animal pet)
	{
		for(int i = 0; i < petIcon.length; i++)
		{
			if(petIcon[i] != null) {
				if(petIcon[i].pet == pet)
				{
					System.out.println(i + "??");
					petIcon[i].setVisible(false);
					petIcon[i] = null;
				}
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
