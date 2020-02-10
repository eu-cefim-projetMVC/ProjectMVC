package eu.cefim.java.model.evenements;

import eu.cefim.java.model.AccesBdd;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EvenementQuery {
    
    public static List<Evenement> find() throws SQLException {
        EvenementHandler evenementHandler = new EvenementHandler();
        QueryRunner runner = new QueryRunner();

        String query = "SELECT * FROM evenement";
        List<Evenement> evenements = runner.query(AccesBdd.getConnection(), query, evenementHandler);

        return evenements;
    }
}
