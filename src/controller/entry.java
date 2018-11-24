package controller;

import java.io.IOException;
import java.sql.ResultSet;

import controller.dao.ManoscrittoDAO;
import controller.dao.PaginaDAO;
import controller.dao.TrascrizioneDAO;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.Manoscritto;
import model.ObjectContenitor;
import model.Pagina;
import model.Trascrizione;

public class entry extends Application{
	public static Boolean isSplashLoaded = false;
	 
	public static Stage mainStage;

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/GUI/Login.fxml"));
		Scene scene = new Scene(root, 520, 500);
		

	

		scene.getStylesheets().add("/view/GUI/style/Border.css");
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		scene.setFill(Color.TRANSPARENT);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.show();
		
		try {
			ResultSet ms = ManoscrittoDAO.getManoscritti();
			
			while(ms.next()) {
				Manoscritto m = new Manoscritto(ms.getInt(1), ms.getInt(2), ms.getInt(3), ms.getInt(4), ms.getString(5), ms.getString(6), ms.getString(7));
				ObjectContenitor.listaManoscritti.add(m);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
//		
//		ResultSet tras = TrascrizioneDAO.getTrascrizioni();
//		while(tras.next()) {
//			
//			ObjectContenitor.listaTrascrizione.add(new Trascrizione(tras.getInt(1), tras.getString(2), tras.getString(3), tras.getInt(4), tras.getInt(5), tras.getInt(6)));
//		}
//		
		
		
		
		//getPages
		for(Manoscritto m: ObjectContenitor.listaManoscritti) {
			try {
				//prs contiene tutte le pagine del manoscritto corrente
				
				ResultSet prs = PaginaDAO.getPagesTrascrizione(m.getID());
				//aggiungo le pagine al manoscritto
				
				while(prs.next()) {
					
					m.setListaPagine(new Pagina(prs.getInt(1), prs.getInt(2), prs.getInt(3), prs.getString(4), prs.getString(5)));
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
    public static Stage getStage(){
    	return mainStage;
    }
    
}

