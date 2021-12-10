import java.net.*;
import java.io.*;
import java.util.Scanner;

class PhucVuTachTen extends Thread {
	Socket s;
	public PhucVuTachTen(Socket s1) {
		this.s = s1;
	}
	public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            while(true) {
                byte b[] = new byte[1000];
                int n = is.read(b);
                String hoTen = new String(b,0,n);
                if(hoTen.equals("exit")) break;
                String ten = tachTen(hoTen);
                os.write(ten.getBytes());
            }
            s.close();
        } catch (IOException e) {
            System.out.println("loi tu server");
        }
	}
    private String tachTen(String hoTen){
        hoTen = hoTen.trim();
        int i = hoTen.lastIndexOf(" ");
        String ten = hoTen.substring(i+1);
        return ten;
    }
}

class b2b1ServerHoTen_ss {
	public static void main(String[] args) {
		try {
			// Tao Server Socket cong 2021
			ServerSocket ss = new ServerSocket(7777);
            System.out.println("server tao thanh cong");
			while(true) {
				// Chap nhan cho noi ket
				Socket s = ss.accept();
                System.out.println("dang cho ket noi");
				PhucVuTachTen pv = new PhucVuTachTen(s);
				pv.start();
			}
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Server");
		}
	}
}
