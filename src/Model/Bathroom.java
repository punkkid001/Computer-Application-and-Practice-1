package Model;
import java.util.Scanner;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class Bathroom extends Place
{
    Waste[] waste;
    public Bathroom()
    {
        waste=new Waste[5];
        super.setPlaceName("Bathroom");
    }
    
    //new
    public void choicePet(User user)
    {
        if(user.getUserPetSize()>1)
        {
            int i=0;

            while(user.getPet(i)!=null)
            {
                System.out.print((i+1)+". "+user.getPet(i).getName()+" ");
                i++;
            }
            System.out.println();
        }

        else
            System.out.println("1. "+user.getPet(0).getName());
    }
}
