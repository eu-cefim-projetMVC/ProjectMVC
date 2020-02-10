package eu.cefim.java.model.organisateurs;

import eu.cefim.java.model.AccesBdd;
import eu.cefim.java.model.evenements.Evenement;
import eu.cefim.java.model.typeCompte.TypeCompte;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganisateurHandler extends BeanListHandler<Organisateur> {

    public OrganisateurHandler(){
        super(Organisateur.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
    }

    @Override
    public List<Organisateur> handle(ResultSet rs) throws SQLException {
        List<Organisateur> organisateurs = super.handle(rs);

        QueryRunner runner = new QueryRunner();
        BeanHandler<TypeCompte> handler = new BeanHandler<>(TypeCompte.class);
        String query = "SELECT * FROM type_compte WHERE nom = ?";

        for (Organisateur organisateur : organisateurs) {
            TypeCompte typeCompte = runner.query(AccesBdd.getConnection(), query, handler, organisateur.getParrainId());
            organisateur.setTypeCompte(typeCompte);
        }
        return organisateurs;
    }

    public static Map<String, String> mapColumnsToFields() {

        Map<String, String> columnsToFieldsMap = new HashMap<>();

        columnsToFieldsMap.put("type_compte_id", "typeCompteId");
        columnsToFieldsMap.put("parrain_id", "parrainId");
        columnsToFieldsMap.put("date_derniere_connexion", "dateDerniereConnexion");

        return columnsToFieldsMap;
    }
}
