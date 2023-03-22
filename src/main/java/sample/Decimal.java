// Package et importation
package sample;

import java.text.DecimalFormat;

public class Decimal {

    public static String decimal(double nbr) {

        // Déclaration des variables
        DecimalFormat df = new DecimalFormat("0.00000");

        // Autre

        // Zéro
        if (nbr == 0)
            return "0";
        // Infini
        if (nbr == Double.POSITIVE_INFINITY || nbr == Double.NEGATIVE_INFINITY)
            return "" + nbr;

        // Grand

        // Yotta (Y)
        if (Math.abs(nbr) >= Math.pow(10, 24)) {
            nbr /= Math.pow(10, 24);
            return df.format(nbr) + " *10^24";
        }
        // Zetta (Z)
        if (Math.abs(nbr) >= Math.pow(10, 21) && Math.abs(nbr) < Math.pow(10, 24)) {
            nbr /= Math.pow(10, 21);
            return df.format(nbr) + " *10^21";
        }
        // Exa (E)
        if (Math.abs(nbr) >= Math.pow(10, 18) && Math.abs(nbr) < Math.pow(10, 21)) {
            nbr /= Math.pow(10, 18);
            return df.format(nbr) + " *10^18";
        }
        // Peta (P)
        if (Math.abs(nbr) >= Math.pow(10, 15) && Math.abs(nbr) < Math.pow(10, 18)) {
            nbr /= Math.pow(10, 15);
            return df.format(nbr) + " *10^15";
        }
        // Tetra (T)
        if (Math.abs(nbr) >= Math.pow(10, 12) && Math.abs(nbr) < Math.pow(10, 15)) {
            nbr /= Math.pow(10, 12);
            return df.format(nbr) + " *10^12";
        }
        // Giga (G)
        if (Math.abs(nbr) >= Math.pow(10, 9) && Math.abs(nbr) < Math.pow(10, 12)) {
            nbr /= Math.pow(10, 9);
            return df.format(nbr) + " *10^9";
        }
        // Méga (M)
        if (Math.abs(nbr) >= Math.pow(10, 6) && Math.abs(nbr) < Math.pow(10, 9)) {
            nbr /= Math.pow(10, 6);
            return df.format(nbr) + " *10^6";
        }

        // Rien
        if (Math.abs(nbr) > Math.pow(10, -3) && Math.abs(nbr) < Math.pow(10, 3))
            return df.format(nbr) + "";

        // Petit

        // Micro (μ)
        if (Math.abs(nbr) <= Math.pow(10, -6) && Math.abs(nbr) > Math.pow(10, -9)) {
            nbr /= Math.pow(10, -6);
            return df.format(nbr) + " *10^-6";
        }
        // Nano (n)
        if (Math.abs(nbr) <= Math.pow(10, -9) && Math.abs(nbr) > Math.pow(10, -12)) {
            nbr /= Math.pow(10, -9);
            return df.format(nbr) + " *10^-9";
        }
        // Pico (p)
        if (Math.abs(nbr) <= Math.pow(10, -12) && Math.abs(nbr) > Math.pow(10, -15)) {
            nbr /= Math.pow(10, -12);
            return df.format(nbr) + " *10^-12";
        }
        // Femto (f)
        if (Math.abs(nbr) <= Math.pow(10, -15) && Math.abs(nbr) > Math.pow(10, -18)) {
            nbr /= Math.pow(10, -15);
            return df.format(nbr) + " *10^-15";
        }
        // Atto (a)
        if (Math.abs(nbr) <= Math.pow(10, -18) && Math.abs(nbr) > Math.pow(10, -21)) {
            nbr /= Math.pow(10, -18);
            return df.format(nbr) + " *10^-18";
        }
        // Zepto (z)
        if (Math.abs(nbr) <= Math.pow(10, -21) && Math.abs(nbr) > Math.pow(10, -24)) {
            nbr /= Math.pow(10, -21);
            return df.format(nbr) + " *10^-21";
        }
        // Yocto (y)
        if (Math.abs(nbr) <= Math.pow(10, -24)) {
            nbr /= Math.pow(10, -24);
            return nbr + " *10^-24";
        }

        // Erreur
        return "" + nbr;
    }
}