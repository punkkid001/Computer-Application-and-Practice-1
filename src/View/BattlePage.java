package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import net.miginfocom.swing.MigLayout;

public class BattlePage extends JPanel implements ActionListener
{
	private BufferedImage penelImage = null;
	private BufferedImage babyCat = null;
	private BufferedImage catSmile = null;
	private BufferedImage babyMonkey = null;
	
	protected JButton cat = null;
	private JButton monkey = null;
	
	private JTextField text_PetName;
	private JTextField textField;
	
	public JButton attackBtn;
	public JButton skillBtn;
	public JButton tackleBtn;
	public JButton defenseBtn;
	public JButton escapeBtn;
	public JButton snapBtn;
	public JButton petSkillBtn;
	
	/**
	 * Create the panel.
	 */
	public BattlePage()
	{
		this.setBounds(100, 100, 980, 540);
		
		try
		{
			this.babyCat = ImageIO.read(new File("Img\\cat_normal.jpg"));
			this.babyMonkey = ImageIO.read(new File("Img\\monkey_normal.jpg"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
		}
		
		setLayout(null);
		
		this.cat = new JButton(new ImageIcon(this.babyCat));
		this.cat.setContentAreaFilled(false);
		this.cat.setBorder(BorderFactory.createEmptyBorder());
		this.cat.setBounds(100, 216, 89, 100);  //location, size
		
		
		this.monkey = new JButton(new ImageIcon(this.babyMonkey));
		this.monkey.setContentAreaFilled(false);
		this.monkey.setBorder(BorderFactory.createEmptyBorder());
		this.monkey.setBounds(670, 60, 68, 104);
				
		this.add(this.cat);
		this.add(this.monkey);
		
		JPanel panel = new JPanel();
		panel.setBounds(72, 367, 288, 133);
		add(panel);
		panel.setLayout(new GridLayout(4, 2, 15, 1));
		
		attackBtn = new JButton("Attack");
		attackBtn.addActionListener(this);
		panel.add(attackBtn);
		
		snapBtn = new JButton("Snap");
		panel.add(snapBtn);
		snapBtn.setVisible(false);
		
		defenseBtn = new JButton("Defense");
		panel.add(defenseBtn);
		
		tackleBtn = new JButton("Tackle");
		panel.add(tackleBtn);
		tackleBtn.setVisible(false);
		
		skillBtn = new JButton("Use Skill");
		panel.add(skillBtn);
		
		petSkillBtn = new JButton("PetSkill");	//need to getName from model
		panel.add(petSkillBtn);
		petSkillBtn.setVisible(false);
		
		escapeBtn = new JButton("Escape");
		panel.add(escapeBtn);
		
		JLabel label = new JLabel();
		label.setBounds(62, 367, 663, 133);
		add(label);
		
		JLabel lbl_status1 = new JLabel("My pet Status");
		lbl_status1.setBounds(100, 107, 111, 97);
		add(lbl_status1);
		
		JLabel lbl_status2 = new JLabel("Enemy Status");
		lbl_status2.setBounds(628, 186, 139, 112);
		add(lbl_status2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource() == attackBtn)
		{
			System.out.println("공격 버튼이 눌렸다");
			this.snapBtn.setVisible(true);
			this.tackleBtn.setVisible(true);
		}
	}
}