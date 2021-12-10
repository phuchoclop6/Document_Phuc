import java.net.*;
import java.io.*;

class PhucVuNhiPhan extends Thread {
	Socket s;
	public PhucVuNhiPhan(Socket s1) {
		s = s1;
	}
	public void run() {
		try {
				// Lay ra 2 stream in-out
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				while(true) {
					// Nhan chuoi tu Client
					byte b[] = new byte[100];
					int n = is.read(b);
					String str = new String(b,0,n);
					// Kiem tra dieu kien de thoat
					if(str.equals("EXIT")) break; 
					// Xu ly yeu cau (doi thanh so nhi phan)
					String ketqua = new String();
					try {
						int x = Integer.parseInt(str);
						ketqua = Integer.toBinaryString(x);
					}
					catch(NumberFormatException e) {
						ketqua = "Khong phai la so nguyen";
					}
					// Gui ket qua cho Client
					byte b1[] = ketqua.getBytes();
					os.write(b1);
				}
				// Dong noi ket
				s.close();
		}
		catch(IOException e) {
			System.out.println("Co loi khi dang phuc vu 1 Client");
		}
	}
};

class ServerNhiPhan_SS {
	public static void main(String[] args) {
		try {
			// Tao Server Socket cong 2021
			ServerSocket ss = new ServerSocket(2021);
			while(true) {
				// Chap nhan cho noi ket
				Socket s = ss.accept();
				PhucVuNhiPhan pv = new PhucVuNhiPhan(s);
				pv.start();
			}
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server");
		}
	}
}
