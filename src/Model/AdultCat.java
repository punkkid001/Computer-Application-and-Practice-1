package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class AdultCat extends BabyCat implements Dance_IF
{
    public AdultCat(){
    	System.out.println("기본 생성자 호출");
    	
    }
    public AdultCat(Animal p) {
    	super(p);
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Adult_cat\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    //change
    public void levelUp()
    {
        if(this.getExp()>=30)
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
    public void checkExp()
    {
    	if(this.getExp()>=20&&this.getLevel()<5) {
    		this.levelUp();
            
    		if(super.getLevel() == 3) {
    			super.getLabel().grow();
    		//super.getLabel().setBounds(super.getLabel().getX(),super.getLabel().getY(), 144, 130);
    		//super.getLabel().setVisible(true);
    		}
    	}
    
    }
        
    public void grow(User presentUser, int index)
    {
        presentUser.setAnimal(index, new Tiger(this));       
    }
}
