package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JButton;

public class MainFrame extends JFrame
{
	private Controller c;
	private JPanel presentPanel;
	
	//setting views
	//private StartPage startPage;
	//private UserSettingPage usersettingPage;
	//private PetSettingPage petsettingPage;
	public Place place;
	public LivingroomPage livingroomPage;
	public ShopPage shopPage;
	public YardPage yardPage;
	public BathroomPage bathroomPage;	
	public BattlePage battlePage;	
	private String userName;
	
	private boolean bathroomClosetFlag=false;
	private boolean bathroomStatFlag=false;
	private boolean livingroomFridgeFlag=false;
	/**
	 * Create the frame.
	 */
	public MainFrame()
	{
		
	}
	
	public MainFrame(Controller c)
	{
		this.c = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 587);
		
		/*
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane = new StartPage();
		setContentPane(contentPane);
		this.add(contentPane);*/
		
		//contentPane.add(startPage);
		
		//usersettingPage=new UserSettingPage();
		//contentPane.add(usersettingPage);
		
		//livingroomPage=new LivingroomPage();
		//contentPane.add(livingroomPage);
		
		//battlePage=new BattlePage();
		//contentPane.add(battlePage);
		
		//setCharacterPage=new SetCharecterPage();
		//contentPane.add(setCharacterPage);
		
		//yardPage=new YardPage();
		//contentPane.add(yardPage);
		
		//shopPage=new ShopPage();
		//contentPane.add(shopPage);
		
