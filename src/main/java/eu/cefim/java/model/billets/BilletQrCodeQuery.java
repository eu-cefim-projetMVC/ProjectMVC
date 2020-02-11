package eu.cefim.java.model.billets;

import eu.cefim.java.model.AccesBdd;
import eu.cefim.java.model.organisateurs.Organisateur;
import eu.cefim.java.model.organisateurs.OrganisateurHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class BilletQrCodeQuery {

    public static Billet findOne(String id) throws SQLException {
        BeanHandler<Billet> beanHandler = new BeanHandler<>(Billet.class);

        QueryRunner runner = new QueryRunner();

        String query = "SELECT * FROM billet WHERE id =  ? LIMIT 1";
        Billet billet = runner.query(AccesBdd.getConnection(), query, beanHandler, id);

        return billet;
    }
}
