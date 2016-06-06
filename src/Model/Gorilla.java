package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by Jiyoon on 2016. 5. 18..
 */
public class Gorilla extends AdultMonkey
{
	public Gorilla(){
	
	}
	public Gorilla(Animal p) {
		super(p);
    	try {
			this.setMyImageIcon(new ImageIcon(ImageIO.read(new File("Img\\gorilla\\ordinary.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
