package Model;

import java.util.Scanner;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class Yard extends Place
{
    Waste[] waste;
    public Yard()
    {
        waste=new Waste[5];
        super.setPlaceName("Yard");
    }
}
