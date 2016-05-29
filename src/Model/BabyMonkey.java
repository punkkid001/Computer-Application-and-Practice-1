package Model;/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class BabyMonkey extends Animal
{
    public BabyMonkey(){}

    public BabyMonkey(String name)
    {
        super.setName(name);

        setSpeechList(" ", 8);
        setSpeechList(" ", 9);
        setSpeechList(" ", 10);
        setSpeechList(" ", 11);
        setSpeechList(" ", 12);
        setSpeechList(" ", 13);
        setSpeechList(" ", 14);
    }

    //change
    public void levelUp(User presentUser, int index)
    {
        super.levelUp();
        super.setPower(super.getPower()+20);
        super.setStemina(super.getStemina()+20);
        super.setDefense(super.getDefense()+15);

        if(super.getLevel()==2)
            this.grow(presentUser, index);
    }

    public void grow(User presentUser, int index)
    {
        presentUser.setAnimal(index, new AdultMonkey(this));
    }
}
