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

public abstract class Place extends JPanel
{
	String placeName;
	Waste[] waste;
	protected Controller c;
	private PetLabel[] petIcon;
	//private Drappings[] drapIcon;
	
	public Place() {
		petIcon = new PetLabel[5];
		waste = new Waste[5];
		//drapIcon = new Drappings[5];
		for (int i = 0; i < petIcon.length; i++) {
			petIcon[i] = null;
			waste[i] = null;
		}
		/*
		for (int i = 0; i < drapIcon.length; i++) {
			drapIcon[i] = null;
		}*/
	
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
				System.out.println(pet.getClass());
				//똥부분
				int drapNum = petIcon[i].pet.getDrappings();
				for(int j = 0; j < drapNum ; j++) {
					petIcon[i].makeDrapping();
				}
				//똥부분 끝
				pet.setLabel(petIcon[i]);
				petIcon[i].setIcon(pet.getMyImageIcon());
				petIcon[i].setBounds(pet.getX(), pet.getY(), 150, 150);
				//petIcon[i].addMouseListener(this);
				System.out.println(petIcon[i].getClass());
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
					petIcon[i].removeDrappingFromMap();
					petIcon[i].setVisible(false);
					petIcon[i] = null;
				}
			}
		}
	}
	//쓰레기 관련 메소드
	public void makeWaste() {
		for(int i = 0; i < waste.length; i++) {
			if(waste[i] == null) {
				waste[i] = new Waste(this);
				this.add(waste[i]);				
				break;
			}
		}
		this.repaint();
	}
	public void removeWaste(Waste w) {
		for(int i = 0; i < waste.length; i++) {
			if(w == this.waste[i]) {
				waste[i] = null;
				break;
			}			
		}
		this.repaint();
	}
}
