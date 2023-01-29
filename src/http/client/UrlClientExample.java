package http.client;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Url is good wor GET requests
 */
public class UrlClientExample {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://google.com");
        URLConnection urlConnection = url.openConnection();

        urlConnection.getHeaderFields();    // for getting data from url
    }
}
