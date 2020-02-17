package eu.cefim.java.vue.organisateurs;

import eu.cefim.java.model.evenements.Evenement;
import eu.cefim.java.model.organisateurs.Organisateur;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.Array;
import java.util.List;

public class OrganisateurHome extends JFrame {

    public JLabel mailLabel;
    public JLabel idLabel;
    public JLabel typeCompteLabel;
    public JLabel mailParrainLabel;
    public JScrollPane scroll;

    public OrganisateurHome(Organisateur organisateur) {
        setTitle("Accueil Organisateur");
        setMinimumSize(new Dimension(312, 387));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        scroll = new JScrollPane() ;
        mailLabel = new JLabel(organisateur.getMail());
        mailLabel.setText("Bonjour " + organisateur.getMail());

        idLabel = new JLabel(String.valueOf(organisateur.getId()));
        idLabel.setText("id : " + organisateur.getId());

        typeCompteLabel = new JLabel("type du compte : " + organisateur.getTypeCompte().getNom());

        mailParrainLabel = new JLabel();
        if (organisateur.getParrainMail() != null) {
            mailParrainLabel.setText("mail parrain : " + organisateur.getParrainMail().getMail());
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
                .addGroup(gl.createSequentialGroup()
                    .addComponent(scroll))
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
                .addGroup(gl.createParallelGroup()
                        .addComponent(scroll)
                )
        );

        pack();
    }
}
