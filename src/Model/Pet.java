package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class Pet
{
    String name;
    int price;

    public Pet(String name, int price)
    {
        this.name=name;
        this.price=price;
    }

    public String getName(){return this.name;}
    public int getPrice(){return this.price;}

    public void showDetail()
    {
        System.out.println("Name : "+getName());
        System.out.println("Price : "+getPrice());
    }
}
