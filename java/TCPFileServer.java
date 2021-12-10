import java.util.Scanner;
import java.net.*;
import java.io.*;
class TCPFileServer {
	public static void main(String[] args) {
		try {
			// Tao Server Socket cong 23456
			ServerSocket ss = new ServerSocket(23456);
			while(true) {
				// Chap nhan cho noi ket
				Socket s = ss.accept();
				// Lay ra 2 stream in-out
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				Scanner sc = new Scanner(is);
				PrintWriter pw = new PrintWriter(os);		
				// Nhan cau lenh "READ Tenfile"
				String caulenh = sc.nextLine();
				// Lay thong tin Tenfile duoc yeu cau
				String tenfile = caulenh.substring(5);
				// Kiem tra file yeu cau
				File f  = new File(tenfile);
				if( f.exists() && f.isFile() ) {
					int size = (int)f.length();
					pw.println(size); pw.flush();
					if(size > 0) {
						// Doc noi dung file
						byte b[] = new byte[size];
						FileInputStream f1 = new FileInputStream(tenfile);
						DataInputStream dis = new DataInputStream(f1);
						dis.readFully(b);
						System.out.println("Da doc xong noi dung file");
						f1.close();
						// Gui noi dung file cho Client
						DataOutputStream dos = new DataOutputStream(os);
						dos.write(b);
						System.out.println("Da gui xong noi dung file");
					}
				}
				else {
					pw.println("-1"); pw.flush();
				}
				// Dong noi ket
				s.close();
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
