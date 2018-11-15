package controller;

import java.sql.ResultSet;

import controller.dao.ManoscrittoDAO;
import controller.dao.PaginaDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Manoscritto;
import model.ObjectContenitor;
import model.Pagina;

public class entry extends Application{

	public static Stage mainStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/GUI/Login.fxml"));
		Scene scene = new Scene(root, 400, 400);
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
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
		
		
		//getPages
		for(Manoscritto m: ObjectContenitor.listaManoscritti) {
			try {
				//prs contiene tutte le pagine del manoscritto corrente
				
				ResultSet prs = PaginaDAO.getPages(m.getID());
				//aggiungo le pagine al manoscritto
				
				while(prs.next()) {
					
					m.setListaPagine(new Pagina(prs.getInt(2), prs.getInt(3), prs.getString(5)));
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
