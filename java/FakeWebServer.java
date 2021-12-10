import java.net.*;
import java.io.*;
import java.util.Scanner;
class FakeWebServer {
	public static void main(String[] args) {
		try {
			// Tao ra Server Socket cong 80
			ServerSocket ss = new ServerSocket(80);
			System.out.println("Da khoi tao xong Web Server");
			// Chap nhan cho 1 Client noi ket
			Socket s = ss.accept();
			System.out.println("Co 1 Client noi ket");
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			// Nhan cau lenh GET tu WebClient
			System.out.println("Nhan duoc tu Client:");
			while(true) {
				String kq = sc.nextLine();
				if(kq.equals("")) break; 
				// Hien thi ra man hinh
				System.out.println(kq);
			}
			// Dong noi ket
			s.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
