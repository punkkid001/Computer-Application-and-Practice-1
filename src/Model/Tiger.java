package Model;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 18..
 */
public class Tiger extends AdultCat implements Mess_IF
{
	public Tiger() {
		
	}
	public Tiger(Animal p) {
    	super(p);
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\tiger\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.mess();
    }
	@Override
	public void mess() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int drapNum = r.nextInt(4);
		for(int i = 0; i < drapNum; i++) {
			this.getMyLocation().makeWaste();
		}
	}
	
	
}
