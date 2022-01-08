package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import other.GuiScene;
import other.HttpManager;
import other.KeysAndTokens;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AuthSceneController implements Initializable {
    public TextField Password;
    public TextField Login;
    public Label Error;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void OnAuth(ActionEvent actionEvent) throws IOException {

        try{
            KeysAndTokens.ServerToken = HttpManager.getToken(Login.getText(), Password.getText());
            HelloApplication.setScene(GuiScene.DEF);
        }
        catch (Exception e){
            Error.setText("Ошибка при авторизации");
        }
    }
}
