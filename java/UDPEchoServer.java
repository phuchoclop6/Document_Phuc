import java.net.*;
import java.io.*;
class UDPEchoServer {
	public static void main(String[] args) {
		try {
			// Tao UDP Socket cong 7
			DatagramSocket ds = new DatagramSocket(7);
			// Nhan goi yeu cau tu Client
			byte b[] = new byte[60000];
			DatagramPacket goinhan = new DatagramPacket(b,60000);
			while(true) {
				ds.receive(goinhan);
				// Xu ly yeu cau
				byte b1[] = goinhan.getData();
				int len1 = goinhan.getLength();
				String str = new String(b1,0,len1);
				System.out.println("Nhan duoc tu Client: " + str);
				String ketqua = str.toUpperCase();
				// Dong goi ket qua
				byte b2[] = ketqua.getBytes();
				int len2 = b2.length;
				InetAddress dc2 = goinhan.getAddress();
				int p2 = goinhan.getPort();
				DatagramPacket goigui = new DatagramPacket(b2,len2,dc2,p2);
				// Gui goi ket qua cho Client
				ds.send(goigui);
			}
		}
		catch(SocketException e) {
			System.out.println("Khoi tao UDP Socket that bai");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
