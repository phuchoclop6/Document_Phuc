import java.net.*;
import java.io.*;
import java.util.Scanner;

class buoi1bai2ClientTravesonhiphan {
	public static void main(String[] args) {
		try {
			// Noi ket den Server cong 7777
			Socket s = new Socket("127.0.0.1",7777);
			System.out.println("Da noi ket thanh cong den Server");
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();		// Nhan du lieu
			OutputStream os = s.getOutputStream();		// Gui du lieu
			while(true) {
				// Nhap 1 ky tu ch tu ban phim
                Scanner sc = new Scanner(System.in);
				System.out.print("Nhap vao 1 chuoi ");
				String str = sc.nextLine(); 
				// Gui ky tu ch qua cho Server
                byte b1[] = str.getBytes();
				os.write(b1);
				if(str.equals("EXIT")) break;
				// Nhan ket qua tra ve tu Server (nhieu ky tu)
				byte b[] = new byte[1000];
				int n = is.read(b);
				// Hien thi ket qua ra man hinh
				String ketqua = new String(b,0,n);
				System.out.println("Nhan duoc: " + ketqua);
			}
			// Dong noi ket
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.println("Sai dia chi Server");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}
