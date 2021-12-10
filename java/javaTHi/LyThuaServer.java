
import java.net.*;
import java.io.*;
class PhucVuLyThua extends Thread {
	Socket s;
	public PhucVuLyThua(Socket s1) {
		this.s = s1;
	}
	public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            while(true) {
                byte b[] = new byte[100];
		int n = is.read(b);
		String str = new String(b,0,n);
		if(str.equals("EXIT")) break; 
		String ketqua = new String();
		int x=0;
		int i;
		if(n >= 0) {
			for(i=1;i<=n;i++) {
				x *= i;
				System.out.println(x);
				ketqua = Integer.toBinaryString(x);
					}
				}
		else ketqua="Khong tinh duoc";
		byte b1[] = ketqua.getBytes();
		os.write(b1);
            }
            s.close();
        } catch (IOException e) {
            System.out.println("loi tu server");
        }
	}
}

class LyThuaServer {
	public static void main(String[] args) {
		try {
			// Tao Server Socket cong 11333
			ServerSocket ss = new ServerSocket(11333);
            		System.out.println("server tao thanh cong");
			while(true) {
				// Chap nhan cho noi ket
				Socket s = ss.accept();
                		System.out.println("dang cho ket noi");
				PhucVuLyThua pv = new PhucVuLyThua(s);
				pv.start();
			}
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server");
		}
	}
}
