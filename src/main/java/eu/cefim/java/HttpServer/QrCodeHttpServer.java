package eu.cefim.java.HttpServer;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import eu.cefim.java.model.billets.Billet;
import eu.cefim.java.model.billets.BilletQrCodeQuery;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.sql.SQLException;

public class QrCodeHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
        HttpContext context = server.createContext("/qrcode/");
        context.setHandler(QrCodeHttpServer::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        String strRequest = String.valueOf(requestURI);
        strRequest = strRequest.replace("/qrcode/", "");
        Billet billet = new Billet();
        try {
            billet = BilletQrCodeQuery.findOneByQrCode(strRequest);
            billet.setNombrePassages(billet.getNombrePassages() + 1);
            System.out.println(billet.getCode());
            BilletQrCodeQuery.updatePassage(billet.getCode(), billet.getNombrePassages());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String response = "Le code de ce billet est " + strRequest + " et son nombre de scan est : " + billet.getNombrePassages() + " fois.";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
