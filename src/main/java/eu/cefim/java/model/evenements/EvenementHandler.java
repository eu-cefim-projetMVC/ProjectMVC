package eu.cefim.java.model.evenements;


import eu.cefim.java.model.AccesBdd;
import eu.cefim.java.model.organisateurs.Organisateur;
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

public class EvenementHandler extends BeanListHandler<Evenement> {

    public EvenementHandler(){
        super(Evenement.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
    }

    @Override
    public List<Evenement> handle(ResultSet rs) throws SQLException {
        List<Evenement> evenements = super.handle(rs);

        QueryRunner runner = new QueryRunner();
        BeanHandler<Organisateur> handler = new BeanHandler<>(Organisateur.class);
        String query = "SELECT * FROM organisateur WHERE id = ? LIMIT 1";

        for (Evenement evenement : evenements) {
            Connection con = AccesBdd.getConnection();
            Organisateur organisateur = runner.query(con, query, handler, evenement.getOrganisateurId());
            evenement.setOrganisateur(organisateur);
        }
        return evenements;
    }

    public static Map<String, String> mapColumnsToFields() {

        Map<String, String> columnsToFieldsMap = new HashMap<>();

        columnsToFieldsMap.put("organisateur_id", "organisateurId");
        columnsToFieldsMap.put("date_evenement", "dateEvenement");

        return columnsToFieldsMap;
    }
}
