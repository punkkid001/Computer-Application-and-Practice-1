package View;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserSettingPage extends JPanel
{
	protected JTextField textField;
	private String userName;
	protected JButton okBtn;
	/**
	 * Create the panel.
	 */
	public UserSettingPage()
	{
		setBounds(100, 100, 900, 540);
		setLayout(null);
		
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
	
	private String getUserName()
	{
		return userName;
	}
}
