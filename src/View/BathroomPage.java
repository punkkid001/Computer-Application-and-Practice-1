package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Waste;

import javax.swing.JTextArea;

public class BathroomPage extends Place
{	
	protected JButton btnGoShop;
	protected JButton btnGoYard;
	protected JButton btnGoLivingroom;
	protected JButton closetBtn;
	protected JButton toiletBtn;
	
	protected JLabel UsersClothItem;
	protected JPanel clothItemInfo;
	
	protected JTextArea petItemList;
	protected JTextArea petStatList;
	
	public JLabel simpleUserInfo;
	/**
	 * Create the panel.
	 */
	public BathroomPage()
	{
		waste=new Waste[5];
        super.setPlaceName("Bathrood");
        
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
		clothItemInfo.setBounds(41, 216, 192, 265);
		add(clothItemInfo);
		clothItemInfo.setLayout(null);
		
		//연결
		UsersClothItem = new JLabel("user's cloth item");
		UsersClothItem.setBounds(0, 0, 134, 15);
		clothItemInfo.add(UsersClothItem);
		
		petItemList = new JTextArea();
		petItemList.setBounds(10, 25, 170, 230);
		clothItemInfo.add(petItemList);
		clothItemInfo.setVisible(false);
		
		//연결2
		JPanel petInfo = new JPanel();
		petInfo.setBounds(673, 216, 195, 265);
		add(petInfo);
		petInfo.setLayout(null);
		
		petInfo.setVisible(false);
		
		//연결2
		JLabel petStat = new JLabel("Pet stat");
		petStat.setBounds(0, 0, 134, 15);
		petInfo.add(petStat);
		
		petStatList = new JTextArea();
		petStatList.setBounds(10, 27, 173, 228);
		petInfo.add(petStatList);
		
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