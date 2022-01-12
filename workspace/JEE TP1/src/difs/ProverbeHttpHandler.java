package difs;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class ProverbeHttpHandler implements HttpHandler{

	private static String proverbesFile = "./htdocs/proverbes.txt";
	private Random random;
	private List<String> fileLines;
	
	public ProverbeHttpHandler() {
		this.random = new Random();
		try {
			this.fileLines = Files.readAllLines(Paths.get(proverbesFile));
		} catch (IOException e) {
			this.fileLines = new ArrayList<String>();
			e.printStackTrace();
		}
	}
	
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		System.out.println("Demande de proverbe depuis " + exchange.getRemoteAddress());
		String response = this.fileLines.get(random.nextInt(fileLines.size()));
		System.out.println("envoi : "+response);
		exchange.sendResponseHeaders(200, response.length());
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
		
	}

}
