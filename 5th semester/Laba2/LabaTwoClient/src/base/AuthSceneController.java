package base;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.endpoint.TovarServiceService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AuthSceneController implements Initializable {
    private TovarServiceService tovarOperation;
    public TextField Password;
    public TextField Login;
    public Label Error;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tovarOperation = new TovarServiceService();

    }

    public void OnAuth(ActionEvent actionEvent) throws IOException {
        if (tovarOperation.getTovarServicePort().authentication(Login.getText(), Password.getText())) {
            Form.setScene(GuiScene.DEF);
        } else {
            Error.setText("Неправильный логин или пароль");
        }
    }
}
