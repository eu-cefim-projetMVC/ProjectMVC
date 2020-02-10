package eu.cefim.java.vue.organisateurs;

import eu.cefim.java.model.organisateurs.Organisateur;

import javax.swing.*;
import java.awt.*;

public class OrganisateurHome extends JFrame {

    public JLabel mailLabel;
    public JLabel idLabel;
    public JLabel typeCompteLabel;
    public JLabel mailParrainLabel;

    public OrganisateurHome(Organisateur organisateur) {
        setTitle("Accueil Organisateur");
        setMinimumSize(new Dimension(312, 387));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mailLabel = new JLabel(organisateur.getMail());
        mailLabel.setText("Bonjour " + organisateur.getMail());

        idLabel = new JLabel(String.valueOf(organisateur.getId()));
        idLabel.setText("id : " + organisateur.getId());

        typeCompteLabel = new JLabel("type du compte : " + organisateur.getTypeCompte());

        mailParrainLabel = new JLabel();
        if (organisateur.getParrainMail() != null)
        {
            mailParrainLabel.setText("mail parrain :" + organisateur.getParrainMail());
        } else {
            mailParrainLabel.setText("Pas de parrain");
        }

        defineLayout();
    }

    private void defineLayout() {
        JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                        .addComponent(mailLabel)
                )
                .addGroup(gl.createSequentialGroup()
                        .addComponent(idLabel)
                )
                .addGroup(gl.createSequentialGroup()
                        .addComponent(typeCompteLabel)
                )
                .addGroup(gl.createSequentialGroup()
                        .addComponent(mailParrainLabel)
                )
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(mailLabel)
                )
                .addGroup(gl.createParallelGroup()
                        .addComponent(idLabel)
                )
                .addGroup(gl.createParallelGroup()
                        .addComponent(typeCompteLabel)
                )
                .addGroup(gl.createParallelGroup()
                        .addComponent(mailParrainLabel)
                )
        );

        pack();
    }
}
