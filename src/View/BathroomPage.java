package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Waste;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;

public class BathroomPage extends Place
{	
	protected JButton btnGoShop;
	protected JButton btnGoYard;
	protected JButton btnGoLivingroom;
	protected JButton closetBtn;
	protected JButton toiletBtn;
	protected JLabel UsersClothItem;
	protected JPanel clothItemInfo;
	
	public JLabel simpleUserInfo;
	
	protected JButton []cloth;
	protected JLabel emptyLabel;
	/**
	 * Create the panel.
	 */
	public BathroomPage()
	{
		waste=new Waste[5];
        super.setPlaceName("Bathroom");
        
		setBounds(100, 100, 900, 540);
		setLayout(null);
		
		btnGoShop = new JButton("Go Shop");
		btnGoShop.setBounds(0, 0, 300, 50);
		add(btnGoShop);
		
		btnGoYard = new JButton("Go Yard");
		btnGoYard.setBounds(300, 0, 300, 50);
		add(btnGoYard);
		
		btnGoLivingroom = new JButton("Go Livingroom");
		btnGoLivingroom.setBounds(600, 0, 300, 50);
		add(btnGoLivingroom);
		
		simpleUserInfo = new JLabel();
		simpleUserInfo.setBounds(621, 60, 247, 43);
		add(simpleUserInfo);
		
		closetBtn = new JButton("Closet");
		closetBtn.setBounds(73, 96, 100, 100);
		add(closetBtn);
		
		toiletBtn = new JButton("Toilet");
		toiletBtn.setBounds(347, 96, 100, 100);
		add(toiletBtn);
		
		JButton petBtn = new JButton("Pet");
		petBtn.setBounds(347, 243, 100, 100);
		add(petBtn);

		//연결
		clothItemInfo = new JPanel();
		clothItemInfo.setBounds(41, 216, 192, 230);
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
		JPanel petInfo = new JPanel();
		petInfo.setBounds(673, 216, 195, 230);
		add(petInfo);
		petInfo.setLayout(null);
		
		petInfo.setVisible(false);
		
		//연결2
		JLabel petStat = new JLabel("Pet stat");
		petStat.setFont(new Font("굴림", Font.BOLD, 20));
		petStat.setBounds(61, 10, 134, 25);
		petInfo.add(petStat);
		
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
	}
}