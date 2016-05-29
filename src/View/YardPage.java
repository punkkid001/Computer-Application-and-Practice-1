package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YardPage extends JPanel
{
	protected JButton btnGoShop;	
	protected JButton btnGoBathroom;
	protected JButton btnGoLivingroom;
	
	public JLabel simpleUserInfo;
	/**
	 * Create the panel.
	 */
	public YardPage()
	{
		setBounds(100, 100, 900, 540);
		setLayout(null);
		
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
		
		JButton playBtn = new JButton("Toy");
		playBtn.setBounds(131, 177, 100, 100);
		add(playBtn);
		
		JButton fightBtn = new JButton("Fight");
		fightBtn.setBounds(621, 417, 100, 100);
		add(fightBtn);
		
		JButton petBtn = new JButton("Pet");
		petBtn.setBounds(336, 342, 100, 100);
		add(petBtn);
	}
}