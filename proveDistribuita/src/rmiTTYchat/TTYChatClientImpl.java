package rmiTTYchat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TTYChatClientImpl extends UnicastRemoteObject implements TTYChatClient {

	private static final long serialVersionUID = 1L;

	String name;

	public TTYChatClientImpl(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public void somethingSaid(String senderName, String something) throws RemoteException {
		System.out.println(senderName + ": " + something);

	}

	@Override
	public String name() throws RemoteException {
		return name;
	}

	public static void main(String[] args) {
		try {
			System.out.println("name? ");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String name = in.readLine();
			TTYChatClientImpl me = new TTYChatClientImpl(name);
			Registry registry = LocateRegistry.getRegistry(1099);
			TTYChat server = (TTYChat) registry.lookup("TTYCHAT");
			server.enterRoom(me);
			System.out.println("You joined the room, be kind");
			while (true) {
				server.saySomething(in.readLine(), me);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
