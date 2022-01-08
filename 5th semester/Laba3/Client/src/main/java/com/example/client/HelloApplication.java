package com.example.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import other.GuiScene;
import other.HttpManager;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.Console;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.http.HttpClient;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

import static other.GuiScene.*;

public class HelloApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AuthScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage = stage;
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();


    }

    public static void setScene(GuiScene newScene) throws IOException {
        Parent root = null;
        Scene scene;
        switch (newScene){
            case DEF: root = FXMLLoader.load(HelloApplication.class.getResource("DefaultScene.fxml"));
                break;
            case ADD: root = FXMLLoader.load(HelloApplication.class.getResource("AddScene.fxml"));
                break;
            case AUTH: root = FXMLLoader.load(HelloApplication.class.getResource("AuthScene.fxml"));
                break;
        }

        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}