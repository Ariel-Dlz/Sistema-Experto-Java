package expertojava;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MoñoFXMLController implements Initializable {

    @FXML private Label lbl1;
    @FXML private Button btnsi1;
    @FXML private Button btnno1;
    @FXML private Label lblres1;
    
    @FXML
    private void handleBtnSi(ActionEvent event)throws IOException {
        String resultado;
        SistemaExperto se = new SistemaExperto();
        resultado = se.ObtenerColorMoño("TieneMoño", "si");
        lblres1.setText(resultado);
        btnsi1.setVisible(false);
        btnno1.setVisible(false);
        lbl1.setVisible(false);
    }
    
    public void handleBtnNo(ActionEvent event) {
        String resultado;
        SistemaExperto se = new SistemaExperto();
        resultado = se.ObtenerColorMoño("TieneMoño", "no");
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
