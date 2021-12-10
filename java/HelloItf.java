import java.rmi.Remote;
import java.rmi.RemoteException;
interface HelloItf extends Remote {
	// Khai bao cac ham goi tu xa
	// public String sayHello() throws RemoteException;
	public void sayHello() throws RemoteException;
}
