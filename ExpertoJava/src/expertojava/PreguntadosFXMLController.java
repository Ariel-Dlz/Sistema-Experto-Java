package expertojava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PreguntadosFXMLController implements Initializable {
    
    @FXML private Label lbl1;
    @FXML private Button btnsi1;
    @FXML private Button btnno1;
    @FXML private Label lblres1;
    
    @FXML
    private void handleBtnSi(ActionEvent event)throws IOException {
        String resultado;
        SistemaExperto se = new SistemaExperto();
        resultado = se.ObtenerRopa("si", "no");
        lblres1.setText(resultado);
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("PreguntatresFXML.fxml"));
        Stage adminStage =new Stage(); 
        Scene scene = new Scene(parent);
        adminStage.setScene(scene);
        adminStage.setResizable(false);
        adminStage.show();
    }
    
    public void handleBtnNo(ActionEvent event) throws IOException {
        String resultado;
        SistemaExperto se = new SistemaExperto();
        resultado = se.ObtenerRopa("no", "si");
        lblres1.setText(resultado);
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("CabezaFXML.fxml"));
        Stage adminStage =new Stage(); 
        Scene scene = new Scene(parent);
        adminStage.setScene(scene);
        adminStage.setResizable(false);
        adminStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
