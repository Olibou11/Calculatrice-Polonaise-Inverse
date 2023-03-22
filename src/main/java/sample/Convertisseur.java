// Package
package sample;

public class Convertisseur {

    public static double convertisseur(String sorte, String gauche, String droit, double g) {

        return switch (sorte) {
            case "Angle" -> angle(gauche, droit, g);
            case "Aire" -> aire(gauche, droit, g);
            case "Longueur" -> longueur(gauche, droit, g);
            case "Masse" -> masse(gauche, droit, g);
            case "Pression" -> pression(gauche, droit, g);
            case "Devise" -> devise(gauche, droit, g);
            case "Temps" -> temps(gauche, droit, g);
            case "Température" -> temperature(gauche, droit, g);
            case "Vitesse" -> vitesse(gauche, droit, g);
            case "Volume" -> volume(gauche, droit, g);
            case "Énergie" -> energie(gauche, droit, g);
            default -> 0;
        };
    }

    private static double angle(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double degre = switch (gauche) {
                case "Degré" -> g;
                case "Radian" -> g * 180 / Math.PI;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Radian" -> degre * Math.PI / 180;
                case "Degré" -> degre;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double aire(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double mertreCarre = switch (gauche) {
                case "Kilomètre carré" -> g * Math.pow(10, 6);
                case "Pied carré" -> g / 10.764;
                case "Pouce carré" -> g / 1550;
                case "Mètre carré" -> g;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Kilomètre carré" -> mertreCarre / Math.pow(10, 6);
                case "Pied carré" -> mertreCarre * 10.764;
                case "Pouce carré" -> mertreCarre * 1550;
                case "Mètre carré" -> mertreCarre;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double longueur(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double metre = switch (gauche) {
                case "Kilomètre" -> g * 1000;
                case "Mètre" -> g;
                case "Centimètre" -> g / 100;
                case "Millimètre" -> g / 1000;
                case "Pied" -> g / 3.281;
                case "Pouce" -> g / 39.37;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Kilomètre" -> metre / 1000;
                case "Mètre" -> metre;
                case "Centimètre" -> metre * 100;
                case "Millimètre" -> metre * 1000;
                case "Pied" -> metre * 3.281;
                case "Pouce" -> metre * 39.37;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double masse(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double gramme = switch (gauche) {
                case "Kilogramme" -> g * 1000;
                case "Gramme" -> g;
                case "Livre" -> g / 454;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Gramme" -> gramme;
                case "Kilogramme" -> gramme / 1000;
                case "Livre" -> gramme * 454;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double pression(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double pascal = switch (gauche) {
                case "Atmosphère" -> g * 101325;
                case "Bar" -> g * 100000;
                case "Psi" -> g * 6895;
                case "Pascal" -> g;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Atmosphère" -> pascal / 101325;
                case "Bar" -> pascal / 100000;
                case "Psi" -> pascal / 6895;
                case "Pascal" -> pascal;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double devise(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double cad = switch (gauche) {
                case "Dollar canadien" -> g;
                case "Dollar américain" -> g * 1.28;
                case "Euro" -> g * 1.45;
                case "Pesos" -> g * 0.061;
                case "Yen" -> g * 0.011;
                case "Bolivar" -> g * 0.00000276223;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Dollar canadien" -> cad;
                case "Dollar américain" -> cad / 1.28;
                case "Euro" -> cad / 1.45;
                case "Pesos" -> cad / 0.061;
                case "Yen" -> cad / 0.011;
                case "Bolivar" -> cad / 0.00000276223;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double temps(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double seconde = switch (gauche) {
                case "Année" -> g * 31536000;
                case "Mois" -> g * 2628002.88;
                case "Semaine" -> g * 604800;
                case "Jour" -> g * 86400;
                case "Heure" -> g * 3600;
                case "Minute" -> g * 60;
                case "Seconde" -> g;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Année" -> seconde / 31536000;
                case "Mois" -> seconde / 2628002.88;
                case "Semaine" -> seconde / 604800;
                case "Jour" -> seconde / 86400;
                case "Heure" -> seconde / 3600;
                case "Minute" -> seconde / 60;
                case "Seconde" -> seconde;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double temperature(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double celsius = switch (gauche) {
                case "Degré celsius" -> g;
                case "Kelvin" -> g - 273.15;
                case "Degré fahrenheit" -> (g - 32) * 5 / 9;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Degré celsius" -> celsius;
                case "Kelvin" -> celsius + 273.15;
                case "Degré fahrenheit" -> (celsius * 9 / 5) + 32;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double vitesse(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double ms = switch (gauche) {
                case "Kilomètre par heure" -> g / 3.6;
                case "Mètre par seconde" -> g;
                case "Mille par heure" -> g * 0.44704;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Kilomètre par heure" -> ms * 3.6;
                case "Mètre par seconde" -> ms;
                case "Mille par heure" -> ms / 0.44704;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double volume(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double metreCube = switch (gauche) {
                case "Mètre cube" -> g;
                case "Centimètre cube" -> g / Math.pow(10, 6);
                case "Millimètre cube" -> g / Math.pow(10, 9);
                case "Kilolitre" -> g;
                case "Litre" -> g / 1000;
                case "Millilitre" -> g / Math.pow(10, 6);
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Mètre cube" -> metreCube;
                case "Centimètre cube" -> metreCube * Math.pow(10, 6);
                case "Millimètre cube" -> metreCube * Math.pow(10, 9);
                case "Kilolitre" -> metreCube;
                case "Litre" -> metreCube * 1000;
                case "Millilitre" -> metreCube * Math.pow(10, 6);
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }

    private static double energie(String gauche, String droit, double g) {

        if (gauche.length() != 0) {
            // Valeur de référence
            double joule = switch (gauche) {
                case "Calorie" -> g * 4184;
                case "Watt-heure" -> g * 3600;
                case "Kilowatt-heure" -> g * 3.6 * Math.pow(10, 6);
                case "ÉlectronVolt" -> g / (6.242 * Math.pow(10, 18));
                case "Joule" -> g;
                default -> 0;
            };

            // Conversion
            return switch (droit) {
                case "Calorie" -> joule / 4184;
                case "Watt-heure" -> joule / 3600;
                case "Kilowatt-heure" -> joule / (3.6 * Math.pow(10, 6));
                case "ÉlectronVolt" -> joule * (6.242 * Math.pow(10, 18));
                case "Joule" -> joule;
                default -> 0;
            };
        } else
            throw new IllegalArgumentException();
    }
}