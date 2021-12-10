
/*Nguyen Truong Giang 
  B1809120*/
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class SoDuongClient {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1",7777);
			System.out.println("Da noi ket thanh cong den Server");
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true) {
				Scanner kb = new Scanner(System.in);
				System.out.print("Nhap 1 chuoi so nguyen duong: ");
				String str = kb.nextLine();
				byte b[] = str.getBytes();
				os.write(b);
				if(str.equals("EXIT")) break; 
				byte b1[] = new byte[1000];
				int n = is.read(b1);
				String ketqua = new String(b1,0,n);
				System.out.println("Ket qua la: " + ketqua);
				}
				s.close();
			}catch(IOException e) {
			System.out.println("Loi nhap xuat");

		}

	}
}
