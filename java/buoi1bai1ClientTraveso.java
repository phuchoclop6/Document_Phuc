/*Client sẽ nhập vào từ bàn phím 1 ký tự, gửi qua Server,
 nhận kết quả trả về từ Server (là 1 chuỗi các ký tự) 
 và hiển thị lên màn hình. Kết thúc khi nhập vào ký tự ‘@’ */

 import java.io.*;
 import java.net.*;

 class buoi1bai1ClientTraveso {
     public static void main(String[] args) {
         try {
            //tao server socket
            Socket s = new Socket("127.0.0.1",7777);
            System.out.println("da ket noi thanh cong den server");
            //tao 2 bien in-out
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            //nhap nhieu lann hoi
            while(true) {
                //nhap du lieu 
                System.out.println("nhap vao so");
                int ch = System.in.read();
                //gui den server
                os.write(ch);
                System.in.skip(2);
                //dieu kien de thoat
                if(ch =='@') break;
                //nhan du lieu tu server 
                byte b[]  = new byte[1000];
                int n = is.read(b);
                //hien thi ket qua ra man hinh
                String ketqua = new String(b,0,n);
                System.out.println("chuoi "+ ketqua);
            }
            //dong ket noi
            s.close();
         } catch (Exception e) {
             // : handle exception
         }
     }
 }