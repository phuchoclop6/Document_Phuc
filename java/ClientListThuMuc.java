import java.util.Scanner;
import java.net.*;
import java.io.*;
class ClientListThuMuc {
	public static void main(String[] args) {
		try {
			// Noi ket den Server
			Socket s = new Socket("127.0.0.1", 3456);
			// lay ra 2 stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			// Nhap tu ban phim ten thu muc (o Server) can list
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten thu muc o Server can list: ");
			String tenthumuc = kb.nextLine();
			// Gui cau lenh "LIST Tenthumuc" qua Server
			String caulenh = "LIST " + tenthumuc;
			pw.println(caulenh); pw.flush();
			////  Nhan ket qua tra ve tu Server
			String chuoisoluong = sc.nextLine();
			int n = Integer.parseInt(chuoisoluong);
			// Nhan ve chuoi so luong thanh phan
			if(n==-1)
				System.out.println("Thu muc " + tenthumuc + " khong ton tai");
			else
				if(n==0)
					System.out.println("Thu muc " + tenthumuc + " rong");
				else {
					// Nhan n dong tiep theo
					System.out.println(tenthumuc + " bao gom:");
					for(int i=0; i<n; i++) {
						String kq = sc.nextLine();
						System.out.println(kq);
					}
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
