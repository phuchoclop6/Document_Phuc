import java.util.Date;
import java.net.*;
import java.io.*;
import java.util.*;
class MulticastTimeServer {
	public static void main(String[] args){
		try {
			// Tao UDP Socket
			DatagramSocket ds = new DatagramSocket();
			/*int dem = 0;*/
				Scanner kb = new Scanner(System.in);	
				System.out.printf("Ho ten cua ban la gi: ");
				String str= kb.nextLine();
				System.out.printf("Ban da duoc tiem bao nhieu muoi vaccine ngua Covid-19?");
				String str1 = kb.nextLine();
			while(true) {
				Date d = new Date();
				String ketqua = d.toString();
				String str2 = ketqua + str + "da tiem " + str1 + "mui vaccine";
				// Lay thong tin ve thoi gian
				
				
				// Dong goi UDP
				byte b[] = str2.getBytes();
				int len = b.length;
				InetAddress dc = InetAddress.getByName("230.0.0.1");
				int p = 9013;
				DatagramPacket goigui = new DatagramPacket(b,len,dc,p);
				// Gui goi den nhom dia chi 230.0.0.1, cong 9013
				ds.send(goigui);
				System.out.println("Da gui ");
				Thread.sleep(2000);
			}
		}
		catch(SocketException e) {
			System.out.println("Khong khoi tao duoc UDP Socket");
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		catch(InterruptedException e) {
			System.out.println("Loi xay ra khi tam dung CT");
		}
	}
}
