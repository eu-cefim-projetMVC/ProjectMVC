package eu.cefim.java.vue.categorieBillet;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class CategorieBilletVue extends JFrame{

    public JScrollPane scroll;

    public CategorieBilletVue() {
        setTitle("Accueil Organisateur");
        setMinimumSize(new Dimension(312, 387));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable table = new JTable();

        scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scroll);

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
                        .addComponent(scroll)
                )
        );
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(scroll)
                )
        );

        pack();
    }
}
