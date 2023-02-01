package http.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void run() {
        try (var server = new ServerSocket(port)) {
            var socket = server.accept();     // accept connection from client. Blocking method!
            processSocket(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {

        try (socket;
             var inputStream = new DataInputStream(socket.getInputStream());
             var outStream = new DataOutputStream(socket.getOutputStream())) {
// request handler
            System.out.println("Request: " + new String(inputStream.readNBytes(600)));

// response handler;
            var body = Files.readAllBytes(Path.of("resources", "example.html"));
            var headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length).getBytes();
            outStream.write(headers);
            outStream.write(System.lineSeparator().getBytes());
            outStream.write(body);
        } catch (IOException e) {
            // here should be error logger
            e.printStackTrace();
        }


    }
}
