package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {

        var inet4Address =Inet4Address.getByName("localhost");

        try(var socket = new Socket(inet4Address, 7777);
            var dataInputStream = new DataInputStream(socket.getInputStream());
            var dataOutputStream = new DataOutputStream(socket.getOutputStream())){
            Scanner scanner = new Scanner(System.in);

            while(scanner.hasNextLine()) {
                dataOutputStream.writeUTF(scanner.nextLine());
                System.out.println("Response from server => " + dataInputStream.readUTF());
            }
        }

    }
}