package eu.cefim.java.vue.categorieBillet;

import javax.swing.*;
import java.awt.*;

public class CategorieBilletVue extends JFrame{
    JTable listeCategorie = new JTable();

    public CategorieBilletVue() {
        setTitle("Accueil Organisateur");
        setMinimumSize(new Dimension(312, 387));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        defineLayout();
    }

    public void defineLayout(){
        JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addGroup(gl.createSequentialGroup()
                        .addComponent(listeCategorie)
                )
        );
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(listeCategorie)
                )
        );

        pack();
    }
}
