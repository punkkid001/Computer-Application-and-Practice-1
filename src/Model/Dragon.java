package Model;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class Dragon extends Animal implements DragonAct_IF
{
	public Dragon() {
		
	}
    public void sit(){System.out.println("Dragon sit");}
    public void hide(){System.out.println("Dragon hide");}
    public void dance(){System.out.println("Dragon dance");}
    public void mess(){System.out.println("Dragon mess");}
    public void shout(){System.out.println("Dragon shout!!");}

    public String getName(){return actName;}
	@Override
	public void grow(User presentUser, int index) {
		// TODO Auto-generated method stub
		
	}

}
