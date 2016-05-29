package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


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
		
		move_panel = new JPanel();
		move_button = new JButton("이동하기");
		move_panel.add(move_button);
		move_panel.setBounds(50, 50, 50, 50);
		add(move_panel);
		move_button.addActionListener(this);
		
		/*
		move_panel2 = new JPanel();
		move_button2 = new JButton("null");
		move_panel2.add(move_button2);
		move_panel2.setBounds(50, 100, 50, 50);
		add(move_panel2);
		move_button2.addActionListener(this);
		
		move_panel3 = new JPanel();
		move_button3 = new JButton("null");
		move_panel3.add(move_button3);
		move_panel3.setBounds(50, 150, 50, 50);
		add(move_panel3);
		move_button2.addActionListener(this);
		
		move_panel4 = new JPanel();
		move_button4 = new JButton("null");
		move_panel4.add(move_button4);
		move_panel4.setBounds(50, 200, 50, 50);
		add(move_panel4);
		move_button4.addActionListener(this);
		*/
		setVisible(true);
		
	}
		


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (("move_button".equals(e.getActionCommand()))==false)
		{
			move_button.setVisible(false);
			/*
			move_button2.setVisible(false);
			move_button3.setVisible(false);
			move_button4.setVisible(false);
			*/
			
			Act_table i =new Act_table();
			add(i);
			this.setVisible(true);
			/*
			i.panel1.setVisible(true);
			add(i.panel2);
			i.panel2.setVisible(true);
			add(i.panel3);
			i.panel3.setVisible(true);
			add(i.panel4);
			i.panel4.setVisible(true);
			*/
		}

	}
		  public static void main(String args[])  {
			    new test();
			  }
		
	
}
