// Package et importation
package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ControllerStandard {

    // Déclaration de l'algorithme
    Algorithme algorithme = new Algorithme();

    // Déclaration de l'entrée et de l'entrée en mémoire
    public String entree = "";
    public String memoireEntree = "";
    public double memoire;

    // Déclaration des éléments graphiques
    @FXML
    private Label label;
    @FXML
    private Label memoireTexte;
    @FXML
    private TextField textField;
    @FXML
    private ListView<String> liste;

    // Action des boutons
    @FXML
    private void bouton0() {
        entree = entree + 0;
        textField.setText(entree);
    }

    @FXML
    private void bouton1() {
        entree = entree + 1;
        textField.setText(entree);
    }

    @FXML
    private void bouton2() {
        entree = entree + 2;
        textField.setText(entree);
    }

    @FXML
    private void bouton3() {
        entree = entree + 3;
        textField.setText(entree);
    }

    @FXML
    private void bouton4() {
        entree = entree + 4;
        textField.setText(entree);
    }

    @FXML
    private void bouton5() {
        entree = entree + 5;
        textField.setText(entree);
    }

    @FXML
    private void bouton6() {
        entree = entree + 6;
        textField.setText(entree);
    }

    @FXML
    private void bouton7() {
        entree = entree + 7;
        textField.setText(entree);
    }

    @FXML
    private void bouton8() {
        entree = entree + 8;
        textField.setText(entree);
    }

    @FXML
    private void bouton9() {
        entree = entree + 9;
        textField.setText(entree);
    }

    @FXML
    private void signe() {
        if (entree.length() != 0) {
            if (entree.charAt(0) == '-')
                entree = entree.substring(1);
            else
                entree = "-" + entree;
            textField.setText(entree);
        }
    }

    @FXML
    private void virgule() {
        entree = entree + ".";
        textField.setText(entree);
    }

    // Action des opérateurs
    @FXML
    private void division() {
        memoireEntree = memoireEntree + entree + "/";
        entree = "";
        textField.setText(entree);
        label.setText(memoireEntree);
    }

    @FXML
    private void multiplication() {
        memoireEntree = memoireEntree + entree + "*";
        entree = "";
        textField.setText(entree);
        label.setText(memoireEntree);
    }

    @FXML
    private void soustraction() {
        memoireEntree = memoireEntree + entree + "-";
        entree = "";
        textField.setText(entree);
        label.setText(memoireEntree);
    }

    @FXML
    private void addition() {
        memoireEntree = memoireEntree + entree + "+";
        entree = "";
        textField.setText(entree);
        label.setText(memoireEntree);
    }

    @FXML
    private void eguale() {
        String equation = memoireEntree + textField.getText();
        try {
            String reponse = equation + "=" + Decimal.decimal(algorithme.equation(equation));
            liste.getItems().add(reponse);
            memoireEntree = "";
            entree = "";
            textField.setText(entree);
            label.setText(memoireEntree);
        } catch (IllegalArgumentException e) {
            memoireEntree = "";
            entree = "";
            textField.setText("Erreur");
            label.setText(memoireEntree);
        }
    }

    // Action des opérateurs particuliers
    @FXML
    private void memoire() {
        entree = entree + memoire;
        textField.setText(entree);
    }

    @FXML
    private void memoirePlus() {
        memoire = Double.parseDouble(entree);
        memoireTexte.setText("Mémoire : " + entree);
    }

    @FXML
    private void racine() {
        entree = entree + "^(1/2)";
        textField.setText(entree);
    }

    @FXML
    private void carree() {
        entree = entree + "^2";
        textField.setText(entree);
    }

    @FXML
    private void fraction() {
        entree = "1/" + entree;
        textField.setText(entree);
    }

    @FXML
    private void effacer() {
        if (entree.length() != 0) {
            entree = entree.substring(0, entree.length() - 1);
            textField.setText(entree);
        }
    }

    @FXML
    private void toutEffacer() {
        entree = "";
        textField.setText(entree);
    }

    // Changement de type de calculatrice
    @FXML
    private void standard() {
    } // Ne fait rien car déjà dans la bonne calculatrice

    @FXML
    private void scientifique() throws IOException {
        Main.setStage(new Scene(FXMLLoader.load(getClass().getResource("scientifique.fxml"))));
    }

    @FXML
    private void conversion() throws IOException {
        Main.setStage(new Scene(FXMLLoader.load(getClass().getResource("conversion.fxml"))));
    }
}