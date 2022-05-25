package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

	private static final long serialVersionUID = 1L;

	// serialization requires the class to have a default constructor method
	protected HelloImpl() throws RemoteException {
		super();
	}

	public String sayHello() throws RemoteException {
		return "Hello world";
	}

	public static void main(String[] args) {
		try {
			HelloImpl obj = new HelloImpl();
			Registry registry = LocateRegistry.createRegistry(1099);
			// registry import and bind
			registry = LocateRegistry.getRegistry();
			registry.rebind("Hello", obj);

			System.err.println("server ready");
		} catch (RemoteException e) {
			System.err.println("server exception " + e.toString());
			e.printStackTrace();
		}
	}

}