		//bathroomPage=new BathroomPage();
		//contentPane.add(bathroomPage);
		//System.out.println("hello?");
	}

	public void gotoStartPage()
	{
		StartPage startPage=new StartPage();
		
		startPage.startBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Start 버튼이 눌렸습니다.");
				c.goUserSetting();
			}
		});
		
		startPage.exitBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("exit 버튼이 눌렸습니다.");
				c.gameExit();
			}
		});	
		
		this.setContentPane(startPage);
		this.setVisible(true);
	}
	
	public void gotoUserSettingPage()
	{
		UserSettingPage usersettingPage = new UserSettingPage(); 
		
		usersettingPage.okBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				userName = usersettingPage.textField.getText();
				if(userName.isEmpty() == true)
				{
					JOptionPane.showMessageDialog(null, "Please input username", "Warning", JOptionPane.WARNING_MESSAGE);
					System.out.println("유저이름을 입력하세요");
					return;
				}
				
				else
					c.goPetSetting(userName);
			}			
		});
		
		this.setContentPane(usersettingPage);
		this.setVisible(true);
	}
	
	public void gotoPetSettingPage()
	{
		// TODO Auto-generated method stub
		PetSettingPage petsettingPage = new PetSettingPage();
		
		petsettingPage.okBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String petName = petsettingPage.petNameField.getText();
				if(petName.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please input pet name", "Warning", JOptionPane.WARNING_MESSAGE);
					System.out.println("petName이 설정되지 않았습니다.");
					return;
				}
				else if(petsettingPage.getPetNum() == 0)
				{
					JOptionPane.showMessageDialog(null, "Please select pet", "Warning", JOptionPane.WARNING_MESSAGE);
					System.out.println("pet이 선택되지 않았습니다.");
					return;
				}
				else
				{ 
					petsettingPage.setPetName(petName);
					c.goStartingPoint(petsettingPage.getPetNum(), petsettingPage.getName());
					//calling game start method
				}
			}
		});
		
		this.setContentPane(petsettingPage);
		this.setVisible(true);
	}
	
	public void gotogameStartingPoint()
	{

		this.livingroomPage = new LivingroomPage(c);
		this.livingroomPage.btnGoBathroom.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoBathroom();
			}
		});
		
		this.livingroomPage.btnGoShop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoShop();
			}
		});
		
		this.livingroomPage.btnGoYard.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoYard();
			}
		});
		
		this.livingroomPage.fridgeBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String[] list=c.appendFoodItemList();
				if(livingroomFridgeFlag==false)
				{
					livingroomFridgeFlag=true;
					if(list!=null)
					{
						for(int i=0;i<list.length;i++)
						{
							livingroomPage.food[i].setText(list[i]);
							livingroomPage.food[i].setVisible(true);
						}
						livingroomPage.labelEmpty.setVisible(false);
					}
					else
						livingroomPage.labelEmpty.setVisible(true);
					livingroomPage.foodItemInfo.setVisible(true);
				}
				else
				{
					livingroomFridgeFlag=false;
					livingroomPage.foodItemInfo.setVisible(false);
				}
			}
		});
		
		this.bathroomPage = new BathroomPage(c);
		this.bathroomPage.btnGoLivingroom.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoLivingroom();
			}
		});
		
		this.bathroomPage.btnGoShop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoShop();
			}
		});
		
		this.bathroomPage.btnGoYard.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoYard();
			}
		});
		
		this.bathroomPage.closetBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(bathroomClosetFlag==false)
				{
					if(bathroomClosetFlag==false)
					{
						bathroomClosetFlag=true;
						String list[]=c.appendClosetItemList();
						if(list!=null)
						{
							for(int i=0;i<list.length;i++)
							{
								bathroomPage.cloth[i].setText(list[i]);
								bathroomPage.cloth[i].setVisible(true);
							}
						}
						else
							bathroomPage.emptyLabel.setVisible(true);
					}				
						
					bathroomPage.UsersClothItem.setVisible(true);
					bathroomPage.clothItemInfo.setVisible(true);
				}
				else
				{
					bathroomClosetFlag=false;
					bathroomPage.UsersClothItem.setVisible(false);
					bathroomPage.clothItemInfo.setVisible(false);
				}
			}
		});
		
		this.shopPage = new ShopPage();
		this.shopPage.btnGoLivingroom.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoLivingroom();
			}
		});
		
		this.shopPage.btnGoBathroom.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoBathroom();
			}
		});
		
		this.shopPage.btnGoYard.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoYard();
			}
		});
		
		shopPage.btnCloth[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c.getPresentUser().buyItem(shopPage.clothList[0]);
			}
		});
		
		shopPage.btnCloth[1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c.getPresentUser().buyItem(shopPage.clothList[1]);
			}
		});
		
		shopPage.btnCloth[2].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c.getPresentUser().buyItem(shopPage.clothList[2]);
			}
		});
		
		shopPage.btnFood[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c.getPresentUser().buyItem(shopPage.foodList[0]);
			}
		});
		
		shopPage.btnFood[1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c.getPresentUser().buyItem(shopPage.foodList[1]);
			}
		});
		
		shopPage.btnFood[2].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c.getPresentUser().buyItem(shopPage.foodList[2]);
			}
		});
		
		shopPage.btnPet[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c.getPresentUser().buyItem(shopPage.animalList[0]);
			}
		});
		
		shopPage.btnPet[1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c.getPresentUser().buyItem(shopPage.animalList[1]);
			}
		});
		
		shopPage.btnPotion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				/*
				if(shopPage.textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please input pet name", "Warning", JOptionPane.WARNING_MESSAGE);
					System.out.println("petName이 설정되지 않았습니다.");
					return;
				}
				else
				*/
					c.getPresentUser().buyItem(shopPage.potion);
			}
		});
		
		this.yardPage = new YardPage(c);
		this.yardPage.btnGoLivingroom.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoLivingroom();
			}	
		});
		
		this.yardPage.btnGoBathroom.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoBathroom();
			}
		});
		
		this.yardPage.btnGoShop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				gotoShop();
			}
		});
		this.setContentPane(livingroomPage);
		this.setVisible(true);	
	}
	
	public void gotoLivingroom()
	{
		c.viewLivingroomStatus();
		this.setContentPane(livingroomPage);
		this.setVisible(true);
	}
	public void gotoBathroom()
	{
		c.viewBathroomStatus();
		this.setContentPane(bathroomPage);
		this.setVisible(true);
	}
	public void gotoYard()
	{
		c.viewYardStatus();
		this.setContentPane(yardPage);
		this.setVisible(true);
	}
	public void gotoShop()
	{
		c.viewShopStatus();
		this.setContentPane(shopPage);
		this.setVisible(true);
	}
	
	public void showAnimalStat(String []list)
	{
		if(bathroomStatFlag==false)
		{
			bathroomStatFlag=true;
			bathroomPage.statArea.setText("");
			for(int i=0;i<list.length;i++)
				bathroomPage.statArea.append(list[i]+"\n");
			
			bathroomPage.statArea.setVisible(true);
			bathroomPage.petStat.setVisible(true);
			bathroomPage.petInfo.setVisible(true);
		}
		else
		{
			bathroomStatFlag=false;
			bathroomPage.statArea.setVisible(false);
			bathroomPage.petStat.setVisible(false);
			bathroomPage.petInfo.setVisible(false);
		}
	}
	
	/*
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==startPage.startBtn)
		{
			usersettingPage=new UserSettingPage(); 
			contentPane.removeAll();
			contentPane.add(usersettingPage);
			setVisible(true);
			usersettingPage.setVisible(true);
		}
	}*/
}