package eu.cefim.java.model.evenements;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EvenementQuery {
    
    public static List<Evenement> find3(Connection connection) throws SQLException {
        EvenementHandler evenementHandler = new EvenementHandler(connection);
        QueryRunner runner = new QueryRunner();

        String query = "SELECT * FROM evenement";
        List<Evenement> evenements = runner.query(connection, query, evenementHandler);

        return evenements;
    }
}
