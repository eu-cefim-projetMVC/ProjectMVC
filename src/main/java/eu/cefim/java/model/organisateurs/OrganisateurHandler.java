package eu.cefim.java.model.organisateurs;

import eu.cefim.java.model.AccesBdd;
import eu.cefim.java.model.evenements.Evenement;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganisateurHandler extends BeanHandler<Organisateur> {

        public OrganisateurHandler(){
            super(Organisateur.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
        }

        @Override
        public Organisateur handle(ResultSet rs) throws SQLException {
            Organisateur organisateur = super.handle(rs);

            QueryRunner runner = new QueryRunner();
            BeanListHandler<Evenement> handler = new BeanListHandler<>(Evenement.class);
            String query = "SELECT * FROM evenement WHERE organisateur_id = ? ";

            List<Evenement> evenements = runner.query(AccesBdd.getConnection(), query, handler, organisateur.getId());
            organisateur.setEvenements(evenements);

            return organisateur;
        }

        public static Map<String, String> mapColumnsToFields() {

            Map<String, String> columnsToFieldsMap = new HashMap<>();

            columnsToFieldsMap.put("organisateur_id", "organisateurId");

            return columnsToFieldsMap;
        }
}

