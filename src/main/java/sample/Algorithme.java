// Importation package
package sample;

// Importations

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Classe ''algorithme''
public class Algorithme {

    // Méthode ''equation''
    public double equation(String equation) throws IllegalArgumentException {

        // Variable et initialisation

        String input;
        input = equation;

        boolean dernierSymbole = true; // Role: Vérifier si deux ''-'' sont consécutifs

        // Création des piles (Une pile de nombres et une pile d'opérateurs)

        Stack<Double> output = new Stack<>();
        Stack<Character> pileOperateurs = new Stack<>();

        // Création du StringBuilder responsable de la création des nombres
        StringBuilder buffer = new StringBuilder();

        // Création des pattern et leur matcher

        Pattern nombre = Pattern.compile("[0-9,.]");
        Pattern parentheses = Pattern.compile("[()]");
        Pattern operateurss = Pattern.compile("[-+*/^%]");

        Matcher matcherNombre;
        Matcher matcherParentheses;
        Matcher matcherOperateurs;

        // Boucle

        try {
            for (int i = 0; i < input.length(); i++) {

                // Variables

                Character character = input.charAt(i);

                boolean dernier = (i == (input.length() - 1)); //Role: Vérifier si le caractère est le dernier

                // Matchers

                matcherNombre = nombre.matcher(String.valueOf(character));
                matcherParentheses = parentheses.matcher(String.valueOf(character));
                matcherOperateurs = operateurss.matcher(String.valueOf(character));

                // Vérification

                if (character == '-' && dernierSymbole) { // Vérifie si deux ''-'' sont consécutifs
                    buffer.append(character);
                    dernierSymbole = false;
                } else if (matcherNombre.find()) { // Vérifie si c'est un nombre
                    buffer.append(character);
                    dernierSymbole = false;
                    if (dernier) {
                        output.push(Double.parseDouble(String.valueOf(buffer)));
                        buffer.delete(0, buffer.length());
                    }
                } else if (matcherOperateurs.find()) { // Vérifie si c'est un opérateur
                    dernierSymbole = true;
                    if (pileOperateurs.isEmpty()) { // Première fois que l'on rencontre un opérateur
                        pileOperateurs.push(character);
                        if (!buffer.toString().equals(""))
                            output.push(Double.parseDouble(String.valueOf(buffer)));
                        buffer.delete(0, buffer.length());
                    } else { // Ce n'est pas le premier opérateur
                        if (!buffer.toString().equals("")) {
                            output.push(Double.parseDouble(String.valueOf(buffer)));
                            buffer.delete(0, buffer.length());
                        }
                        if (priorite(character) < priorite(pileOperateurs.peek())) { // Cas 1: Priorité inférieure
                            double dessus = output.pop();
                            double dessous = output.pop();
                            calculer(dessous, dessus, pileOperateurs, output);
                            pileOperateurs.push(character);
                        } else if (priorite(character) > priorite(pileOperateurs.peek())) { // Cas 2: Priorité Supérieure
                            pileOperateurs.push(character);
                        } else if (priorite(character) == priorite(pileOperateurs.peek())) { // Cas 3: Priorité égale
                            double dessus = output.pop();
                            double dessous = output.pop();
                            calculer(dessous, dessus, pileOperateurs, output);
                            pileOperateurs.push(character);
                        }
                    }
                } else if (matcherParentheses.find()) { // Vérifie si c'est une parenthèse
                    if (character == '(') {
                        dernierSymbole = true;
                        pileOperateurs.push('(');
                        if (output.size() != 0) {
                            if (!buffer.toString().equals("")) {
                                output.push(Double.parseDouble(String.valueOf(buffer)));
                                buffer.delete(0, buffer.length());
                            }
                        }
                    } else if (character == ')') {
                        dernierSymbole = false;
                        if (!buffer.toString().equals("")) {
                            output.push(Double.parseDouble(String.valueOf(buffer)));
                            buffer.delete(0, buffer.length());
                        }
                        while (pileOperateurs.peek() != '(') {
                            double dessus = output.pop();
                            double dessous = output.pop();
                            calculer(dessous, dessus, pileOperateurs, output);
                        }
                        pileOperateurs.pop(); // Pour retirer la dernière parenthèse ouvrante de la pile
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        // Boucle les résultats intermédiaires

        try {
            while (pileOperateurs.size() != 0) {

                // Variables

                double resultat = 0.0;
                double dessus = Double.parseDouble(String.valueOf(output.pop()));
                double dessous = Double.parseDouble(String.valueOf(output.pop()));

                // Contrôle des symboles mathématiques

                switch (pileOperateurs.peek()) {
                    case '+':
                        resultat = dessous + dessus;
                        pileOperateurs.pop();
                        output.push(resultat);
                        break;
                    case '-':
                        resultat = dessous - dessus;
                        pileOperateurs.pop();
                        output.push(resultat);
                        break;
                    case '*':
                        resultat = dessous * dessus;
                        pileOperateurs.pop();
                        output.push(resultat);
                        break;
                    case '/':
                        resultat = dessous / dessus;
                        pileOperateurs.pop();
                        output.push(resultat);
                        break;
                    case '^':
                        resultat = Math.pow(dessous, dessus);
                        pileOperateurs.pop();
                        output.push(resultat);
                        break;
                    case '%':

                        // Variable
                        double n;

                        // Calcul du modulo

                        if (dessus < 0)
                            dessus = dessus * -1;
                        n = ((int) (dessous / dessus)) * dessus;
                        pileOperateurs.pop();

                        output.push(dessous - n);
                        break;
                }
            }
            return output.peek();

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    // Méthode ''Calculer''
    public void calculer(Double dessous, Double dessus, Stack<Character> pileOperateurs, Stack<Double> output) {
        switch (pileOperateurs.peek()) {
            case '+' -> {
                pileOperateurs.pop();
                output.push((dessous + dessus));
            }
            case '-' -> {
                pileOperateurs.pop();
                output.push((dessous - dessus));
            }

            case '*' -> {
                pileOperateurs.pop();
                output.push((dessous * dessus));
            }
            case '^' -> {
                pileOperateurs.pop();
                output.push((Math.pow(dessous, dessus)));
            }
            case '/' -> {
                pileOperateurs.pop();
                output.push(dessous / dessus);
            }
            case '%' -> {

                //Variable

                double n;

                // Calcul du modulo

                if (dessus < 0)
                    dessus = dessus * -1;
                n = ((int) (dessous / dessus)) * dessus;
                pileOperateurs.pop();

                output.push(dessous - n);
            }
        }
    }

    // Méthode ''priorite''
    public int priorite(Character operateur) {
        return switch (operateur) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^', '%' -> 3;
            case '(', ')' -> 0;
            default -> throw new IllegalArgumentException();
        };
    }
}