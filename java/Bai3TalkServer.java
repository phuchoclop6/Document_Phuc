import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Bai3TalkServer {
    private static final int PORT = 1212;
    public static void main(String[] args) {
        try{
            DatagramSocket dts = new DatagramSocket(PORT);
            Scanner sc = new Scanner(System.in);
            byte []inputByte = new byte[60000];
            while(true){
                //Nhan du lieu tu Client
                DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
                dts.receive(inputPack);
                String inputStr = new String(inputPack.getData(),0,inputPack.getLength());
                System.out.println("Client noi: "+ inputStr);

                //Gui du lieu den Client
                System.out.println("Server noi: ");
                String outputStr = sc.nextLine();
                DatagramPacket outputPack = new DatagramPacket(outputStr.getBytes(),outputStr.length(),inputPack.getAddress(),inputPack.getPort());
                dts.send(outputPack);             
            }
        }catch(IOException ex){
            System.out.println("Loi Server");
        }
    }
}