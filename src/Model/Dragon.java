package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class Dragon extends Animal implements DragonAct_IF
{
	public Dragon() {
		
	}
	public Dragon(Animal p) {
    	super(p);
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\dragon\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mess();
    	/*
    	if(this.getLevel() < 4)
    		this.degradeThread();
    	*/
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
