import java.net.*;
import java.io.*;

class PhucVuDocSo extends Thread {
	Socket s;
	public PhucVuDocSo(Socket s1) {
		s = s1;
	}
	public void run() {
		try {
					// Lay ra stream nhan-gui (in-out)
					InputStream is = s.getInputStream();
					OutputStream os = s.getOutputStream();
					while(true) {	// Phuc vu cho 1 Client nhieu lan
						// Nhan yeu cau tu Client
						int ch = is.read();
						System.out.println("Nhan duoc tu Client: " + (char)ch);
						// Kiem tra dieu kien de thoat
						if(ch=='@') break;
						// Xu ly yeu cau - doc so
						String ketqua = "Khong biet";
						switch(ch) {
							case '0': ketqua = "Khong"; break;
							case '1': ketqua = "Mot"; break;
							case '2': ketqua = "Hai"; break;
							case '3': ketqua = "Ba"; break;
							case '4': ketqua = "Bon"; break;
							case '5': ketqua = "Nam"; break;
							case '6': ketqua = "Sau"; break;
							case '7': ketqua = "Bay"; break;
							case '8': ketqua = "Tam"; break;
							case '9': ketqua = "Chin"; break;
						}
						// Gui ket qua phuc vu cho Client
						byte b[] = ketqua.getBytes();
						os.write(b);
					}
					// Dong noi ket
					s.close();
					System.out.println("   Da dong noi ket voi 1 Client");
		}
		catch(IOException e) {
			System.out.println("Co loi khi dang phuc vu cho 1 Client");
		}
	}
};

class ServerDocSo_SS {
	public static void main(String[] args) {
		try {
			// Tao Server Socket pv o cong 7777
			ServerSocket ss = new ServerSocket(7777);
			System.out.println("Da khoi tao xong Server cong 7777");
			while(true) {	// Phuc vu cho nhieu Client
				try {
					// Chap nhan cho 1 Client noi ket
					Socket s = ss.accept();
					System.out.println("Co 1 Client noi ket");
					PhucVuDocSo pv1 = new PhucVuDocSo(s);
					pv1.start();
				}
				catch(IOException e) {
					System.out.println("Co loi khi chap nhan noi ket cua 1 Client");
				}
			}
			//ss.close();
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server");
		}
	}
}
