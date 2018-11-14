
package view.frontend;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CambiaScene {
        private static String A= "AdminUI";
        private static String B= "GestioneAssegnazioni";
        private static String C= "Homepage";
       // private static String D= "ListaOpereUI";
        private static String D= "Login";
        private static String E= "Profile";
        private static String F= "Registration";
        private static String G= "SearchAuthor";
        private static String H= "SearchName";
        private static String I= "TranscriberCandidatureInterface";
        private static String L= "Transcriber";
       // private static String N= "Upload";
        
     public static  void  CambiaStage(Button b, String s) throws IOException {
      String scena1 = null;
      switch (s) {
       case "A":
        scena1="/Interface/"+A+".fxml";
        break;
       case "B":
                scena1="/Interface/"+B+".fxml";
                break;
       case "C":
                scena1="/Interface/"+C+".fxml";
                break;
       case "D":
               scena1="/Interface/"+D+".fxml";
               break;
       case "E":
                scena1="/Interface/"+E+".fxml";
                break;
       case "F":
                scena1="/Interface/"+F+".fxml";
                break;
       case "G":
                scena1="/Interface/"+G+".fxml";
                break;
       case "H":
                scena1="/Interface/"+H+".fxml";
                break;
       case "I":
                scena1="/Interface/"+I+".fxml";
                break;
       case "L":
                scena1="/Interface/"+L+".fxml";
                break;
    //   case "M":
                //scena1="/Interface/"+M+".fxml";
             //   break;
       //case "N":
         //       scena1="/Interface/"+N+".fxml";
           //     break;
            default:
            break;
      }
         
         Stage stage= (Stage) b.getScene().getWindow();
         Parent Scena = FXMLLoader.load(CambiaScene.class.getResource(scena1));
         
         Scene scene1 = new Scene(Scena,1200,900);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.setTitle(scena1);
            stage.setScene(scene1);
            stage.show();
}
}