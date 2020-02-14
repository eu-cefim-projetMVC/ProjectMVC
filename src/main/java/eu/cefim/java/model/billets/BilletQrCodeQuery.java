package eu.cefim.java.model.billets;

import eu.cefim.java.model.AccesBdd;
import eu.cefim.java.model.organisateurs.Organisateur;
import eu.cefim.java.model.organisateurs.OrganisateurHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BilletQrCodeQuery {


    public static Billet findOne(int id) throws SQLException {
        BilletQrCodeHandler billetQrCodeHandler = new BilletQrCodeHandler();

        QueryRunner runner = new QueryRunner();

        String query = "SELECT * FROM billet WHERE id =  ? LIMIT 1";
        Billet billet = runner.query(AccesBdd.getConnection(), query,id, billetQrCodeHandler);

        return billet;
    }

    public static Billet findOneByQrCode(String code) throws SQLException {
        BilletQrCodeHandler billetQrCodeHandler = new BilletQrCodeHandler();

        QueryRunner runner = new QueryRunner();

        String query = "SELECT * FROM billet WHERE code =  ? LIMIT 1";
        Billet billet = runner.query(AccesBdd.getConnection(), query,code, billetQrCodeHandler);

        return billet;
    }

    public static void updatePassage(String code, long nbPlace) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String query = "UPDATE billet SET nombre_passages = ? WHERE code = ?";
        int numRowsUpdated = runner.update(AccesBdd.getConnection(), query, nbPlace, code);
    }
}
