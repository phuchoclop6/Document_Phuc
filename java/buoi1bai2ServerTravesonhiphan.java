import java.net.*;
import java.io.*;
class buoi1bai2ServerTravesonhiphan {
	public static void main(String[] args) {
		try {
			// Tao Server Socket lang nghe noi ket cong 7777
			ServerSocket ss = new ServerSocket(7777);
			System.out.println("Da khoi tao xong Server");
			while(true) {		// Phuc vu cho nhieu Client
				// Chap nhan cho Client noi ket
				Socket s = ss.accept();
				System.out.println("Co 1 Client " + s.getInetAddress()
									+ " cong " + s.getPort() + " noi ket");
				// Lay ra 2 stream in-out
				InputStream is = s.getInputStream();		// Nhan du lieu
				OutputStream os = s.getOutputStream();		// Gui du lieu
				while(true) {	// Phuc vu cho 1 Client nhieu lan
					// Nhan yeu cau (ky tu ch) tu Client
					byte b[] = new byte[100];
					int n = is.read(b);
					String str = new String(b,0,n);
					// Kiem tra dieu kien de thoat
					if(str.equals("EXIT")) break;
					// Xu ly yeu cau - Doc so
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
			//ss.close();
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server");
		}
	}
}
