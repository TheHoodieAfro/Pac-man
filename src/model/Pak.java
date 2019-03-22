package model;

import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class Pak {
	
	//Attributes
	private double x;
	private double y;
	private double rad;
	private int speed;
	private enum Direction{up, down, left, right};
	private Direction direccion;
	
	//Relations
	private Arc paki;
	
	//Constructor
	public Pak() {
		
		rad = rad();
		x = positionX();
		y = positionY();
		speed = (int) Math.random() * 3 + 1;
		
		paki = new Arc(x, y, rad, rad, 40.0, 300.0);
		paki.setType(ArcType.ROUND);
		paki.setFill(Color.rgb((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256)));
		int lo = directX();
		
		if(lo <= 5) {
			
			direccion =  Direction.right;
			
		}else if(lo>5 && lo <= 10) {
			
			direccion = Direction.left;
			
		}else if(lo > 10 && lo <=15) {
			
			direccion = Direction.up;
			
		}else {
			
			direccion = Direction.down;
			
		}
		
	}
	
	//Attributes setters
	public double rad() {
		
		double r = (Math.random() * 40 + 20);
		
		return r;
		
	}
	
	public double positionX() {
		
		Random rand = new Random();
		
		int r = (int) rad;
		
		int i = rand.nextInt(900-(1+r) - r) + (1+r);
		
		return i;
		
	}
	
	public double positionY() {
		
		Random rand = new Random();
		
		int r = (int) rad;
		
		int i = rand.nextInt(600-(1+r) - r) + (1+r);
		
		return i;
		
	}
	
	public int directX() {
		
		Random rand = new Random();
		
		int i = rand.nextInt(20)+1;
		
		return i;
		
	}
	
	//Getters
	public Arc getPaki() {
		return paki;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getRad() {
		return rad;
	}
	
	//Setters
	public void setX(double xx) {
		x = xx;
		paki.setLayoutX(xx);
	}
	
	public void setY(double yy) {
		x = yy;
		paki.setLayoutY(yy);
	}
	
	//Extra Methods
	public double upX(double w, double xinc) {
		
		int dash = 0;
		
		if(xinc > w) {
			direccion = Direction.left;
		}else if (xinc == 0) {
			direccion = Direction.right;
		}
		
		switch(direccion) {
		 case left:
			 dash = -1*speed;
			 break;
		 case right:
			 dash = speed;
			 break;
		default:
			break;
			 
		 }
		
		return dash;
		
	}
	
	public double upY(double h, double yinc) {
		
		int dash = 0;
		
		if(yinc > h) {
			direccion = Direction.up;
		}else if (yinc <= 0) {
			direccion = Direction.down;
		}
		
		switch(direccion) {
		 case up:
			 dash = -1*speed;
			 break;
		 case down:
			 dash = speed;
			 break;
		default:
			break;
			 
		 }
		
		return dash;
		
	}
	
}
