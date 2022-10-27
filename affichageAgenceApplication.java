package com.example.newagence;

import com.example.newagence.utils.MyConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


    public class affichageAgenceApplication extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            MyConnection conn= new MyConnection();

            FXMLLoader fxmlLoader = new FXMLLoader(com.example.newagence.ajoutAgenceApplication.class.getResource("affichageAgence.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }

