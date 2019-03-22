package thread;

import application.PakmanController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.util.Duration;
import model.Pak;

public class PakThread extends Thread{
	
	private Pak pak1;
	private Pak pak2;
	private Pak pak3;
	private Pak pak4;
	private Pak pak5;
	private PakmanController cont;
	
	public PakThread(Pak p1, Pak p2, Pak p3, Pak p4, Pak p5, PakmanController cont) {
		
		pak1 = p1;
		pak2 = p2;
		pak3 = p3;
		pak4 = p4;
		pak5 = p5;
		this.cont = cont;
		
	}
	
	@Override
	public void run() {
		
		while(cont.end()) {
			cont.MovePaks(pak1);
			cont.MovePaks(pak2);
			cont.MovePaks(pak3);
			cont.MovePaks(pak4);
			cont.MovePaks(pak5);
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
