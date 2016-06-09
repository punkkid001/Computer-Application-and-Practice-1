package Model;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 18..
 */
public class Gorilla extends AdultMonkey implements Hide_IF, Runnable
{
	private Animal before;  //for degrade
	public Gorilla(){
	
	}
	public Gorilla(Animal p) {
		super(p);
		this.before = p;
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\gorilla\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.hide();
    	if(this.getLevel() < 4)
    		this.degradeThread();
    	
    	setSpeechList("상상력이야 말로 발견의 정수입니다", 11);
        setSpeechList("고릴라 나가신다", 12);
        setSpeechList("안녕! 친구", 13);
        setSpeechList("오우! 제대로 놀아보자", 14);
        setSpeechList("한 방이면 충분해", 15);
        setSpeechList("내가 아직 재간둥이로 보이나", 16);
	}
	
	public Gorilla(Animal p, User myUser) {
    	super(p);
    	super.setMyUser(myUser);
    	
    	this.before = p;
    	
    	
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\tiger\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.hide();
    	if(this.getLevel() < 4)
    		this.degradeThread();
    }
	private void degradeThread() {
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		this.getMyLocation().dohiding(this);
	}
	public void degrade(User presentUser, int index) {
		System.out.println(presentUser.getClass());
		
		presentUser.setAnimal(index, new AdultMonkey(this));   
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
