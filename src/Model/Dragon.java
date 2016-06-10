package Model;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import View.PetLabel;

/**
 * Created by Jiyoon on 2016. 5. 17..
 */
public class Dragon extends Animal implements DragonAct_IF, Runnable
{
	private Animal returnAnimal;
	
	
	public Dragon() {
		
	}
	public Dragon(Animal p) {
    	super(p);
    	setSpeechList("(무관심인것 같다)", 11);
        setSpeechList("(무관심인것 같다)", 12);
        setSpeechList("(무관심인것 같다)", 13);
        setSpeechList("(무관심인것 같다)", 14);
        setSpeechList("(무관심인것 같다)", 15);
        setSpeechList("(무관심인것 같다)", 16);
    	this.returnAnimal = p;
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\dragon\\ordinary.png"))));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mess();
    	
    	
    	if(this.getLevel() < 5)
    		this.degradeThread();
    	
    }
	public Dragon(Animal p, User myUser) {
    	super(p);
    	super.setMyUser(myUser);
    	
    	this.returnAnimal = p;
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\dragon\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mess();
    	System.out.println("왜 안숨니?" + this.getLabel());
    	this.hide();
    	
    	this.degradeThread();
    	
    }
    public void sit(){System.out.println("Dragon sit");}
    @Override
	public void hide() {
		// TODO Auto-generated method stub
		this.getMyLocation().dohiding(this);
	}
    public void dance(){System.out.println("Dragon dance");}
    public void mess() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int drapNum = r.nextInt(3) + 1;
		for(int i = 0; i < drapNum; i++) {
			this.getMyLocation().makeWaste();
		}
	}
    public String shout(){
    	this.getLabel().makeBless();
    	return "무시무시한 화염이다!";
    	}

    //public String getName(){return this.getName();}
	@Override
	public void grow(User presentUser, int index) {
		// TODO Auto-generated method stub
		
	}
	public void degrade(User presentUser, int index) {
		System.out.println("퇴화 왜 안해?" + presentUser.getClass());
		
		presentUser.setAnimal(index, this.returnAnimal);   
	}
	private void degradeThread() {
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000); //10s
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.getLabel().degrade();
	}
}
