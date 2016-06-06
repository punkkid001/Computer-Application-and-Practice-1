package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 18..
 */
public class Tiger extends AdultCat
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
    }
}
