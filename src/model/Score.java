package model;

import java.io.Serializable;

public class Score implements Serializable {

	private static final long serialVersionUID = 100L;
	
	private int puntaje;
	
	public Score() {
		puntaje = 0;
	}
	
	public int getPuntaje() {
		
		return puntaje;
		
	}
	
	public void setPuntaje(int p) {
		
		puntaje = p;
		
	}
	
	public void plus() {
		puntaje++;
	}

}
