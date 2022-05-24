package rmiTTYchat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
	void saySomething(String s, TTYchatClient c) throws RemoteException;

	void enterRoom(TTYchatClient c) throws RemoteException;

}
