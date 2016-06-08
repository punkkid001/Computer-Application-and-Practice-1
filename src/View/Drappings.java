package View;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Model.Animal;

public class Drappings extends JLabel implements Runnable{
	private PetLabel viewPet;
	private Animal pet;
	private ImageIcon drappingImage;
	private int m_x, m_y;
	
	public Drappings(){
		try {
			this.setIcon(new ImageIcon(ImageIO.read(new File("Img\\drapping.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Drappings(PetLabel viewPet){
		this();
		this.viewPet = viewPet;
		this.setBounds(viewPet.getX()+10, viewPet.getY()+200, 37, 35);
		this.setVisible(true);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void setDVisible() {
		this.setVisible(true);
	}
}
