package eu.cefim.java.vue;

import eu.cefim.java.model.categorieBillet.CategorieBillet;
import eu.cefim.java.model.categorieBillet.CategorieBilletQuery;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.List;

public class TypeModelTable extends AbstractTableModel {

    private List<CategorieBillet> categoriesBillet;

    private String[] columnNames = {
            "ID",
            "Nom",
            "NombrePlaces",
            "Prix"
    };

    private Boolean[] editable = {
            false,
            true,
            true,
            true
    };

    private Class<?>[] type = {
            Integer.class,
            String.class,
            Integer.class,
            Double.class
    };

    private Object[][] data;

    public TypeModelTable(List<CategorieBillet> categoriesBillet) {
        this.categoriesBillet = categoriesBillet;
        data = new Object[categoriesBillet.size()][columnNames.length];
        for (int i = 0; i < categoriesBillet.size(); i++) {
            data[i][0] = categoriesBillet.get(i).getId();
            data[i][1] = categoriesBillet.get(i).getNom();
            data[i][2] = categoriesBillet.get(i).getNombrePlaces();
            data[i][3] = categoriesBillet.get(i).getPrix();
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return type[columnIndex];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        CategorieBillet categorieBillet = categoriesBillet.get(rowIndex);
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);

        switch (columnIndex){
            case 1:
                categorieBillet.setNom((String) aValue);
                break;
            case 2:
                categorieBillet.setNombrePlaces((int) aValue);
                break;
            case 3:
                categorieBillet.setPrix((double) aValue);
        }
        try {
            CategorieBilletQuery.persist(categorieBillet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
