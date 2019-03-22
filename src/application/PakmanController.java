package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Game;
import model.Pak;
import model.Score;
import thread.PakThread;

public class PakmanController {
	
	@FXML private Label lblPuntaje;
	@FXML private Pane pain;
	
	private Game game;
	private Score score;
	
	private PakThread hiloPak;
	
	private Pak[] pakis;
	
	//Menu methods
	public void cargarJuego(ActionEvent a) {
		
		
		
	}

	public void guardarJuego(ActionEvent a) {
		
		
		
	}
	
	@SuppressWarnings("static-access")
	public void nuevoJuego(ActionEvent a) {
		
		pain.getChildren().add(pakis[0].getPaki());
		pain.getChildren().add(pakis[1].getPaki());
		pain.getChildren().add(pakis[2].getPaki());
		pain.getChildren().add(pakis[3].getPaki());
		pain.getChildren().add(pakis[4].getPaki());
		
		hiloPak = new PakThread(pakis[0], pakis[1], pakis[2], pakis[3], pakis[4], this);
		
		pakis[0].getPaki().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            	pakis[0].getPaki().setVisible(false);
            	score.plus();
            	lblPuntaje.setText("Puntaje: "+ Integer.toString(score.getPuntaje()));

            }
        });
		pakis[1].getPaki().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            	pakis[1].getPaki().setVisible(false);
            	score.plus();
            	lblPuntaje.setText("Puntaje: "+ Integer.toString(score.getPuntaje()));

            }
        });
		pakis[2].getPaki().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            	pakis[2].getPaki().setVisible(false);
            	score.plus();
            	lblPuntaje.setText("Puntaje: "+ Integer.toString(score.getPuntaje()));

            }
        });
		pakis[3].getPaki().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            	pakis[3].getPaki().setVisible(false);
            	score.plus();
            	lblPuntaje.setText("Puntaje: "+ Integer.toString(score.getPuntaje()));

            }
        });
		pakis[4].getPaki().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
            	pakis[4].getPaki().setVisible(false);
            	score.plus();
            	lblPuntaje.setText("Puntaje: "+ Integer.toString(score.getPuntaje()));

            }
        });
		
		hiloPak.start();
		
	}

	public void salir(ActionEvent a) {
		
		System.exit(0);
		game.saveHall();
	
	}

	public void displayHall(ActionEvent a) {
	
	
	
	}

	public void displayInfo(ActionEvent a) {
	
	
	
	}
	
	public void initialize() {
		
		game = new Game();
		score = new Score();
		pakis = Game.getPakis();
		
	}
	
	//Extra methods
	public void MovePaks(Pak p) {
		
		double wPane = pain.getWidth();
		double hPane = pain.getHeight();
		
		for(int i=0; i<pakis.length; i++) {
			
			if(pakis[i].equals(p)) {
				
				double x = pakis[i].getPaki().getLayoutX();
				double y = pakis[i].getPaki().getLayoutY();
				
				double radx = pakis[i].getPaki().getLayoutX()+15;
				double rady = pakis[i].getPaki().getLayoutY()+15;
				
				pakis[i].getPaki().setLayoutX(x+pakis[i].upX(wPane, radx));
				pakis[i].getPaki().setLayoutY(y+pakis[i].upY(hPane, rady));
				
			}
			
		}
		
	}
	
	public boolean end() {
		
		boolean f = true;
		
		if(!pakis[0].getPaki().isVisible() && !pakis[1].getPaki().isVisible() && !pakis[2].getPaki().isVisible() && !pakis[3].getPaki().isVisible() && !pakis[4].getPaki().isVisible()) {
			
			f = false;
			System.out.println("stoped");
			game.puntaje(score.getPuntaje());
			
		}
		
		return f;
		
	}
	
}
