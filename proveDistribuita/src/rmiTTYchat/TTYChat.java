package rmiTTYchat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TTYChat extends Remote {
	void enterRoom(TTYChatClient c) throws RemoteException;

	void saySomething(String s, TTYChatClient c) throws RemoteException;

}