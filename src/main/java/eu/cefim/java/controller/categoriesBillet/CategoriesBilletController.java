package eu.cefim.java.controller.categoriesBillet;

import eu.cefim.java.model.categorieBillet.CategorieBillet;
import eu.cefim.java.model.categorieBillet.CategorieBilletQuery;
import eu.cefim.java.vue.TypeModelTable;
import eu.cefim.java.vue.categorieBillet.CategorieBilletVue;
import eu.cefim.java.vue.organisateurs.WindowConnexion;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class CategoriesBilletController {

    public static void start() {
        SwingUtilities.invokeLater(() -> {

            CategorieBilletVue categorieBilletVue = new CategorieBilletVue();

            List<CategorieBillet> categoriesBillet = null;
            try {
                categoriesBillet = CategorieBilletQuery.find();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JTable table = new JTable(new TypeModelTable(categoriesBillet));
            categorieBilletVue.scroll.getViewport().add(table);
            categorieBilletVue.pack();
            categorieBilletVue.setVisible(true);
        });
    }
}
