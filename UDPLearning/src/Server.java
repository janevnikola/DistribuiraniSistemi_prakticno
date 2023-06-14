import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class Server {
    public static void main(String []args) {
        try {
         //kreirame buffer vo koj ke citame
            byte [] buffer=new byte[100];
            DatagramPacket incoming=new DatagramPacket(buffer,buffer.length);

            //kreirame DatagramSocket na koj ke slusame
            DatagramSocket datagramSocket=new DatagramSocket(1234);
            //go passuvame paketot vo receive method
            datagramSocket.receive(incoming);
            //datagramPacket se polni so podatoci
            byte [] podatociKoiSePrimaat=incoming.getData();
            String s=new String(podatociKoiSePrimaat,0, podatociKoiSePrimaat.length);
            //Use getPort() and and getAddress() to tell where the packet
            //came from, getData() to retrieve the data, and getLength()
            //to see how many bytes were in the data.
            System.out.println("Portata e: "+incoming.getPort()+" od "+incoming.getAddress()+" ja prati ovaa poraka: "+incoming.getData());
            System.out.println(s);



        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
