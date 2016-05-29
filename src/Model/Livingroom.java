package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
import java.util.Scanner;

public class Livingroom extends Place
{
    Waste[] waste;
    public Livingroom()
    {
        waste=new Waste[5];
        super.setPlaceName("Livingroom");
    }
}
