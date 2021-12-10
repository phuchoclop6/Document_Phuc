import java.util.Scanner;
import java.net.*;
import java.io.*;
class ServerListThuMuc {
	public static void main(String[] args) 	{
		try {
			// Tao Server Socket cong 3456
			ServerSocket ss  = new ServerSocket(3456);
			while(true) {
				// Chap nhan cho noi ket
				Socket s = ss.accept();
				// Lay ra 2 stream in-out
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				Scanner sc =  new Scanner(is);
				PrintWriter pw = new PrintWriter(os);
				// Nhan cau lenh LIST tu Client
				String caulenh = sc.nextLine();		
				////   Xu ly yeu cau
				// Lay ra ten thu muc
				String tenthumuc = caulenh.substring(5);
				// Liet ke thanh phan va gui cho Client
				File f = new File(tenthumuc);
				if( f.exists() && f.isDirectory() ) {
					// Gui so luong thanh phan (n) cho Client
					String kq[] = f.list();
					int n = kq.length;
					pw.println(n); pw.flush();
					// Gui n dong tiep theo la ten file va thu muc con
					for(int i=0; i<n; i++) {
						File temp = new File(tenthumuc + "/" + kq[i]);
						if(temp.isFile()) {
							pw.println(kq[i]); pw.flush();
						}
						else {
							pw.println("[" + kq[i] + "]"); pw.flush();
						}
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
