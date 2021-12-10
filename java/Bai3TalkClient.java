import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Bai3TalkClient {
    private static final int PORT = 1212;
    public static void main(String[] args) {
        try{
            DatagramSocket dts = new DatagramSocket();
            InetAddress ina = InetAddress.getByName("127.0.0.1");
            Scanner sc = new Scanner(System.in);
            while(true){
                //Gui du  lieu den Server
                System.out.println("Ban noi: ");
                String outpuStr = sc.nextLine();

                DatagramPacket outputPack = new DatagramPacket(outpuStr.getBytes(),outpuStr.length(),ina,PORT);
                dts.send(outputPack);

                //Nhan du lieu tu server
                byte []inputByte = new byte[60000];
                DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
                dts.receive(inputPack);
                
                String inputStr = new String(inputPack.getData(),0,inputPack.getLength());
                System.out.println("Chuoi nhan duoc la: " + inputStr);
            }
        }catch(IOException ex){
            System.out.println("Loi tu client");
        }
    }
}