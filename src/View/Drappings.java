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
	private int o_x, o_y; // move object
	private double speed_x, speed_y;
	private int myNum;
	
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
		this.pet = viewPet.pet;
		this.m_x = pet.getX();
		this.m_y = pet.getY();
		System.out.println("√÷√  ∂À ¡¬«• : " + m_x +" " + m_y);
		//this.setBounds(m_x-15, m_y+160, 37, 35);
		//this.setVisible(true);
	}
	public Drappings(PetLabel viewPet, int myNum) {
		this(viewPet);
		this.myNum = myNum;
		this.setBounds(m_x-15+ 30*myNum, m_y+120+10*myNum , 37, 35);
	}
	@Override
	public void run() {
		double x_cal, y_cal;
		while(true) {
			x_cal = this.viewPet.getX();
			y_cal = this.viewPet.getY();
			System.out.println("x, y ∂À¡¬«•" + x_cal +" "+ y_cal);
			this.setLocation((int)x_cal-15+ 30*myNum, (int)y_cal+110+10*myNum);
		//m_x-10 + 40*myNum, m_y+130, 37, 35
			if(this.viewPet.getMoveflag() == 0)
				break;
		// TODO Auto-generated method stub
		}
	}
	public void moveThread(int ox, int oy, double xspeed, double yspeed) {
		Thread t = new Thread(this);
		this.o_x = ox;
		this.o_y = oy;
		this.speed_x = xspeed;
		this.speed_y = yspeed;
		t.start();
	}
	public void setDVisible() {
		this.setVisible(true);
	}
}
