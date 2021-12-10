import java.net.*;
import java.io.*;
import java.util.Scanner;
class UDPEchoClient {
	public static void main(String[] args) {
		try {
			// Tao UDP Socket
			DatagramSocket ds = new DatagramSocket();
			// Nhap 1 chuoi tu ban phim
			Scanner kb = new Scanner(System.in);
			while(true) {
				System.out.print("Nhap 1 chuoi: ");
				String str = kb.nextLine();
				// Kiem tra dk de thoat
				if(str.equals("EXIT")) break;
				// Dong goi chuoi vua nhap
				byte b[] = str.getBytes();
				int len = b.length;
				InetAddress dc = InetAddress.getByName("127.0.0.1");
				int p = 7;
				DatagramPacket goigui = new DatagramPacket(b,len,dc,p);
				// Gui goi qua Server
				ds.send(goigui);
				// Tao ra goi UDP dung de nhan
				byte b1[] = new byte[60000];
				DatagramPacket goinhan = new DatagramPacket(b1,60000);
				// Nhan goi tra loi tu Server
				ds.receive(goinhan);
				// Hien thi thong tin cua goi
				byte b2[] = goinhan.getData();
				int len2 = goinhan.getLength();
				String ketqua = new String(b2,0,len2);
				System.out.println("Nhan duoc: " + ketqua);
			}
			// Dong socket
			ds.close();
		}
		catch(SocketException e) {
			System.out.println("Khoi tao UDP Socket that bai");
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
