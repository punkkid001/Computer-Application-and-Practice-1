package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class Cloth
{
    private String name;
    private int power;
    private int defense;
    private int stemina;
    private int price;

    public Cloth(String name, int power, int defense, int stemina, int price)
    {
        this.name=name;
        this.power=power;
        this.defense=defense;
        this.stemina=stemina;
        this.price=price;
    }

    public String getName(){return this.name;}
    public int getPower(){return this.power;}
    public int getDefense(){return this.defense;}
    public int getStemina(){return this.stemina;}
    public int getPrice(){return this.price;}

    public void showDetail()
    {
        System.out.println("Name : "+getName());
        System.out.println("Power : "+getPower());
        System.out.println("Defense : "+getDefense());
        System.out.println("Stemina : "+getStemina());
        System.out.println("Price : "+getPrice());
    }
}
