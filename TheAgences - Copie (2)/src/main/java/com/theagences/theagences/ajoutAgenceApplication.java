package com.theagences.theagences;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ajoutAgenceApplication extends Application {
    public ajoutAgenceApplication() {
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ajoutAgenceApplication.class.getResource("ajoutAgence.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800,500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}