package eu.cefim.java.controller;

import eu.cefim.java.model.evenements.Evenement;
import eu.cefim.java.model.organisateurs.Organisateur;
import eu.cefim.java.model.organisateurs.OrganisateurQuery;
import eu.cefim.java.vue.organisateurs.WindowConnexion;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ConnectionController {
    public static void start() {
        SwingUtilities.invokeLater(() -> {

            WindowConnexion windowConnexion = new WindowConnexion();
            windowConnexion.setVisible(true);
            windowConnexion.loginButton.addActionListener(e -> {

                Thread monThread = new Thread(() -> {
                    try {
                        String mail = windowConnexion.mailTextField.getText();
                        String pass = new String(windowConnexion.passwordPasswordField.getPassword());
                        if (!mail.equals("") && !pass.equals("")) {

                           Organisateur organisateur = OrganisateurQuery.findOne(mail);
                           if (organisateur != null && pass.equals(organisateur.getPassword())) {

                               JOptionPane.showMessageDialog(windowConnexion, "Connexion réussie !");
                               windowConnexion.setVisible(false);
                               AccueilController.start(organisateur);

                           }
                           else {
                               JOptionPane.showMessageDialog(windowConnexion, "Identifiants incorrects !");

                           }
                        }
                        else {
                            JOptionPane.showMessageDialog(windowConnexion, "Veuillez remplir tous les champs !");
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(windowConnexion, "Identifiants incorrects !");
                        e1.printStackTrace();
                    }
                });
                monThread.start();
            });
        });
    }
}




