package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import com.joki.veterinaria.model.AtencionVeterinaria;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;


public class AtencionCitaController implements Initializable {

    @FXML
    private Button btnGenerarFactura;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextArea txtAreaObservacionesAtencion;

    @FXML
    private TextField txtEdadAtencion;

    @FXML
    private TextField txtNombreAtencion;

    @FXML
    private TextField txtPrecioAtencion;

    @FXML
    private TextField txtRazaAtencion;

    @FXML
    private TextField txtSexoAtencion;

    @FXML
    private TextField txtTipoMascotaAtencion;

    private Application application;
    private Stage stage;
    private MenuController menuController;
    private AtencionVeterinaria atencionVeterinaria;
    ModelFactoryController mfm = ModelFactoryController.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Uso del TextFormatter para solo permitir numeros en el apartado de costo
        TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter(), 70000.0, c -> {
            if (c.getControlNewText().matches("-?\\d*(\\.\\d*)?")) { //Expresion para double
                return c;
            } else {
                return null;
            }
        });
        txtPrecioAtencion.setTextFormatter(textFormatter);
    }

    public void setAplicacion(Application application) {
        this.application = application;
    }

    public void init(Stage stage, MenuController menuController, AtencionVeterinaria atencionVeterinariaSeleccionada) {
        this.stage = stage;
        this.menuController = menuController;
        this.atencionVeterinaria = atencionVeterinariaSeleccionada;
        //Lleno campos sobre la información de la mascota atender
        txtNombreAtencion.setText(atencionVeterinaria.getMascota().getNombre());
        txtNombreAtencion.setDisable(true);
        txtEdadAtencion.setText(atencionVeterinaria.getMascota().getEdad() + " año(s)");
        txtEdadAtencion.setDisable(true);
        txtSexoAtencion.setText(atencionVeterinaria.getMascota().getSexo().toString());
        txtSexoAtencion.setDisable(true);
        txtRazaAtencion.setText(atencionVeterinaria.getMascota().getRaza());
        txtRazaAtencion.setDisable(true);
        txtTipoMascotaAtencion.setText(atencionVeterinaria.getMascota().getTipo().toString());
        txtTipoMascotaAtencion.setDisable(true);
    }

    /**
     * Muestra un mensaje dependiendo con el tipo de alerta seleccionado
     * @param title
     * @param header
     * @param content
     * @param alertType
     */
    public void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    //FUNCIONES DE LA VENTANA ------------------------------------------------------------------

    /**
     * Genera la factura despues de atendida la mascota
     * @param event
     */
    @FXML
    void generarFactura(ActionEvent event) {
        Double precio = Double.parseDouble(txtPrecioAtencion.getText());
        String observaciones = txtAreaObservacionesAtencion.getText();
        if (validarDatosAtencion(precio, observaciones)) {
                mfm.crearFactura(atencionVeterinaria, precio, observaciones);
                mostrarMensaje("Notificación cita", "Información de la cita valida", "La factura ha sido generada correctamente", Alert.AlertType.INFORMATION);
                this.stage.close();
                menuController.show();
        }
    }

    /**
     * Verifica que el precio sea mayor a 70.000 y que las observaciones no esten vacias
     * @param precio
     * @param observaciones
     * @return
     */
    private boolean validarDatosAtencion(Double precio, String observaciones) {
        String notificacion = "";
        if (precio.equals(null) || precio < 70000.0) {
            notificacion += "El precio es invalido, asegurese de que sea mayor a 70000.0\n";
        }
        if (observaciones == null || observaciones.equals("")) {
            notificacion += "Las observaciones son invalidas\n";
        }
        if (notificacion.equals("")) {
            return true;
        }
        mostrarMensaje("Notifiación cita", "Información de la cita invalida", notificacion, Alert.AlertType.WARNING);
        return false;
    }

    @FXML
    void regresar(ActionEvent event) {
        this.stage.close();
        menuController.show();
    }

}
