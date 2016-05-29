package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public interface DragonAct_IF extends GetName_IF, Mess_IF, Hide_IF, Sit_IF, Dance_IF
{
    String actName="DragonAct";

    public void shout();
}
