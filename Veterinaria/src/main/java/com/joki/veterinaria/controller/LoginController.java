package com.joki.veterinaria.controller;

import com.joki.veterinaria.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label lblPrueba;
    private Application application;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}