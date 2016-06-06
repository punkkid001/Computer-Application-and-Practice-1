package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class BabyMonkey extends Animal
{
    public BabyMonkey(){
    	
    }
    public BabyMonkey(Animal p) {
    	super(p);
    	System.out.println("기본 생성자 호출");
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
        
        System.out.println("기본 생성자 호출");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Baby_monkey\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    public void checkExp()
    {
    	if(this.getExp()>=20&&this.getLevel()<5) {
    		this.levelUp();
            
    		if(super.getLevel() == 2) {
    			super.getLabel().grow();
    		//super.getLabel().setBounds(super.getLabel().getX(),super.getLabel().getY(), 144, 130);
    		//super.getLabel().setVisible(true);
    		}
    	}
    }
    
    public void grow(User presentUser, int index)
    {
        presentUser.setAnimal(index, new AdultMonkey(this));
    }
}
