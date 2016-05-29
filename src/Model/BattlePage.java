package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
import java.util.Scanner;

public class BattlePage
{
    Animal myAnimal;
    Animal enemy;

    Skill_IF skill;

    int firstTurn;
    int winner;
    int commend;

    public BattlePage(User user, int index)
    {
        myAnimal=user.getPet(index);
        enemy=new AdultMonkey("Enemy");

        firstTurn=0;
        winner=-1;
        commend=0;
    }

    public void showMenu()
    {
        commend=0;
        System.out.println("****Commend");
        System.out.println("1. Attack / 2. Defense / 3. Use Skill / 4. Runaway");
        System.out.print(">> ");
        this.commend();
    }

    public void commend()
    {
        commend=0;
        Scanner input=new Scanner(System.in);
        commend=input.nextInt();

        if(commend==1)
        {
            commend=0;
            System.out.println("1. Snap / 2. Tackle");
            System.out.print(">> ");
            commend=input.nextInt();

            if(commend==1)
                myAnimal.snap(enemy);
            else if(commend==2)
                myAnimal.tackle(enemy);
            else
                System.out.println("Wrong input!");
        }

        else if(commend==2)
            myAnimal.defence(0);

        else if(commend==3)
        {
            System.out.println("Undeveloped..");
        }

        else if(commend==4)
            myAnimal.escape();

        else
            System.out.println("Wrong input!");

    }

    public void printResult(int num, int commend)
    {

    }
}
