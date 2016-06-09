package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import View.PetLabel;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class BabyMonkey extends Animal
{
    public BabyMonkey(){}
    public BabyMonkey(Animal p)
    {
    	super(p);
    	System.out.println("±âº» »ý¼ºÀÚ È£Ãâ");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Baby_monkey\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public BabyMonkey(String name, int index)
    {
        super.setName(name);
        
        System.out.println("±âº» »ý¼ºÀÚ È£Ãâ");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Baby_monkey\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setSpeechList("¿ì³¢³¢ ¹Ý°¡¿ö!", 11);
        setSpeechList("¿ìƒ­ ¾È³ç~", 12);
        setSpeechList("¿ì°¼¿ì°¼°¼ °í¸¶¿ö!", 13);
        setSpeechList("¿ì²¥²¦ ±×·¡~~", 14);
        setSpeechList("¿ì¿õ...³Ê¹« ±×·¯Áø¸¶", 15);
        setSpeechList("¼³±³ÇÏÁö¸¶ ²¥ƒ­", 16);
    }
    
    public BabyMonkey(String name, int price, boolean flag)
    {
    	this();
    	super.setName(name);
    	super.setPrice(price);
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
    public boolean checkExp()
    {
    	if(this.getExp()>=20&&this.getLevel()<5) {
    		this.levelUp();
            
    		if(super.getLevel() == 2) {
    			super.getLabel().grow();
    		//super.getLabel().setBounds(super.getLabel().getX(),super.getLabel().getY(), 144, 130);
    		//super.getLabel().setVisible(true);
    		}
    		
    		return true;
    	}
    	else
    		return false;
    }
    
    public void grow(User presentUser, int index)
    {
        presentUser.setAnimal(index, new AdultMonkey(this));
    }
}
