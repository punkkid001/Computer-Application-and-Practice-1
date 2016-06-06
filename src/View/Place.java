package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controller.Controller;
import Model.Animal;
import Model.User;
import Model.Waste;

public abstract class Place extends JPanel
{
	String placeName;
	Waste[] waste;
	protected Controller c;
	private PetLabel[] petIcon;
	
	public Place() {
		petIcon = new PetLabel[5];
		for (int i = 0; i < petIcon.length; i++)
			petIcon[i] = null;
	}
	public Place(Controller c)
	{
		this();
		this.c =c;
	}
    public void showMenu() {}
/*
    //change/*
    public void goLivingroom(Animal p){p.goLivingroom();}
    public void goYard(Animal p){p.goYard();}
    public void goShop(Animal p){p.goShop();}
    public void goBathroom(Animal p){p.goBathroom();}
*/
    public void setPlaceName(String name){this.placeName=name;}
    public String getName(){return this.placeName;}

    public void showUserInfo(User user)
    {
        System.out.println("----User info----");
        System.out.println("User name : "+user.getUsername());
        System.out.println("User gold : "+user.getGold());
        System.out.println("User's pet : "+user.getUserPetSize());
    }
    public void createPetIcon(Animal pet) {
		for (int i = 0; i < petIcon.length; i++) {
			if (petIcon[i] == null) {
				petIcon[i] = new PetLabel(pet, this, c.getPresentUser());
				
				petIcon[i].setIcon(pet.getMyImageIcon());
				petIcon[i].setBounds(pet.getX(), pet.getY(), 150, 150);
				//petIcon[i].addMouseListener(this);
				
				petIcon[i].behaviorItem7.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						String[] list=pet.getPetStatList();
						c.m.showAnimalStat(list);
					}
				});
				
				this.add(petIcon[i]);
				petIcon[i].setVisible(true);
				
				break;
			}

			if (i == petIcon.length - 1)
				System.out.println("팻을 더 추가할 수 없습니다.");
		}
	}
	
	public void deleteIcon(Animal pet)
	{
		for(int i = 0; i < petIcon.length; i++)
		{
			if(petIcon[i] != null) {
				if(petIcon[i].pet == pet)
				{
					System.out.println(i + "??");
					petIcon[i].setVisible(false);
					petIcon[i] = null;
				}
			}
		}
	}
}
