// Package et importation
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;

    public static void setStage(Scene scene) {
        stage.setScene(scene);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        // Définition de la fenêtre
        Parent standard = FXMLLoader.load(getClass().getResource("standard.fxml"));
        stage = primaryStage;
        stage.setTitle("Calculatrice");
        stage.setFullScreen(false);
        Scene scene = new Scene(standard);

        // Affichage de la fenêtre
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}