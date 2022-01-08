package com.example.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Stock;
import other.GuiScene;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DefaultSceneController implements Initializable {
    public TableColumn<Stock, String> Figi;
    public TableColumn<Stock, String> Isin;
    public TableColumn<Stock, String> Ticker;
    public TableColumn<Stock, String> Title;
    public TableColumn <Stock, Integer> CurrencyId;
    public TableColumn <Stock, Integer> InstrumentTypeId;
    public Button Add;
    public TableView<Stock> Table;

    private ObservableList<Stock> stocks = FXCollections.observableArrayList();

    public void OnAdd(ActionEvent actionEvent) throws IOException {
        HelloApplication.setScene(GuiScene.ADD);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Title.setCellValueFactory(new PropertyValueFactory<Stock, String>("title"));
        Figi.setCellValueFactory(new PropertyValueFactory<Stock, String>("figi"));
        Isin.setCellValueFactory(new PropertyValueFactory<Stock, String>("isin"));
        Ticker.setCellValueFactory(new PropertyValueFactory<Stock, String>("ticker"));
        CurrencyId.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("currencyId"));
        InstrumentTypeId.setCellValueFactory(new PropertyValueFactory<Stock, Integer>("instrumentTypeId"));

        Table.setItems(stocks);

        getData();
    }

    private void getData()
    {
        try {
            //fillTable();
        }
        catch (Exception ex){
            System.out.println("АРБАЙТЕН НИГГЕР, СОЛНЦЕ ЕЩЁ ВЫСОКО");
            ex.printStackTrace();
        }
    }



    private void fillTable(List<Stock> stock){
        stocks.clear();

        for (Stock temp : stock) {
            stocks.add(temp);
        }
    }
}
