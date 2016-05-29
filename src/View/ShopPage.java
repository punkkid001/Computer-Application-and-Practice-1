package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopPage extends JPanel
{
	protected JButton btnGoYard;
	protected JButton btnGoBathroom;
	protected JButton btnGoLivingroom;
	
	protected JButton btnPreminumFood;
	protected JButton btnCake;
	protected JButton btnParpait;
	protected JButton btnHat;
	protected JButton btnShoes;
	protected JButton btnRibbon;
	
	public JLabel simpleUserInfo;
	private JTextArea sellItemList;
	/**
	 * Create the panel.
	 */
	public ShopPage()
	{
		setBounds(100, 100, 900, 540);
		setLayout(null);
		
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
		simpleUserInfo.setBounds(621, 60, 247, 43);
		add(simpleUserInfo);
		
		JPanel buyPanel = new JPanel();
		buyPanel.setBounds(54, 177, 246, 341);
		buyPanel.setLayout(null);
		add(buyPanel);
		
		JLabel buyLabel = new JLabel("Buy");
		buyLabel.setBounds(110, 0, 57, 15);
		buyPanel.add(buyLabel);
		
		btnPreminumFood = new JButton("Preminum Food");
		btnPreminumFood.setBounds(63, 36, 123, 23);
		buyPanel.add(btnPreminumFood);
		
		btnCake = new JButton("Cake");
		btnCake.setBounds(63, 69, 123, 23);
		buyPanel.add(btnCake);
		
		btnParpait = new JButton("Parpait");
		btnParpait.setBounds(63, 102, 123, 23);
		buyPanel.add(btnParpait);
		
		btnHat = new JButton("Hat");
		btnHat.setBounds(63, 147, 123, 23);
		buyPanel.add(btnHat);
		
		btnShoes = new JButton("Shoes");
		btnShoes.setBounds(63, 180, 123, 23);
		buyPanel.add(btnShoes);
		
		btnRibbon = new JButton("Ribbon");
		btnRibbon.setBounds(63, 213, 123, 23);
		buyPanel.add(btnRibbon);
		
		JButton btnBabyCat = new JButton("Baby Cat");
		btnBabyCat.setBounds(63, 263, 123, 23);
		buyPanel.add(btnBabyCat);
		
		JButton btnBabyMonkey = new JButton("Baby Monkey");
		btnBabyMonkey.setBounds(63, 296, 123, 23);
		buyPanel.add(btnBabyMonkey);
		
		JPanel sellPanel = new JPanel();
		sellPanel.setBounds(600, 177, 246, 341);
		sellPanel.setLayout(null);
		add(sellPanel);
		
		JLabel sellLabel = new JLabel("Sell");
		sellLabel.setBounds(111, 0, 57, 15);
		sellPanel.add(sellLabel);
		
		sellItemList = new JTextArea();
		sellItemList.setBounds(12, 22, 222, 309);
		sellPanel.add(sellItemList);
	}
}