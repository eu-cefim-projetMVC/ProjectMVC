package eu.cefim.java.model.clients;

import eu.cefim.java.model.billets.Billet;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientHandler extends BeanListHandler<Client> {

    private Connection connection;

    public ClientHandler(Connection connexion){
        super(Client.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
        connection = connexion;
    }

    @Override
    public List<Client> handle(ResultSet rs) throws SQLException {
        List<Client> clients = super.handle(rs);

        QueryRunner runner = new QueryRunner();
        BeanListHandler<Billet> handler = new BeanListHandler<>(Billet.class);
        String query = "SELECT * FROM billet WHERE achat_client_id = ?";

        for (Client client : clients) {
            List<Billet> billetsAchetes = runner.query(connection, query, handler, client.getId());
            client.setBilletsAchetes(billetsAchetes);
        }
        return clients;
    }

    public static Map<String, String> mapColumnsToFields() {

        Map<String, String> columnsToFieldsMap = new HashMap<>();

        columnsToFieldsMap.put("organisateur_id", "organisateurId");

        return columnsToFieldsMap;
    }
}