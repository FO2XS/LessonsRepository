package base;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import operation.TovarOperation;
import types.Tovar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class AuthSceneController implements Initializable {
    private TovarOperation tovarOperation;
    public TextField Password;
    public TextField Login;
    public Label Error;

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

    public void OnAuth(ActionEvent actionEvent) throws IOException {
        if(tovarOperation.authentication(Login.getText(), Password.getText())){
            Form.setScene(GuiScene.DEF);
        }
        else {
            Error.setText("Неправильный логин или пароль");
        }
    }
}
