package eu.cefim.java.vue.organisateurs;

import javax.swing.*;
import java.awt.*;

public class OrganisateurHome extends JFrame {

    JLabel organisateurLabel;

    public OrganisateurHome() {
        organisateurLabel = new JLabel();

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
                        .addComponent(organisateurLabel)
                )
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(organisateurLabel)
                )
        );

        pack();
    }
}
