import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
class Hello extends UnicastRemoteObject implements HelloItf {
	// Ham xay dung
	public Hello() throws RemoteException {
		super();
	}
	// Dinh nghia cac ham goi tu xa
	/*
	public String sayHello() {
		return "Hello RMI";
	}
	*/
	public void sayHello() {
		System.out.println("Hello RMI");
	}
}
