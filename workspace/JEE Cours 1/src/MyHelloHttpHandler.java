
import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHelloHttpHandler implements HttpHandler {

    private static int OK = 200;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("Une nouvelle requête sur MyHelloHttpHandler !" + exchange.getRemoteAddress());
        String response = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title>Hello world</title></head><body>Hello world ! (et bonne journée)</body></html>";
        byte[] binaryResponse = response.getBytes("UTF-8");
        exchange.sendResponseHeaders(OK, binaryResponse.length);
        OutputStream os = exchange.getResponseBody();
        os.write(binaryResponse);
        os.close();
    }

}
