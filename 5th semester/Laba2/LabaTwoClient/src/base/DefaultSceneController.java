package base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.endpoint.TovarServiceService;
import types.Tovar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;

public class DefaultSceneController implements Initializable {
    public Button Calculate;
    public Label Output;
    public TableColumn <Tovar, String> Title;
    public TableColumn <Tovar, Integer> Price;
    public TableColumn <Tovar, Integer> Count;
    public Button Add;
    public TableView<Tovar> Table;

    private ObservableList<Tovar> products = FXCollections.observableArrayList();
    private TovarServiceService tovarService;

    public void OnAdd(ActionEvent actionEvent) throws IOException {

        Form.setScene(GuiScene.ADD);
    }

    public void OnCalculate(ActionEvent actionEvent) {
        int sum = 0;
        for (Tovar temp : products) {
            sum += temp.getPrice()*temp.getKol();
        }

        Output.setText(String.valueOf(sum));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tovarService = new TovarServiceService();

        Title.setCellValueFactory(new PropertyValueFactory<Tovar, String>("name"));
        Price.setCellValueFactory(new PropertyValueFactory<Tovar, Integer>("price"));
        Count.setCellValueFactory(new PropertyValueFactory<Tovar, Integer>("kol"));
        Table.setItems(products);

        getData();
    }

    private void getData()
    {
        try {
            fillTable(tovarService.getTovarServicePort().getAllTovar().getItem());
        }
        catch (Exception ex){
            System.out.println("???????????????? ????????????, ???????????? ?????? ????????????");
            ex.printStackTrace();
        }
    }



    private void fillTable(List<Tovar> tovars){
        products.clear();

        for (Tovar temp : tovars) {
            products.add(temp);
        }
    }
}
