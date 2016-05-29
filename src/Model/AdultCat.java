package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class AdultCat extends BabyCat implements Dance_IF
{
    public AdultCat(){}
    public AdultCat(Animal p)
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

            this.setStemina(this.getStemina()+60);
            this.setPower(this.getPower()+20);
            this.setDefense(this.getDefense()+30);
        }
    }

    public void dance()
    {
        System.out.println("Dance..");
    }

    public String getName(){return actName;}

    public void transform()
    {
        Tiger tiger=new Tiger();
    }
}
