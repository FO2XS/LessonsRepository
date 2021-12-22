package base;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import operation.TovarOperation;
import types.Tovar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class AddSceneController implements Initializable {
    private TovarOperation tovarOperation;
    public TextField Title;
    public TextField Price;
    public TextField Count;

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
    }

    public void OnAdd(ActionEvent actionEvent) throws RemoteException {
        Tovar tovar = new Tovar(Title.getText(),
                Integer.parseInt(Count.getText()),
                Integer.parseInt(Price.getText()));

        tovarOperation.addNewTovar(tovar);
    }

    public void OnCancel(ActionEvent actionEvent) throws IOException {
        Form.setScene(GuiScene.DEF);
    }
}
