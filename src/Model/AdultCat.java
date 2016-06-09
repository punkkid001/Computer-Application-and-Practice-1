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
    	System.out.println("AdultCat의 생성자");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Adult_cat\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public AdultCat(String name, int index)
    {
        super.setName(name);
        
        System.out.println("기본 생성자 호출");
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\Adult_monkey\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setSpeechList("냐옹 냐옹", 11);
        setSpeechList("갸르릉", 12);
        setSpeechList("나한테 점수따고 싶구나!", 13);
        setSpeechList("나한테 잘못한거 있지?", 14);
        setSpeechList("애송이 집사 주제에", 15);
        setSpeechList("감히...냥", 16);
    }
    public AdultCat(Animal p, User myUser) {
    	super(p);
    	super.setMyUser(myUser);
    	System.out.println("AdultCat의 생성자");
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
        this.setLevel(this.getLevel()+1);
        this.setExp(0);
        this.setStemina(this.getStemina()+60);
        this.setPower(this.getPower()+20);
        this.setDefense(this.getDefense()+30);
    }

    public void dance()
    {
        System.out.println("Dance..");
    }

    public String getName(){return actName;}

    public void transform(User presentUser, int index)
    {
    	System.out.println("드래곤 변신" + presentUser);
        presentUser.setAnimal(index, new Dragon(this, presentUser));
        
    }
    public boolean checkExp()
    {
    	if(this.getExp()>=30&&this.getLevel()<5) {
    		this.levelUp();
            
    		if(super.getLevel() == 3) {
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
    	System.out.println("호랑이로 진화  " + presentUser);
        presentUser.setAnimal(index, new Tiger(this, presentUser));       
    }
}
