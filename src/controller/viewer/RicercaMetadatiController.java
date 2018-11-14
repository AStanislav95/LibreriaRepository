package controller.viewer;

import model.Manoscritto;
import model.*;

import java.util.ArrayList;

import javafx.collections.*;

public class RicercaMetadatiController {

	public static ObservableList<String> ricercaAutore(String dati) {
		
		ObservableList<String> Result = FXCollections.observableArrayList();
		
		for (Manoscritto x : ObjectContenitor.listaManoscritti) {
			
			if (x.getAutore().equals(dati)) {
				
				Result.add(x.getTitolo());

			}
		}
		return Result;
	}

	public static ObservableList<Pagina> ricercaNome(String dati) {
		
		ObservableList<Pagina> Result = FXCollections.observableArrayList();
		

		for (Manoscritto x : ObjectContenitor.listaManoscritti) {
			
			if (x.getTitolo().equals(dati)) {
				
				Result = x.getListaPagine();
			
			}
		}
		return Result;
	}

}
