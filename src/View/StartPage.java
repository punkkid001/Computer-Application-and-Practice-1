package View;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPage extends JPanel implements ActionListener
{
	UserSettingPage usersettingPage;
	
	private BufferedImage panelImg = null;
	public JButton startBtn;
	public JButton loadBtn;
	public JButton exitBtn;
	
	/**
	 * Create the panel.
	 */
	public StartPage()
	{
		this.setBounds(100, 100, 900, 540);
		setLayout(null);
		
		try{
			this.panelImg = ImageIO.read(new File("Img\\place\\start.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
		
		startBtn = new JButton();
		//startBtn.addActionListener(this);
		startBtn.setBounds(690, 155, 150, 70);
		//버튼 투명화
		startBtn.setContentAreaFilled(false);
		startBtn.setBorderPainted(false);
		startBtn.setFocusPainted(false);
		add(startBtn);
		
		loadBtn = new JButton();
		loadBtn.setBounds(690, 250, 130, 50);
		//버튼 투명화
		loadBtn.setContentAreaFilled(false);
		loadBtn.setBorderPainted(false);
		loadBtn.setFocusPainted(false);
		add(loadBtn);
		
		exitBtn = new JButton();
		exitBtn.setBounds(690, 330, 110, 60);
		//버튼 투명화
		exitBtn.setContentAreaFilled(false);
		exitBtn.setBorderPainted(false);
		exitBtn.setFocusPainted(false);
		add(exitBtn);
		
		//setLayout(new GridLayout(1, 0, 0, 0));
		
		/*
		try
		{
			//panelImage=ImageIO.read(new File("imge.png"));
		}
		catch(IOException e)
		{
			
		}
		*/
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(panelImg,0,0,null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}