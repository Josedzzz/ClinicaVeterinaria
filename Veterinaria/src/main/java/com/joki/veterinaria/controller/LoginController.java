package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import com.joki.veterinaria.model.Veterinario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button btnIngresarLogin;

    @FXML
    private TextField txtCodigoLogin;

    @FXML
    private TextField txtNombreLogin;

    //Variables auxiliares
    private Application application;
    private Stage stage;
    private Veterinario veterinarioLogin;
    ModelFactoryController mfm = ModelFactoryController.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        stage.show();
        txtCodigoLogin.setText("");
        txtNombreLogin.setText("");
    }

    /**
     * Muestra un mensaje dependiendo el tipo de alerta seleccionado
     * @param title
     * @param header
     * @param content
     * @param alertType
     */
    private void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void iniciarSesion(ActionEvent event) throws IOException {
        String nombre = txtNombreLogin.getText();
        String codigo = txtCodigoLogin.getText();
        if (datosValidosVeterinario(nombre, codigo)) {
            iniciarSesion(nombre, codigo);
        }
    }

    /**
     * Verifica que los textFields no esten vacios
     * @param nombre
     * @param codigo
     * @return
     */
    private boolean datosValidosVeterinario(String nombre, String codigo) {
        String notificacion = "";
        if (nombre == null || nombre.equals("")) {
            notificacion += "El campo: nombre del veterinario está vacio\n";
        }
        if (codigo == null || codigo.equals("")) {
            notificacion += "El campo: código está vacio\n";
        }
        if (notificacion.equals("")) {
            return true;
        }
        mostrarMensaje("Notificación Login", "Información invalida", notificacion, Alert.AlertType.WARNING);
        return false;
    }

    /**
     * Inicia sesion si los datos son validos (son los de un veterinario)
     * @param nombre
     * @param codigo
     */
    private void iniciarSesion(String nombre, String codigo) throws IOException {
        veterinarioLogin = mfm.darVeterinario(nombre, codigo);
        if (veterinarioLogin != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("/com/joki/veterinaria/MenuView.fxml"));
            BorderPane borderPane = (BorderPane) loader.load();
            MenuController controller = loader.getController();
            controller.setAplicacion(application);
            Scene scene = new Scene(borderPane);
            Stage stage = new Stage();
            stage.setTitle("Menu");
            stage.setScene(scene);
            controller.init(stage, this, veterinarioLogin);
            stage.show();
            this.stage.close();
        } else {
            mostrarMensaje("Notificación Login", "Datos invalidos", "Los datos del veterinario son invalidos", Alert.AlertType.WARNING);
        }
    }
}