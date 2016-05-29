package Model;/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class AdultMonkey extends BabyMonkey implements Sit_IF
{
    public AdultMonkey(){}
    public AdultMonkey(String name){this.setName(name);}
    public AdultMonkey(Animal p)
    {
        this.setName(p.getName());
        this.setStemina(p.getStemina());
        this.setDefense(p.getDefense());
        this.setPower(p.getPower());
        this.setLevel(p.getLevel());
    }

    //change
    public void levelUp()
    {
        if(this.getExp()>=100)
        {
            this.setLevel(this.getLevel()+1);
            this.setExp(0);

            this.setStemina(this.getStemina()+40);
            this.setPower(this.getPower()+40);
            this.setDefense(this.getDefense()+30);
        }
    }

    public void sit()
    {
        System.out.println("I'm Sit..");
    }

    public String getName(){return actName;}

    public void transform()
    {
        Gorilla gorilla=new Gorilla();
    }
}
