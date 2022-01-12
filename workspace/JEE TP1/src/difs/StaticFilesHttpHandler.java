package difs;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class StaticFilesHttpHandler implements HttpHandler {

	private static String root = "./htdocs";

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		URI uri = exchange.getRequestURI();
		System.out.println("looking for: " + root + uri.getPath() + " depuis " + exchange.getRemoteAddress());
		String path = uri.getPath();
		File file = new File(root + path).getCanonicalFile();
		// System.out.println(file.getAbsolutePath());

		if (!file.isFile()) {
			// Soit le fichier n'existe pas, soit ce n'est pas un fichier...
			File file404 = new File(root + "/404.html").getCanonicalFile();
			if (!file404.isFile()) {
				String response = "404 (Not Found)\n";
				exchange.sendResponseHeaders(404, response.length());
				OutputStream os = exchange.getResponseBody();
				os.write(response.getBytes());
				os.close();
			} else {
				String mime = "text/html";
				Headers h = exchange.getResponseHeaders();
				h.set("Content-Type", mime);
				FileInputStream fs = new FileInputStream(file404);
				exchange.sendResponseHeaders(200, file404.length());

				OutputStream os = exchange.getResponseBody();

				final byte[] buffer = new byte[0x100000];
				int count = 0;
				while ((count = fs.read(buffer)) >= 0) {
					os.write(buffer, 0, count);
				}
				fs.close();
				os.close();
			}
		} else {
			// La ressource existe, et c'est un fichier : code 200.
			String mime = "text/html";
			if (path.substring(path.length() - 3).equals(".js"))
				mime = "application/javascript";
			if (path.substring(path.length() - 3).equals("css"))
				mime = "text/css";
			if (path.substring(path.length() - 3).equals("jpg"))
				mime = "image/jpeg";

			Headers h = exchange.getResponseHeaders();
			h.set("Content-Type", mime);
			FileInputStream fs = new FileInputStream(file);
			exchange.sendResponseHeaders(200, file.length());

			OutputStream os = exchange.getResponseBody();

			final byte[] buffer = new byte[0x100000];
			int count = 0;
			while ((count = fs.read(buffer)) >= 0) {
				os.write(buffer, 0, count);
			}
			fs.close();
			os.close();
		}
	}

}
