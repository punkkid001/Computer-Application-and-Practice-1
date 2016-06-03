package View;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class UserSettingPage extends JPanel
{
	private BufferedImage panelImg = null;
	protected JTextField textField;
	private String userName;
	protected JButton okBtn;
	/**
	 * Create the panel.
	 */
	public UserSettingPage()
	{
		this.setBounds(100, 100, 900, 540);
		setLayout(null);
		
		try{
			this.panelImg = ImageIO.read(new File("Img\\place\\select.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
		
		JLabel nameField = new JLabel("당신의 이름은 무엇입니까?");
		nameField.setBounds(140, 200, 200, 80);
		add(nameField);
		
		
		textField = new JTextField();
		textField.setBounds(170, 254, 375, 77);
		add(textField);
		textField.setColumns(10);
		
		okBtn = new JButton("OK");
		/*
		okBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				userName = textField.getText();
				System.out.println(userName + "입력");
				
				//글자 수 제한하고 경고메시지.
			}
		});*/
		okBtn.setBounds(570, 254, 97, 77);
		add(okBtn);
		
		setVisible(true);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(panelImg, 0, 0, null);
	}
	
	private String getUserName()
	{
		return userName;
	}
}
