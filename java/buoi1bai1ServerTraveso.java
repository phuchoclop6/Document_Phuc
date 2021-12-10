/*    • Server làm nhiệm vụ đọc 1 ký tự số từ  ký tự  '0'  đến ký tự  '9'.
Ví dụ :  nhận 	ký tự  0 : trả về chuỗi  "khong" , 
ký tự  1 : trả về chuỗi  "mot" ; 
…
ký tự  9 : trả về chuỗi  "chin" 
nhận ký tự khác số thì trả về chuỗi  "Không phải số nguyên" .*/

import java.io.*;
import java.net.*;

class buoi1bai1ServerTraveso {
    public static void main(String[] args) {
        try {
            //tao server socket server
            ServerSocket ss = new ServerSocket(7777);
            System.out.println("da khoi tao xong server");
            //chap nhan ket noi tu nhieu client 
            while(true) {
                 //chap nhan ket noi tu client
                Socket s = ss.accept();
                //lay bien 2 in-out
                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();
                //nhan nhieu cau hoi tu 1 client
                while(true){
                    //nhan yeu cau tu client 
                    int ch = is.read();
                    System.out.println("chuoi nhan duoc la "+ ch);
                    //dieu kien de thoat
                    if(ch=='@') break;
                    //xu ly yeu cau client
                    String ketqua = "Khong phai so nguyen";
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
                    //gui ket qua cho  client 
                    byte b[] = ketqua.getBytes();
                    os.write(b);
                }
                //thoat
                s.close();
            }         
           
        } catch (Exception e) {
            System.out.println("loi");
        }
    }
}