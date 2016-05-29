package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class Potion extends Food
{
    public Potion(String name, int happiness, int fatigability, int satiety, int price)
    {
        super.setName(name);
        super.setHappiness(happiness);
        super.setFatigablity(fatigability);
        super.setSatiety(satiety);
        super.setPrice(price);
    }

    public void transform(User user, int index)
    {

    }
}
