package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Waste extends JLabel implements MouseListener{
	private int m_x, m_y;
	private Place p;
	
	public Waste() {
		Random r = new Random();
		this.m_x = r.nextInt(850);
		this.m_y = r.nextInt(500);
		int kind = r.nextInt(4);
		try {
			switch(kind) {
			case 0:
				this.setIcon(new ImageIcon(ImageIO.read(new File("Img\\trash\\trash1.png"))));
				break;
			case 1:
				this.setIcon(new ImageIcon(ImageIO.read(new File("Img\\trash\\trash2.png"))));
				break;
			case 2:
				this.setIcon(new ImageIcon(ImageIO.read(new File("Img\\trash\\trash3.png"))));
				break;
			case 3:
				this.setIcon(new ImageIcon(ImageIO.read(new File("Img\\trash\\trash4.png"))));
				break;
			case 4:
				this.setIcon(new ImageIcon(ImageIO.read(new File("Img\\trash\\trash5.png"))));
				break;
			default:
				System.out.println("error");
				break;	
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setBounds(m_x, m_y, 90, 60);
	}
	public Waste(Place p) {
		this();
		this.p = p;
		this.addMouseListener(this);
		this.setVisible(true);
	}
	
	public void remove() {
		this.p.removeWaste(this);
		this.setVisible(false);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.remove();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
