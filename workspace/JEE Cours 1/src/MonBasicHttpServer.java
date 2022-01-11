
import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class MonBasicHttpServer {

    // private static String SERVER_NAME = "127.0.0.1";
    private static int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Lancement...");
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

            server.createContext("/hello", new MyHelloHttpHandler());

            // gestion des threads du serveur...
            server.setExecutor(null);
            server.start();

            System.out.println("Serveur lancé sur le port " + PORT);
            System.out.println("http://localhost" + ":" + PORT + "/index.html");
        } catch (IOException e) {
            // erreur lors de la création du serveur
            e.printStackTrace();
        }
    }

}
