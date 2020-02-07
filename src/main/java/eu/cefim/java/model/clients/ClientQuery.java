package eu.cefim.java.model.clients;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientQuery {

    public static List<Client> find(Connection connection) throws SQLException {
        String query = "SELECT * FROM client";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<Client> list = new ArrayList<>();

        while (rs.next()){
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setMail(rs.getString("mail"));
            client.setPassword(rs.getString("password"));


            list.add(client);
        }
        return list;
    }

    public static List<Client> find2(Connection connection) throws SQLException {
        BeanListHandler<Client> beanListHandler = new BeanListHandler<>(Client.class);
        QueryRunner runner = new QueryRunner();

        String query = "SELECT * FROM client";
        List<Client> clients = runner.query(connection, query, beanListHandler);

        return clients;
    }

    public static List<Client> find3(Connection connection) throws SQLException {
        ClientHandler clientHandler = new ClientHandler(connection);
        QueryRunner runner = new QueryRunner();

        String query = "SELECT * FROM client";
        List<Client> clients = runner.query(connection, query, clientHandler);

        return clients;
    }

    public static Client findOne(Connection connection, int id) throws  SQLException {
        String query = "SELECT * FROM client WHERE id = " + id + " LIMIT 1";
        Statement stmt = connection.createStatement();
//        String query = "SELECT id FROM client WHERE id = ? LIMIT 1";
//        PreparedStatement
//       stmt =
        ResultSet rs = stmt.executeQuery(query);

        Client client = new Client();

        if (!rs.next())
            return null;
        client.setId(rs.getInt("id"));
        client.setMail(rs.getString("mail"));
        client.setPassword(rs.getString("password"));

        return client;
    }
}
