/*
 * Remy Rogers 
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SierpinskisTriangle extends Canvas {
	//main method to draw triangle
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Sierpinksi's Triangle");
		frame.setSize(900,900);
		SierpinskisTriangle st = new SierpinskisTriangle();
		frame.add(st);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//paint method with graphics updates
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		drawTriangle(450, 50, 700, g);
		g.setColor(Color.WHITE);
		drawUTriangle(450, 357, 347, g);
	}
	
	//for drawing background triangle
	public void drawTriangle(int x, int y, int side, Graphics g)
	{
		int sub = side/2;
		int[] xPoints = { x, x - sub, x + sub};
        int[] yPoints = {y, y + (int)((sub + 4) * Math.sqrt(3)), y + (int)((sub + 4) * Math.sqrt(3)) };
        g.fillPolygon(xPoints, yPoints, 3);
	}
	
	//draws all upside down triangles using recursive calls
	public void drawUTriangle(int x, int y, int side, Graphics g)
	{
		int sub = side/2;
		int[] xPoints = {x, x - (41*sub)/40, x + (41*sub)/40};
        int[] yPoints = {y + (int)(sub * Math.sqrt(3)), y, y};
        g.fillPolygon(xPoints, yPoints, 3);
        
		if (sub >= 4)
		{
			g.setColor(Color.WHITE);
	        //recursive calls
			//bottom left
			drawUTriangle(x-sub, y + (9 * sub) / 10, sub, g);
			//bottom right
			drawUTriangle(x+sub, y + (9 * sub)/10, sub, g);
			//top
			drawUTriangle(x, y - (7 * sub)/8, sub, g);
		}
	}
}
