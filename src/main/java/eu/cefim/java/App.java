package eu.cefim.java;


import eu.cefim.java.controller.ConnectionController;
import eu.cefim.java.controller.administrateurs.BilletQrCodeController;
import eu.cefim.java.controller.categoriesBillet.CategoriesBilletController;
import eu.cefim.java.model.categorieBillet.CategorieBillet;
import eu.cefim.java.vue.administrateurs.WindowQrCodeBillet;
import eu.cefim.java.vue.categorieBillet.CategorieBilletVue;
import eu.cefim.java.vue.organisateurs.WindowConnexion;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
//        ConnectionController.start();
//        BilletQrCodeController.start();
        CategoriesBilletController.start();
    }
}
