import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Bai1DateTimeClient {
    private static final int PORT = 13;
    public static void main(String[] args) {
        try{
            DatagramSocket dts = new DatagramSocket();
            InetAddress ina = InetAddress.getByName("127.0.0.1");
            Scanner sc = new Scanner(System.in);
            while(true){
                //Gui du lieu qua Server
                System.out.println("Nhap yeu cau: ");
                String request = sc.nextLine();
                byte []outputByte = request.getBytes();
                DatagramPacket outputPack = new DatagramPacket(outputByte,outputByte.length,ina,PORT);
                dts.send(outputPack);

                //Nhan du lieu tu Server
                byte []inputByte = new byte[60000];
                DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
                dts.receive(inputPack);
                String inputStr = new String(inputPack.getData(),0,inputPack.getLength());
                System.out.println("Ngay gio he thong nhan duoc la: "+ inputStr);

            }
        }catch(IOException ex){
            System.out.println("Loi Client");
        }
    }
}
