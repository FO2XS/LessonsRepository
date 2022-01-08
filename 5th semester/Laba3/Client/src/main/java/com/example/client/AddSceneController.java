package com.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.Stock;
import other.GuiScene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddSceneController implements Initializable {
    public TextField Title;
    public TextField Price;
    public TextField Count;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void OnAdd(ActionEvent actionEvent) {
        Stock tovar = new Stock();

        /*tovar.setName(Title.getText());
        tovar.setPrice(Integer.parseInt(Price.getText()));
        tovar.setKol(Integer.parseInt(Count.getText()));*/
    }

    public void OnCancel(ActionEvent actionEvent) throws IOException {
        HelloApplication.setScene(GuiScene.DEF);
    }
}
