package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class Food
{
    private String name;
    private int happiness;
    private int fatigability;
    private int satiety;
    private int price;

    public Food(){}
    public Food(String name, int happiness, int fatigability, int satiety, int price)
    {
        this.name=name;
        this.happiness=happiness;
        this.fatigability=fatigability;
        this.satiety=satiety;
        this.price=price;
    }

    public String getName(){return this.name;}
    public int getHappiness(){return this.happiness;}
    public int getFatigability(){return this.fatigability;}
    public int getSatiety(){return this.satiety;}
    public int getPrice(){return this.price;}

    public void setName(String name){this.name=name;}
    public void setHappiness(int happy){this.happiness=happy;}
    public void setFatigability(int fatigability){this.fatigability=fatigability;}
    public void setSatiety(int satiety){this.satiety=satiety;}
    public void setPrice(int price){this.price=price;}
}
