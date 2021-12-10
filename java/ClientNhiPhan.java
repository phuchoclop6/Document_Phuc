import java.util.Scanner;
import java.net.*;
import java.io.*;
class ClientNhiPhan {
	public static void main(String[] args) {
		try {
			// Noi ket den Server
			Socket s = new Socket("127.0.0.1", 2021);
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true) {
				// Nhap tu ban phim 1 chuoi
				Scanner kb = new Scanner(System.in);
				System.out.print("Nhap 1 chuoi so nguyen: ");
				String str = kb.nextLine();
				// Gui qua Server
				byte b[] = str.getBytes();
				os.write(b);
				// Kiem tra dieu kien de thoat
				if(str.equals("EXIT")) break; 
				// Nhan ket qua tra ve tu Server (1 chuoi)
				byte b1[] = new byte[1000];
				int n = is.read(b1);
				// Hien thi ket qua
				String ketqua = new String(b1,0,n);
				System.out.println("Ket qua la: " + ketqua);
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
