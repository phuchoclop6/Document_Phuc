import java.net.*;
import java.io.*;
import java.util.Scanner;

class b2b1ClientHoTen_ss {
   public static void main(String[] args) {
    try {
        Socket s = new Socket("127.0.0.1",7777);
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("nhap vao ho ten");
            String hoTen = sc.nextLine();
            os.write(hoTen.getBytes());
            if(hoTen.equals("exit")) break;
            byte b[] = new byte [1000];
            int n = is.read(b);
            String kqhoTen = new String(b,0,n);
            System.out.println("ten "+ kqhoTen);

        }
        s.close();
    }catch (IOException e){
        System.out.println("loi "+e.toString());
    }
   }
}