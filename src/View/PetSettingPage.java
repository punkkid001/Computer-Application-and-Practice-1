package View;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PetSettingPage extends JPanel implements MouseListener, MouseMotionListener
{
	//setting image
	private BufferedImage penelImage = null;
	private BufferedImage babyCat = null;
	private BufferedImage catSmile = null;
	private BufferedImage babyMonkey = null;
	
	protected JButton cat = null;
	private JButton monkey = null;
	protected JTextField petNameField;
	protected JButton okBtn;
	private String petName;
	private int petNum;
	
	public PetSettingPage()
	{
		this.setBounds(100, 100, 980, 540);
		
		try
		{
			this.babyCat = ImageIO.read(new File("Img\\babycat.jpg"));
			this.catSmile = ImageIO.read(new File("Img\\babycat_smile.jpg"));
			this.babyMonkey = ImageIO.read(new File("Img\\babymonkey.jpg"));
			this.penelImage = ImageIO.read(new File("Img\\setting.jpg"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
		
		setLayout(null);
	
		this.cat = new JButton(new ImageIcon(this.babyCat));
		this.cat.setContentAreaFilled(false);
		this.cat.setBorder(BorderFactory.createEmptyBorder());
		this.cat.setBounds(300, 100, 89, 100);  //location, size
		this.cat.addMouseListener(this);
		
		this.monkey = new JButton(new ImageIcon(this.babyMonkey));
		this.monkey.setContentAreaFilled(false);
		this.monkey.setBorder(BorderFactory.createEmptyBorder());
		this.monkey.setBounds(500, 100, 68, 104);
		this.monkey.addMouseListener(this);
		
		this.add(this.cat);
		this.add(this.monkey);
		
		JLabel catLabel = new JLabel("Baby Cat");
		catLabel.setBounds(259, 263, 100, 18);
		add(catLabel);		
		
		JLabel catSteminaLabel = new JLabel("Stemina : ★★★");
		catSteminaLabel.setBounds(259, 293, 100, 18);
		add(catSteminaLabel);
		
		JLabel catPowerLabel = new JLabel("Power : ★☆☆");
		catPowerLabel.setBounds(259, 323, 100, 18);
		add(catPowerLabel);
		
		JLabel catDefenseLabel = new JLabel("Defense : ★★☆");
		catDefenseLabel.setBounds(259, 362, 100, 18);
		add(catDefenseLabel);
		
		JLabel monkeyLabel = new JLabel("Baby Monkey");
		monkeyLabel.setBounds(489, 263, 100, 18);
		add(monkeyLabel);
		
		JLabel monkeySteminaLabel = new JLabel("Stemina : ★★★");
		monkeySteminaLabel.setBounds(489, 293, 100, 18);
		add(monkeySteminaLabel);
		
		JLabel monkeyPowerLabel = new JLabel("Power : ★☆☆");
		monkeyPowerLabel.setBounds(489, 323, 100, 18);
		add(monkeyPowerLabel);
		
		JLabel monkeyDefenseLabel = new JLabel("Defense : ★★☆");
		monkeyDefenseLabel.setBounds(489, 362, 100, 18);
		add(monkeyDefenseLabel);
		
		JLabel petNameLabel = new JLabel("Pet Name");
		petNameLabel.setBounds(340, 414, 75, 26);
		add(petNameLabel);
		
		petNameField = new JTextField();
		petNameField.setBounds(416, 415, 116, 24);
		petNameField.setColumns(10);
		
		add(petNameField);
				
		okBtn = new JButton("OK");
		okBtn.setBounds(546, 414, 61, 27);
		
		
		add(okBtn);
		
		this.addMouseListener(this);
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetName() {
		return this.petName;
	}
	public void setPetNum(int petNum) {
		this.petNum = petNum;
	}
	public int getPetNum() {
		return this.petNum;
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(penelImage, 0, 0, null);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == this.cat)
		{	
			Icon monkeyIcon = new ImageIcon("Img\\babymonkey.jpg");
			this.monkey.setIcon(monkeyIcon);
			this.monkey.setBounds(500, 100, 68, 104);
			
			Icon catIcon = new ImageIcon("Img\\babycat_smile.jpg");
			this.cat.setIcon(catIcon);
			
			System.out.println("고양이가 눌렸습니다.");
			this.cat.setBounds(300, 50, 139, 150);
			this.setPetNum(1);  //1 : cat
		}
		
		if(e.getSource() == this.monkey)
		{
			Icon catIcon = new ImageIcon("Img\\babycat.jpg");
			this.cat.setIcon(catIcon);
			this.cat.setBounds(300, 100, 89, 100);
			
			Icon monkeyIcon = new ImageIcon("Img\\babymonkey_smile.jpg");
			this.monkey.setIcon(monkeyIcon);
			System.out.println("원숭이가 눌렸습니다.");
			this.monkey.setBounds(500, 50, 104, 159);
			this.setPetNum(2);	//2 : monkey
		}
		
		if(e.getSource() == this) {
			Icon monkeyIcon = new ImageIcon("Img\\babymonkey.jpg");
			this.monkey.setIcon(monkeyIcon);
			this.monkey.setBounds(500, 100, 68, 104);
			
			Icon catIcon = new ImageIcon("Img\\babycat.jpg");
			this.cat.setIcon(catIcon);
			this.cat.setBounds(300, 100, 89, 100);
			
			System.out.println("패널이 눌렸습니다.");
			this.setPetNum(0);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}