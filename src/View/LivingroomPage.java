package View;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextArea;

public class LivingroomPage extends JPanel
{
	protected JButton btnGoShop;
	protected JButton btnGoBathroom;
	protected JButton btnGoYard;
	protected JButton petBtn[];
	protected JButton freezerBtn;
	
	protected JPanel foodItemInfo;
	protected JLabel UsersFoodItem;
	protected JTextArea foodItemList;
	
	public JLabel simpleUserInfo;
	
	/**
	 * Create the panel.
	 */
	public LivingroomPage()
	{
		petBtn = new JButton[5];
		for(int i = 0; i < petBtn.length; i++)
			petBtn[i] = null;
			
		setBounds(100, 100, 900, 540);
		setLayout(null);
		
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
		
		JButton bedBtn = new JButton("Bed");
		bedBtn.setBounds(193, 140, 100, 100);
		add(bedBtn);
		
		JLabel foodBtn = new JLabel("Food");
		foodBtn.setBounds(73, 290, 100, 100);
		add(foodBtn);
		
		freezerBtn = new JButton("Freezer");
		freezerBtn.setBounds(500, 140, 100, 100);
		add(freezerBtn);
		/*
		JButton petBtn = new JButton("Pet");
		petBtn.setBounds(336, 342, 100, 100);
		add(petBtn);
		*/
		//연결
		foodItemInfo = new JPanel();
		foodItemInfo.setBounds(621, 140, 229, 149);
		add(foodItemInfo);
		foodItemInfo.setLayout(null);
		
		//연결
		UsersFoodItem = new JLabel("user's food item");
		UsersFoodItem.setBounds(0, 0, 92, 15);
		foodItemInfo.add(UsersFoodItem);
		
		foodItemList = new JTextArea();
		foodItemList.setBounds(10, 25, 207, 114);
		foodItemInfo.add(foodItemList);
		
		foodItemInfo.setVisible(false);
		
		//연결3
		JPanel petClick = new JPanel();
		petClick.setBounds(479, 333, 153, 119);
		add(petClick);
		
		//연결3
		JButton changePetPlaceBtn = new JButton("Change pet place");
		petClick.add(changePetPlaceBtn);
		
		JLabel label = new JLabel("");
		petClick.add(label);
		
		//연결3
		JButton talkBtn = new JButton("Talk");
		petClick.add(talkBtn);
		
		//연결3
		JButton sleepBtn = new JButton("Sleep");
		petClick.add(sleepBtn);
		
		//연결3
		JButton feedBtn = new JButton("Feed");
		petClick.add(feedBtn);
		
		JLabel label_1 = new JLabel("");
		petClick.add(label_1);
		
		petClick.setVisible(false);		
	}
	
	public void createPetIcon(String petName)
	{
		for(int i = 0; i < petBtn.length; i++)
		{
			if(petBtn[i] == null)
			{
				petBtn[i] = new JButton(petName);
				petBtn[i].setBounds(336, 342, 100, 100);
				this.add(petBtn[i]);
				this.setVisible(true);
				break;
			}
			
			if(i == petBtn.length - 1)
				System.out.println("팻을 더 추가할 수 없습니다.");
		}
	}
}
