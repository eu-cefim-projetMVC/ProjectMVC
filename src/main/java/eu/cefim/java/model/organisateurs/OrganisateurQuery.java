package eu.cefim.java.model.organisateurs;

import eu.cefim.java.model.AccesBdd;
import eu.cefim.java.model.clients.Client;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OrganisateurQuery {

    public static Organisateur findOne(String mail) throws SQLException {
        OrganisateurHandler organisateurHandler = new OrganisateurHandler();

        QueryRunner runner = new QueryRunner();

        String query = "SELECT * FROM organisateur WHERE mail =  ? LIMIT 1";
        Organisateur organisateur = runner. query(AccesBdd.getConnection(), query, organisateurHandler, mail);

        return organisateur;
    }
}
