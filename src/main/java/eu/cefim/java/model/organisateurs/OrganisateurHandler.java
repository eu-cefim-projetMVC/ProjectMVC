package eu.cefim.java.model.organisateurs;

import eu.cefim.java.model.AccesBdd;
import eu.cefim.java.model.evenements.Evenement;
import eu.cefim.java.model.evenements.EvenementHandler;
import eu.cefim.java.model.typeCompte.TypeCompte;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganisateurHandler extends BeanHandler<Organisateur> {

    public OrganisateurHandler() {
        super(Organisateur.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
    }

    @Override
    public Organisateur handle(ResultSet rs) throws SQLException {
        Organisateur organisateur = super.handle(rs);

        if (organisateur == null)
            return null;

        QueryRunner runner = new QueryRunner();
        EvenementHandler handler = new EvenementHandler();
        String query = "SELECT * FROM evenement WHERE organisateur_id = ? ";

        List<Evenement> evenements = runner.query(AccesBdd.getConnection(), query, handler, organisateur.getId());
        organisateur.setEvenements(evenements);

        BeanHandler<TypeCompte> handler2 = new BeanHandler<>(TypeCompte.class);
        String query2 = "SELECT * FROM type_compte WHERE id = ?";
        TypeCompte typeCompte = runner.query(AccesBdd.getConnection(), query2, handler2, organisateur.getTypeCompteId());
        organisateur.setTypeCompte(typeCompte);

        BeanHandler<Organisateur> handler3 = new BeanHandler<>(Organisateur.class);
        String query3 = "SELECT mail FROM organisateur WHERE id = ?";
        Organisateur mailParrain = runner.query(AccesBdd.getConnection(), query3, handler3, organisateur.getParrainId());
        organisateur.setParrainMail(mailParrain);

        ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
        ScalarHandler<BigDecimal> scalarHandler2 = new ScalarHandler<>();
        String query4 = "SELECT COUNT(*) FROM billet WHERE evenement_id = ? AND panier_client_id IS NOT NULL";
        String query5 = "SELECT COUNT(*) achat_client_id FROM billet WHERE evenement_id = ? AND achat_client_id IS NOT NULL";
        String query6 = "SELECT SUM(nombre_places) FROM categorie_billet WHERE evenement_id = ? ";
        for (Evenement evenement : evenements) {

            long nbBilletPanier = runner.query(AccesBdd.getConnection(), query4, scalarHandler, evenement.getId());//
            long nbBilletVendus = runner.query(AccesBdd.getConnection(), query5, scalarHandler, evenement.getId());
            long nbBilletMax = runner.query(AccesBdd.getConnection(), query6, scalarHandler2, evenement.getId()).longValue();

            evenement.setNbBilletsPanier(nbBilletPanier);
            evenement.setNbBilletsVendus(nbBilletVendus);
            evenement.setNbBilletsMax(nbBilletMax);


        }
        return organisateur;
    }

    public static Map<String, String> mapColumnsToFields() {

        Map<String, String> columnsToFieldsMap = new HashMap<>();

        columnsToFieldsMap.put("organisateur_id", "organisateurId");
        columnsToFieldsMap.put("parrain_id", "parrainId");
        columnsToFieldsMap.put("type_compte_id", "typeCompteId");
        columnsToFieldsMap.put("date_derniere_connexion", "dateDerniereConnexion");
        columnsToFieldsMap.put("evenement_id", "evenementId");


        return columnsToFieldsMap;
    }

}
