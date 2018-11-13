package controller.viewer;


import model.Manoscritto;
import model.*;
import javafx.collections.*;

public class RicercaMetadatiController {

	public static ObservableList<Manoscritto> ricercaAutore(String dati) {
		ObservableList<Manoscritto> Result=FXCollections.observableArrayList();
		
		for (Manoscritto x: ObjectContenitor.listaManoscritti) {
			if (x.getAutore().equals(dati))
			{	Result.add(x);
			
		}}
		return Result;}
	
	
	public static ObservableList<Manoscritto> ricercaNome(String dati){
		ObservableList<Manoscritto> Result=FXCollections.observableArrayList();
		
		for(Manoscritto x: ObjectContenitor.listaManoscritti) {
			if (x.getTitolo().equals(dati))
			{Result.add(x);}
	}
		return Result;}
	
}


