package view.frontend;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Pagina;

import javax.imageio.ImageIO;

import controller.entry;

public class SearchByNameInterfaceController implements Initializable {

	@FXML
	private ListView<ImageView> listView;
	@FXML
	private ImageView selectedImage;
	@FXML
	private Button Homepage;
	@FXML
	private Button download;

	@FXML
	private void download(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		
		fileChooser.setTitle("Scegli dove salvare");
		
		File file = fileChooser.showSaveDialog(entry.getStage());
		if(file != null){
		    try{
			ImageIO.write(SwingFXUtils.fromFXImage(selectedImage.getImage(),
	                        null), "png", file);
		    }catch(IOException ex){
		    }
	}

	}

	@FXML
	private void back(ActionEvent e) throws Exception {
		Button b= (Button)e.getSource();
		CambiaScene.CambiaStage(b);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		ObservableList<ImageView> listImage = FXCollections.observableArrayList();
		
	
		for(Pagina p: HomepageInterfaceController.getpagManoscritti()) {
			
			try {
				
				listImage.add(generateImage(p.getScanpath()));
				//works ---> listImage.add(generateImage("/home/stas/Pictures/img1.png"));
						
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		listView.setItems(listImage);
		listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ImageView>() {
		    @Override
		    public void changed(ObservableValue<? extends ImageView> observable, ImageView oldValue, ImageView newValue) {
			selectedImage.setImage(newValue.getImage());
		    }

	});
		
	}
	
	 public ImageView generateImage(String pathImage) throws MalformedURLException {

			File file = new File(pathImage);
			ImageView container = new ImageView(new Image(file.toURI().toURL().toExternalForm()));
			container.setFitHeight(120);
			container.setFitWidth(120);
			return container;
		}

}