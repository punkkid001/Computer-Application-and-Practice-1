package View;

import javax.swing.JPanel;

import Model.Animal;
import Model.User;
import Model.Waste;

public class Place extends JPanel{
	String placeName;
	Waste[] waste;
	
    public void showMenu() {}

    //change
    public void goLivingroom(Animal p){p.goLivingroom();}
    public void goYard(Animal p){p.goYard();}
    public void goShop(Animal p){p.goShop();}
    public void goBathroom(Animal p){p.goBathroom();}

    public void setPlaceName(String name){this.placeName=name;}
    public String getName(){return this.placeName;}

    public void showUserInfo(User user)
    {
        System.out.println("----User info----");
        System.out.println("User name : "+user.getUsername());
        System.out.println("User gold : "+user.getGold());
        System.out.println("User's pet : "+user.getUserPetSize());
    }

}
