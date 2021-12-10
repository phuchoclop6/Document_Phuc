import java.util.Scanner;
import java.net.*;
import java.io.*;
class TCPFileClient {
	public static void main(String[] args) {
		try {
			// Nhap vao dia chi Server, ten file can truy xuat va can luu
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap dia chi Server: ");
			String dcServer = kb.nextLine();
			System.out.print("Nhap ten file tren Server can truy xuat: ");
			String tenfile = kb.nextLine();
			System.out.print("Nhap ten file can luu tren may cuc bo: ");
			String tenfileluu = kb.nextLine();
			// Noi ket den Server
			Socket s = new Socket(dcServer, 23456);
			// Lay ra 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			// Gui qua Server cau lenh "READ Tenfile"
			String caulenh = "READ " + tenfile;
			pw.println(caulenh); pw.flush();
			// Nhan ve dong dau tien la kich thuoc file
			String ketqua = sc.nextLine();
			int size = Integer.parseInt(ketqua);
			// Kiem tra
			if(size==-1)
				System.out.println("File " + tenfile + " khong ton tai");
			else
				if(size==0)
					System.out.println("File " + tenfile + " rong");
				else {
					FileOutputStream f = new FileOutputStream(tenfileluu);
					// Nhan ve noi dung file
					byte b[] = new byte[10000];
					int tong = 0;
					DataInputStream dis = new DataInputStream(is);
					while(true) {
						int n = dis.read(b,0,10000);
						// Luu file tren cuc bo
						f.write(b,0,n);
						tong += n;
						System.out.println("Da nhan duoc " + tong + " byte");
						if(tong==size)	break;
					}
					f.close();
					System.out.println("Da luu file thanh cong");
				}
			// Dong noi ket
			s.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
