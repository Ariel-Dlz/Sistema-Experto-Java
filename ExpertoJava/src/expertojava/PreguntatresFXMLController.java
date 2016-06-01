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

public class PreguntatresFXMLController implements Initializable {

    @FXML private Label lbl1;
    @FXML private Button btnsi1;
    @FXML private Button btnno1;
    @FXML private Label lblres1;
    
    @FXML
    private void handleBtnSi(ActionEvent event)throws IOException {
        String resultado;
        SistemaExperto se = new SistemaExperto();
        resultado = se.ObtenerMoño("TieneFalda", "si");
        lblres1.setText(resultado);
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("MoñoFXML.fxml"));
        Stage adminStage =new Stage(); 
        Scene scene = new Scene(parent);
        adminStage.setScene(scene);
        adminStage.setResizable(false);
        adminStage.show();
    }
    
    public void handleBtnNo(ActionEvent event) {
        String resultado;
        SistemaExperto se = new SistemaExperto();
        resultado = se.ObtenerMoño("TieneFalda", "no");
        lblres1.setText(resultado);
        btnsi1.setVisible(false);
        btnno1.setVisible(false);
        lbl1.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
}
