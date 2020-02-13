package eu.cefim.java.controller;

import eu.cefim.java.model.evenements.Evenement;
import eu.cefim.java.model.organisateurs.Organisateur;
import eu.cefim.java.vue.organisateurs.OrganisateurHome;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

public class AccueilController {
    public static void start(Organisateur organisateur) {
        SwingUtilities.invokeLater(() -> {
                    OrganisateurHome organisateurHome = new OrganisateurHome(organisateur);
                    organisateurHome.setVisible(true);
                    JTable monTable = new JTable(new MonTableModel(organisateur.getEvenements()));
                    organisateurHome.scroll.getViewport().add(monTable);
                    organisateurHome.pack();


                }
        );
    }
}

class MonTableModel extends AbstractTableModel {

    public MonTableModel(List<Evenement> evenements) {
        int tailleTab = evenements.size();
        data = new Object[tailleTab][columnNames.length];
        int i;
        for (i = 0; i < tailleTab; i++) {
            data[i][0] = evenements.get(i).getNom();
            data[i][1] = evenements.get(i).getDateEvenement();
            data[i][2] = evenements.get(i).getNbBilletsMax();
            data[i][3] = evenements.get(i).getNbBilletsVendus();
            data[i][4] = evenements.get(i).getNbBilletsPanier();
        }



    }

    private String[] columnNames = {
            "Nom",
            "Date et Heure",
            "nb billets max",
            "nb billets vendus",
            "nb billets en panier"

    };
    private Boolean[] editable = {
            true,
            true,
            false,
            false,
            false
    };
    Object[][] data;

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return getValueAt(0, columnIndex).getClass();
//    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // déclenchement du code SQL ici
        // + validation des données (ex : pas d'âge négatif, etc)
        // si ok :
        data[rowIndex][columnIndex] = aValue;
    }

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy 'à' hh:mm:ss");

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {


        if (data[rowIndex][columnIndex] instanceof Date) {
            return simpleDateFormat.format(data[rowIndex][columnIndex]);
        }
        return data[rowIndex][columnIndex];
    }
}

