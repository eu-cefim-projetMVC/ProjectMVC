package eu.cefim.java.model.categorieBillet;

import eu.cefim.java.model.AccesBdd;
import eu.cefim.java.model.organisateurs.Organisateur;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CategorieBilletQuery extends BeanHandler<CategorieBillet> {

    public CategorieBilletQuery(){
        super(CategorieBillet.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
    }

    public static void persist(CategorieBillet categorieBillet) throws SQLException {

        if(categorieBillet.getId() == 0){

            ScalarHandler<BigInteger> scalarHandler = new ScalarHandler<>();
            QueryRunner runner = new QueryRunner();

            String query = "INSERT INTO categorie_billet (evenement_id, nom, prix, nombre_places) VALUES (?, ?, ?, ?)";
            int newId = runner.insert(AccesBdd.getConnection(), query, scalarHandler, categorieBillet.getEvenementId(),
                                    categorieBillet.getNom(), categorieBillet.getPrix(), categorieBillet.getNombrePlaces()).intValue();

            // Après insertion il faut stocker l'id auto incrémenté par MuSQL dans notre instance client
            categorieBillet.setId(newId);

        } else {

            QueryRunner runner = new QueryRunner();
            String query = "UPDATE categorie_billet SET nom = ?, prix = ?, nombre_places = ?";
            runner.update(AccesBdd.getConnection(), query, categorieBillet.getNom(), categorieBillet.getPrix(), categorieBillet.getNombrePlaces());

        }
    }

    public static Map<String, String> mapColumnsToFields() {

        Map<String, String> columnsToFieldsMap = new HashMap<>();

        columnsToFieldsMap.put("nombre_places", "nombrePlaces");
        columnsToFieldsMap.put("evenement_id", "evenementId");

        return columnsToFieldsMap;
    }
}
