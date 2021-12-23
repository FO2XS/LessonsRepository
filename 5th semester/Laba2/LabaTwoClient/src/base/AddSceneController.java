package base;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import service.endpoint.TovarServiceService;
import types.Tovar;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class AddSceneController implements Initializable {
    private TovarServiceService tovarService;
    public TextField Title;
    public TextField Price;
    public TextField Count;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tovarService = new TovarServiceService();
    }

    public void OnAdd(ActionEvent actionEvent) throws RemoteException {
        Tovar tovar = new Tovar();

        tovar.setName(Title.getText());
        tovar.setPrice(Integer.parseInt(Price.getText()));
        tovar.setKol(Integer.parseInt(Count.getText()));

        tovarService.getTovarServicePort().setNewTovar(tovar);
    }

    public void OnCancel(ActionEvent actionEvent) throws IOException {
        Form.setScene(GuiScene.DEF);
    }
}
