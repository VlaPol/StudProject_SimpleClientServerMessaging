package http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

/**
 * http is good for all kinds of requests
 */
public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {

         var httpClient = HttpClient.newBuilder()
                 .version(HttpClient.Version.HTTP_2)
                 .build();

         //for GET request
         var httpRequest = (HttpRequest.newBuilder(
                 URI.create("https://www.google.com"))
                 .GET()
                 .build());

         //for POST request
        var httpRequest2 = (HttpRequest.newBuilder(
                        URI.create("https://www.google.com"))
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("path")))
                .build());

         var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

         System.out.println(response.headers());
         System.out.println("****************************");
         System.out.println(response.body());
    }
}
