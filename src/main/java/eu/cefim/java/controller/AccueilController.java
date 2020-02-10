package eu.cefim.java.controller;

import eu.cefim.java.model.organisateurs.Organisateur;
import eu.cefim.java.vue.organisateurs.OrganisateurHome;

import javax.swing.*;

public class AccueilController {
    public static void start(Organisateur organisateur) {
        SwingUtilities.invokeLater(() -> {
            OrganisateurHome organisateurHome = new OrganisateurHome(organisateur);
            organisateurHome.setVisible(true);

            }
        );
    }
}
