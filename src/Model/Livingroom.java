package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
import java.util.Scanner;

public class Livingroom extends Place
{
    Waste[] waste;
    public Livingroom()
    {
        waste=new Waste[5];
        super.setPlaceName("Livingroom");
    }

    //change
    public void showMenu(User user, int index)
    {
        Scanner input=new Scanner(System.in);
        int select=0;

        System.out.println("******Select Menu******");
        System.out.println("1. Talk / 2. Sleep / 3. Feed / 4. View food list / 5. Change Place");
        System.out.print(">> ");
        select=input.nextInt();

        if(select==1)
            user.getPet(index).talk();
        else if(select==2)
            user.getPet(index).sleep();
        else if(select==3)
            user.getPet(index).feed();
        else if(select==4)
            this.showFoodList(user);
        else if(select==5)
        {
            select=0;
            System.out.println("1. go Yard / 2. go Shop / 3. go Bathroom");
            System.out.print(">> ");
            select=input.nextInt();

            if(select==1)
            	System.out.println("test");
            else
                System.out.println("Wrong input!");
        }
        else if(select==9)
        {
            System.out.println("Program quit...");
            System.exit(0);
        }
        else
            System.out.println("Wrong input!");
    }

    public void showFoodList(User user)
    {
        Food[] foodList=user.getFoodList();
        int i=0;

        while(foodList[i]!=null)
        {
            System.out.println(foodList[i].getName());
            i++;
        }
    }
}
