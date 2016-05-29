package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public interface Fight_IF
{
    public int snap(Animal target);
    public int tackle(Animal target);
    public void defence(int damage);
    public boolean escape();    //true -> escape : game exit
}
