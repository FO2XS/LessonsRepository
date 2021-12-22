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
import operation.TovarOperation;
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
    private TovarOperation tovarOperation;

    public void OnAdd(ActionEvent actionEvent) throws IOException {

        Form.setScene(GuiScene.ADD);
    }

    public void OnCalculate(ActionEvent actionEvent) {
        int sum = 0;
        for (Tovar temp : products) {
            sum += temp.getSumma();
        }

        Output.setText(String.valueOf(sum));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tovarOperation = (TovarOperation) Naming.lookup("//localhost:1199/rmiTest02");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Title.setCellValueFactory(new PropertyValueFactory<Tovar, String>("name"));
        Price.setCellValueFactory(new PropertyValueFactory<Tovar, Integer>("price"));
        Count.setCellValueFactory(new PropertyValueFactory<Tovar, Integer>("kol"));
        Table.setItems(products);

        getData();
    }

    private void getData()
    {
        try {
            fillTable(tovarOperation.getListOfTovar());
        }
        catch (Exception ex){
            System.out.println("АРБАЙТЕН НИГГЕР, СОЛНЦЕ ЕЩЁ ВЫСОКО");
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
