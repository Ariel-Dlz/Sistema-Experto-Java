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
//Controlador primer pregunta.

public class FXMLDocumentController implements Initializable {
    
    @FXML private Label lbl;
    @FXML private Button btnsi;
    @FXML private Button btnno;
    @FXML private Label lblres;
    @FXML private Button btncomenzar;
    
    @FXML
    private void handleBtnSi(ActionEvent event) throws IOException {
        
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("PreguntadosFXML.fxml"));
        Stage adminStage =new Stage(); 
        Scene scene = new Scene(parent);
        adminStage.setScene(scene);
        adminStage.setResizable(false);
        adminStage.show();
    }
    
    public void handleBtnNo(ActionEvent event) {
        String resultado;
        SistemaExperto se = new SistemaExperto();
        resultado = se.ObtenerRopa("no", "no");
        lblres.setText(resultado);
        btnsi.setVisible(false);
        btnno.setVisible(false);
        lbl.setVisible(false);
    }
    
    public void handleBtnIni(ActionEvent event)throws IOException {
        lbl.setVisible(true);
        btnsi.setVisible(true);
        btnno.setVisible(true);
        btncomenzar.setVisible(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl.setVisible(false);
        btnsi.setVisible(false);
        btnno.setVisible(false);
    }    
    
}
