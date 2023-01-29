package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class DatagramServerRunner {

    public static void main(String[] args) throws IOException {

        try(var datagramServer= new DatagramSocket(7777)){

            var buffer = new byte[21];  // size should be equal ore more than send packet
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            datagramServer.receive(packet);

            System.out.println(new String(buffer));
        }
    }
}
