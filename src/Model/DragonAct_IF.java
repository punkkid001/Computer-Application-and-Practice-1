package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public interface DragonAct_IF extends GetName_IF, Mess_IF, Hide_IF, Sit_IF, Dance_IF
{
    String actName="Bless";
    String actName1 = "Sit";
    String actName2 = "Mess";
    String actName3 = "Hide";
    String actName4 = "Dance";

    public String shout();
    public String mess();
    public String hide();
    public String sit();
    public String dance();
}
