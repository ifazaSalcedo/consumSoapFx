package app.fx.soap.uicontroller;

import app.fx.soap.client.ConsultaRucSoapClient;
import app.fx.soap.wsdl.ConsultaRucResponse;
import app.fx.soap.wsdl.RucContribuyente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ConsultaRucUIController implements Initializable {
    @FXML
    private AnchorPane ap_principal;
    @FXML
    private TextField txt_ruc;
    @FXML
    private TextField txt_dv;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellido;
    @FXML
    private TextField txt_rucAnterior;
    @FXML
    private TextField txt_estado;
    @FXML
    private Button btn_cancelar;
    @Autowired
    private ConsultaRucSoapClient consultaRucSoapClient;

    private ObservableList<TextField> textFieldObservableList = FXCollections.observableArrayList();



    @Bean
    public String titulo() {
        return "Consulta de Ruc -> Servicio SOAP";
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textFieldObservableList.addAll(
                txt_ruc,
                txt_nombre,
                txt_apellido,
                txt_dv,
                txt_rucAnterior,
                txt_estado);

        btn_cancelar.setOnAction(e -> limpiarEntorno());
        txt_ruc.setOnAction(actionEvent -> {
            buscarRuc((TextField)actionEvent.getSource());
        });

        limpiarEntorno();


    }

    private void buscarRuc(TextField textField) {
        if(textField.getText().isEmpty()){
            return;
        }else {
            ConsultaRucResponse response = consultaRucSoapClient.getConsultaRuc(textField.getText().trim());
            colocarRucContribuyente(response.getRucContribuyente());
        }
    }

    private void colocarRucContribuyente(RucContribuyente rucContribuyente) {
        if (rucContribuyente != null){
            txt_dv.setText(rucContribuyente.getDv());
            txt_nombre.setText(rucContribuyente.getNombre());
            txt_apellido.setText(rucContribuyente.getApellido());
            txt_rucAnterior.setText(rucContribuyente.getRucAnterior());
            txt_estado.setText(rucContribuyente.getRucEstado());
        }
    }

    private void limpiarEntorno() {
        for (TextField tx : textFieldObservableList){
            tx.setText("");
            tx.setEditable(false);
            if(tx.equals(txt_ruc)){
                tx.requestFocus();
                tx.setEditable(true);
            }
        }
    }
}
