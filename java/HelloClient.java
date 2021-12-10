import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
class HelloClient {
	public static void main(String[] args) {
		try {
			// Tim doi tuong cho phep goi tu xa
			HelloItf ref = (HelloItf)Naming.lookup("rmi://127.0.0.1/ABC");	// URL
			System.out.println("Da tim duoc doi tuong ABC");
			// Goi ham tu xa
			/*String ketqua = ref.sayHello();
			System.out.println("Ket qua la: " + ketqua);*/
			ref.sayHello();
		}
		catch(NotBoundException e) {
			System.out.println("Khong tim duoc doi tuong ABC");
		}
		catch(MalformedURLException e) {
			System.out.println("Sai dinh dang URL tim kiem"); 
		}
		catch(RemoteException e) {
			System.out.println("Loi tu xa");
		}
	}
}
