package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game {
	
	public static final String HALL = "hall/hallOfFame.dat";
	
	private String fileHall;
	
	private static Pak[] pakis;
	
	private int[] hall;
	
	public Game() {
		
		pakis = new Pak[5];
		pakis[0] = new Pak();
		pakis[1] = new Pak();
		pakis[2] = new Pak();
		pakis[3] = new Pak();
		pakis[4] = new Pak();
		
		fileHall = HALL;
		File HOF = new File(fileHall);
		
		
		if(HOF.exists()) {
			
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(HOF));
				hall = (int[]) ois.readObject();
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}else {
			
			hall = new int[10];
			
		}
		
	}
	
	public static Pak[] getPakis() {
		return pakis;
	}
	
	public void puntaje(int p) {
		
		hall[p*2] = p;
		
	}
	
	public void saveHall() {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileHall));
			oos.writeObject(hall);
			oos.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
