package http.server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

import static java.net.http.HttpRequest.BodyPublishers.*;

public class HttpClientRunner {

    public static void main(String[] args) throws IOException, InterruptedException {

        // create http-client
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        // create new http-request
        var httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))                      // where we should send request
                .header("content-type", "application/json")
                .POST(ofFile(Path.of("resources", "first.json")))
                .build();

        // create variable for received response
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.headers());
        System.out.println(response.body());
    }
}
