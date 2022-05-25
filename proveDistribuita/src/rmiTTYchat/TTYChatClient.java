package rmiTTYchat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TTYChatClient extends Remote {
	void somethingSaid(String something) throws RemoteException;

	String name() throws RemoteException;
}
