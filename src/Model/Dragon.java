package Model;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
    	this.returnAnimal = p;
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\dragon\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mess();
    	this.hide();
    	/*
    	if(this.getLevel() < 4)
    		this.degradeThread();
    	*/
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
    public void shout(){System.out.println("Dragon shout!!");}

    public String getName(){return actName;}
	@Override
	public void grow(User presentUser, int index) {
		// TODO Auto-generated method stub
		
	}
	public void degrade(User presentUser, int index) {
		System.out.println(presentUser.getClass());
		
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
