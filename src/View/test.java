package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class test extends JFrame implements ActionListener {

	//private JPanel mainpanel;
	private JPanel move_panel;
	private JButton move_button;
	private JPanel move_panel2;
	private JButton move_button2;
	private JPanel move_panel3;
	private JButton move_button3;
	private JPanel move_panel4;
	private JButton move_button4;
	
	public test(){
		
		
		//test
		setTitle("이동하기");
		setSize(900,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//test
		this.setBounds(100, 100, 300, 350);
		move_panel = new JPanel();
		move_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		move_button = new JButton("이동하기");
		move_panel.add(move_button);
		move_panel.setBounds(50, 50, 50, 50);
		getContentPane().add(move_panel);
		move_button.addActionListener(this);
		
		setVisible(true);
		
	}
		


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.move_button)
		{
			move_button.setVisible(false);
			
			Act_table i =new Act_table(30, 40);
			this.add(i);
			//getContentPane().add(i);
			this.setVisible(true);
			
		}

	}
		  public static void main(String args[])  {
			    new test();
			  }
		
	
}
