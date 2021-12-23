package base;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Form extends Application {

    private static Stage primaryStage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        setScene(GuiScene.DEF);
    }

    public static void setScene(GuiScene newScene) throws IOException {
        Parent root = null;
        Scene scene;
        switch (newScene){
            case DEF: root = FXMLLoader.load(Form.class.getResource("DefaultScene.fxml"));
            break;
            case ADD: root = FXMLLoader.load(Form.class.getResource("AddScene.fxml"));
            break;
        }

        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
