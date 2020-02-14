package eu.cefim.java.model.billets;

import eu.cefim.java.model.organisateurs.Organisateur;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.util.HashMap;
import java.util.Map;

public class BilletQrCodeHandler extends BeanHandler<Billet> {

    public BilletQrCodeHandler(){
        super(Billet.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
    }

    public static Map<String, String> mapColumnsToFields() {

        Map<String, String> columnsToFieldsMap = new HashMap<>();

        columnsToFieldsMap.put("evenement_id", "evenementId");
        columnsToFieldsMap.put("categorie_billet_id", "categorieBilletId");
        columnsToFieldsMap.put("panier_client_id", "panierClientId");
        columnsToFieldsMap.put("achat_client_id", "achatClientId");
        columnsToFieldsMap.put("date_action", "dateAction");
        columnsToFieldsMap.put("nombre_passages", "nombrePassages");
        columnsToFieldsMap.put("organisateur_id", "OrganisateurId");

        return columnsToFieldsMap;
    }
}
