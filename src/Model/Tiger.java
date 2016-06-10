package Model;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 18..
 */
public class Tiger extends AdultCat implements Mess_IF, Runnable, Degrade_IF
{
	private Animal before;  //for degrade
	public Tiger() {
		
	}
	public Tiger(Animal p) {
    	super(p);
    	this.before = p;
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\tiger\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mess();
    	if(this.getLevel() < 4)
    		this.degradeThread();
    	
    	setSpeechList("난장판이다!!!", 11);
        setSpeechList("깽판치기 딱 좋은 날이네", 12);
        setSpeechList("석양이 진다...", 13);
        setSpeechList("친한척 굴지 마", 14);
        setSpeechList("나는 대재앙을 불러온다", 15);
        setSpeechList("뒤를 보이지 마", 16);
    }
	public Tiger(Animal p, User myUser) {
    	super(p);
    	super.setMyUser(myUser);
    	
    	this.before = p;
    	
    	
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\tiger\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mess();
    	if(this.getLevel() < 4)
    		this.degradeThread();
    }
	private void degradeThread() {
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public String mess() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int drapNum = r.nextInt(3) + 1;
		for(int i = 0; i < drapNum; i++) {
			this.getMyLocation().makeWaste();
		}
		return "전부 다 어지른다! 어흥!";
	}
	public void degrade(User presentUser, int index) {
		System.out.println(presentUser.getClass());
		
		presentUser.setAnimal(index, new AdultCat(this));   
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
