package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
import java.util.Scanner;

public class Shop extends Place
{
    Food[] foodList;
    Cloth[] clothList;
    Pet[] animalList;
    Waste[] waste;

    public Shop()
    {
        super.setPlaceName("Shop");
        waste=new Waste[5];
        
        //foodList=new Food[3];
        foodList[0]=new Food("Premium", 5, 5, 5, 50);
        foodList[1]=new Food("Cake", 10, 5, 10, 200);
        foodList[2]=new Food("Parfait", 10, 5, 0, 80);
        
        clothList[0]=new Cloth("Hat", 5, 10, 50, 100);
        clothList[1]=new Cloth("Shoes", 15, 5, 50, 100);
        clothList[2]=new Cloth("Ribbon", 10, 10, 30, 50);

        //animalList=new Pet[2];
        animalList[0]=new Pet("Baby Cat", 1000);
        animalList[1]=new Pet("Baby Monkey", 1000);
    }
}
