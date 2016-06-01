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
			this.panelImg = ImageIO.read(new File("Img\\place\\gamestart.png"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
		
		startBtn = new JButton("Start");
		//startBtn.addActionListener(this);
		startBtn.setBounds(373, 276, 97, 23);
		add(startBtn);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(373, 319, 97, 23);
		add(loadBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(373, 368, 97, 23);
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