import java.rmi.RMISecurityManager;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
class HelloServer {
	public static void main(String[] args) {
		try {
			// Khoi tao co che bao mat cua RMI
			if(System.getSecurityManager()==null)
				System.setSecurityManager(new RMISecurityManager());
			// Tao ra doi tuong cho phep goi tu xa
			Hello obj = new Hello();
			System.out.println("Da khoi tao xong doi tuong cho phep goi tu xa");
			// Dang ky doi tuong cho phep goi tu xa
			Naming.rebind("ABC", obj);
			System.out.println("Da dang ky xong doi tuong tu xa");
		}
		catch(RemoteException e) {
			System.out.println("Loi khi khoi tao hoac dang ky doi tuong tu xa");
		}
		catch(MalformedURLException e) {
			System.out.println("Sai ten dang ky"); 
		}
	}
}
