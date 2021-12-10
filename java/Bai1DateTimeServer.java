import java.util.Scanner;
import java.util.Date;
import java.io.*;
import java.net.*;

public class Bai1DateTimeServer {
    private static final int PORT = 13; 
    public static void main(String[] args) {
        try{
            DatagramSocket dts = new DatagramSocket(PORT);
            while(true){
                //Nhan du lieu tu Client
                byte []inputByte = new  byte[1];
                DatagramPacket inputPack = new DatagramPacket(inputByte, 0);
                dts.receive(inputPack);

                //Xu ly
                Date date = new Date();
                String outputStr = date.toString();
                 
                //Gui du lieu cho Client
                byte []outputByte = outputStr.getBytes();
                DatagramPacket outputPack = new DatagramPacket(outputByte,outputByte.length,inputPack.getAddress(),inputPack.getPort());
                dts.send(outputPack);

            }
        }catch(IOException ex){
            System.out.println("Loi Server" + ex.toString());
        }
    }
}
