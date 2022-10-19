package com.example.workbotspidev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.AgentCRUD;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AgentCRUD a=new AgentCRUD();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin_interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
        System.out.println(a.AfficherAgent());
    }

    public static void main(String[] args) {
        launch();
    }
}