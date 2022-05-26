package rmiTTYchat;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TTYChatImpl extends UnicastRemoteObject implements TTYChat {

	private static final long serialVersionUID = 1L;

	List<TTYChatClient> occupants;

	protected TTYChatImpl() throws RemoteException {
		occupants = new ArrayList<>();
	}

	@Override
	public synchronized void enterRoom(TTYChatClient c) throws RemoteException {
		occupants.add(c);

	}

	@Override
	public synchronized void saySomething(String s, TTYChatClient c) throws RemoteException {
		String message = c.name() + ": " + s;
		System.out.println(Thread.currentThread() + ":Server: got " + message);
		for (Iterator<TTYChatClient> iterator = occupants.iterator(); iterator.hasNext();) {
			TTYChatClient ttyChatClient = (TTYChatClient) iterator.next();
			if (c.name().equals(ttyChatClient.name()))
				continue;
			try {
				ttyChatClient.somethingSaid(c.name(), s);
			} catch (Exception e) {
				System.out.println("Someone left");
				occupants.remove(ttyChatClient);
			}
		}

	}

	public static void main(String[] args) throws RemoteException {
		try {
			TTYChatImpl obj = new TTYChatImpl();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry = LocateRegistry.getRegistry();
			registry.rebind("TTYCHAT", obj);
			System.out.println("TTYCHAT bound in registry");
			System.out.println("server ready");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
