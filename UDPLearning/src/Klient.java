import java.io.IOException;
import java.net.*;

public class Klient {
    public static void main(String []args){

        //za prakjanje datagrami so UDP protokolot
        try{
         //zimame ip adresa od destinacijata
            InetAddress adresaDestinacija=InetAddress.getByName("localhost");
            int destinaciska_porta=1234;
            String poraka="Zdravo serveru";
            //convert-irame vo niza od bytes
            byte [] bytes_poraka=poraka.getBytes();
            //Kreirame datagram packet
            //Pass this byte array, the length of the data in the
            //array (most of the time this will be the length of
            //the array) and the InetAddress and port to which
            //you wish to send it into the DatagramPacket()
            //constructor.
            DatagramPacket datagramPacket=new DatagramPacket(bytes_poraka,bytes_poraka.length,adresaDestinacija,destinaciska_porta);
           //kreirame DatagramSocket i go stavame datagramPacket vo .send() metodata
            DatagramSocket datagramSocket=new DatagramSocket();
            datagramSocket.send(datagramPacket);

            } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
