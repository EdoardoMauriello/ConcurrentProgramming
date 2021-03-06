package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry();

			// this Hello type stub contains declarations to methods in the server
			Hello stub = (Hello) registry.lookup("Hello");
			System.out.println(stub.sayHello());
			System.out.println(stub.sayHello(new Persona("Edoardo", "pasubio", 19)));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}
}
