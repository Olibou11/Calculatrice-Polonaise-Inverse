// Package et importation
package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.regex.Pattern;

public class ControllerConversion {

    // Déclaration des éléments graphiques
    @FXML
    public MenuButton menuButton;
    @FXML
    public ChoiceBox<String> choiceBoxGauche;
    @FXML
    public TextField textFieldGauche;
    @FXML
    public ChoiceBox<String> choiceBoxDroite;
    @FXML
    public TextField textFieldDroit;
    @FXML
    public Button conversionButton;

    // Action des boutons
    @FXML
    private void listeAireClique() {
        menuButton.setText("Aire");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Kilomètre carré",
                "Mètre carré",
                "Pied carré",
                "Pouce carré");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Kilomètre carré",
                "Mètre carré",
                "Pied carré",
                "Pouce carré");
    }

    public void listeAngleClique() {
        menuButton.setText("Angle");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Degré",
                "Radian");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Degré",
                "Radian");
    }

    public void listeLongueurClique() {
        menuButton.setText("Longueur");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Kilomètre",
                "Mètre",
                "Centimètre",
                "Millimètre",
                "Pied",
                "Pouce");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Kilomètre",
                "Mètre",
                "Centimètre",
                "Millimètre",
                "Pied",
                "Pouce");
    }

    public void listeMasseClique() {
        menuButton.setText("Masse");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Kilogramme",
                "Gramme",
                "Milligramme");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Kilogramme",
                "Gramme",
                "Milligramme");
    }

    public void listePressionClique() {
        menuButton.setText("Pression");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Atmosphère",
                "Bar",
                "Pascal",
                "Psi");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Atmosphère",
                "Bar",
                "Pascal",
                "Psi");
    }

    public void listeDeviseClique() {
        menuButton.setText("Devise");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Dollar canadien",
                "Dollar américain",
                "Euro",
                "Pesos",
                "Yen",
                "Bolivar");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Dollar canadien",
                "Dollar américain",
                "Euro",
                "Pesos",
                "Yen",
                "Bolivar");
    }

    public void listeTempsClique() {
        menuButton.setText("Temps");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Seconde",
                "Minute",
                "Heure",
                "Jour",
                "Semaine",
                "Mois",
                "Année");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Seconde",
                "Minute",
                "Heure",
                "Jour",
                "Semaine",
                "Mois",
                "Année");
    }

    public void listeTemperatureClique() {
        menuButton.setText("Température");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Degré celsius",
                "Degré fahrenheit",
                "Kelvin");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Degré celsius",
                "Degré fahrenheit",
                "Kelvin");
    }

    public void listeVitesseClique() {
        menuButton.setText("Vitesse");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Mètre par seconde",
                "Kilomètre par heure",
                "Mille par heure");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Mètre par seconde",
                "Kilomètre par heure",
                "Mille par heure");
    }

    public void listeVolumeClique() {
        menuButton.setText("Volume");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Mètre cube",
                "Centimètre cube",
                "Millimètre cube",
                "Kilolitre",
                "Litre",
                "Millilitre");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Mètre cube",
                "Centimètre cube",
                "Millimètre cube",
                "Kilolitre",
                "Litre",
                "Millilitre");
    }


    public void listeEnergieClique() {
        menuButton.setText("Énergie");

        choiceBoxGauche.getItems().clear();
        choiceBoxGauche.getItems().addAll("Joule",
                "Calorie",
                "Watt-heure",
                "Kilowatt-heure",
                "ÉlectronVolt");

        choiceBoxDroite.getItems().clear();
        choiceBoxDroite.getItems().addAll("Joule",
                "Calorie",
                "Watt-heure",
                "Kilowatt-heure",
                "ÉlectronVolt");
    }

    @FXML
    public void conversionClique() {

        try {
            if (textFieldGauche.getText().length() != 0) {
                Pattern regexNombre = Pattern.compile("^[0-9.]*$", Pattern.CASE_INSENSITIVE);

                if (regexNombre.matcher(String.valueOf(textFieldGauche.getText())).find()) {
                    textFieldDroit.setText(String.valueOf(Convertisseur.convertisseur(menuButton.getText(),
                            choiceBoxGauche.getValue(),
                            choiceBoxDroite.getValue(),
                            Double.parseDouble(textFieldGauche.getText()))));
                } else
                    throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Impossible de déchiffrer le nombre entré");
            alert.setTitle("Erreur");
            alert.setContentText("Réessayer en ne rentrant que des chiffres en remplaçant la virgule par un point");
            alert.show();
        }
    }

    // Changement de type de calculatrice
    @FXML
    private void standard() throws IOException {
        Main.setStage(new Scene(FXMLLoader.load(getClass().getResource("standard.fxml"))));
    }

    @FXML
    private void scientifique() throws IOException {
        Main.setStage(new Scene(FXMLLoader.load(getClass().getResource("scientifique.fxml"))));
    }

    @FXML
    private void conversion() {
    } // Ne fait rien car déjà dans la bonne calculatrice
}