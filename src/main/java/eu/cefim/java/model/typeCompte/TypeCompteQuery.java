package eu.cefim.java.model.typeCompte;

import eu.cefim.java.model.AccesBdd;
import eu.cefim.java.model.organisateurs.Organisateur;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class TypeCompteQuery {
    public static TypeCompte findOne(String nom) throws SQLException {
        BeanHandler<TypeCompte> beanHandler = new BeanHandler<>(TypeCompte.class);

        QueryRunner runner = new QueryRunner();

        String query = "SELECT * FROM type_compte";
        TypeCompte typeCompte = runner.query(AccesBdd.getConnection(), query, beanHandler, nom);

        return typeCompte;
    }
}
